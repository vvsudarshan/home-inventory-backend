package com.example.homeInventoryMangemet.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.homeInventoryMangemet.dto.ItemDTO;
import com.example.homeInventoryMangemet.dtos.ItemRequestDTO;
import com.example.homeInventoryMangemet.model.Category;
import com.example.homeInventoryMangemet.model.Item;
import com.example.homeInventoryMangemet.repository.CategoryRepository;
import com.example.homeInventoryMangemet.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    // public List<Item> getItemsByCategory(int category) {
    //     if (category == -1) {
    //         return itemRepository.findAll(); // Return all items
    //     } else {
    //         return itemRepository.findByCategory(category); // Return filtered items
    //     }
    //     //return itemRepository.findByCategory(category);
    // }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, ItemRequestDTO updatedItem) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            existingItem.setName(updatedItem.getName());
            existingItem.setCategory(categoryRepository.findById(updatedItem.getCategoryId())
            .orElseGet(() -> {
                Category defaultCategory = new Category();
                defaultCategory.setId(0L);
                defaultCategory.setName("Default");
                return defaultCategory;
            }));
            existingItem.setQuantity(updatedItem.getQuantity());
            existingItem.setPrice(updatedItem.getPrice());
            return itemRepository.save(existingItem);
        } else {
            return null; // Handle not found scenario
        }
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
   
    public List<ItemDTO> getItemsByCategory(Long category) {
        return itemRepository.getItemsByCategory(category);
    }
}
