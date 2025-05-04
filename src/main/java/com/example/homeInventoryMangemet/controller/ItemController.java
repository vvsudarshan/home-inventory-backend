package com.example.homeInventoryMangemet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.homeInventoryMangemet.dto.ItemDTO;
import com.example.homeInventoryMangemet.dtos.ItemRequestDTO;
import com.example.homeInventoryMangemet.model.Item;
import com.example.homeInventoryMangemet.repository.CategoryRepository;
import com.example.homeInventoryMangemet.service.ItemService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import com.example.homeInventoryMangemet.model.Category;

@RestController
@RequestMapping("/api/items")
@CrossOrigin("*") // Allows frontend (React) requests
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    CategoryRepository categoryRepository;

    // 1️⃣ Get all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // 2️⃣ Get item by ID
    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    // // 3️⃣ Get items by category
    // @GetMapping("/category/{category}")
    // public List<Item> getItemsByCategory(@PathVariable String category) {
    //     return itemService.getItemsByCategory(category);
    // }

    // 4️⃣ Add new item
    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDTO itemRequest) {
        // Fetch the category from the database
        Category category = categoryRepository.findById(itemRequest.getCategoryId())
                .orElseGet(() -> {
                    Category defaultCategory = new Category();
                    defaultCategory.setId(0L);
                    defaultCategory.setName("Default");
                    return defaultCategory;
                });

        // Create a new Item and set its properties
        Item newItem = new Item();
        newItem.setName(itemRequest.getName());
        newItem.setQuantity(itemRequest.getQuantity());
        newItem.setPrice(itemRequest.getPrice());
        newItem.setPurchaseDate(LocalDate.parse(itemRequest.getPurchaseDate())); // Ensure the date is parsed correctly
        newItem.setPurchaseDate(LocalDate.parse(itemRequest.getPurchaseDate()));
        newItem.setCategory(category); // Set category before saving

        // Save the Item to the database
        Item savedItem = itemService.addItem(newItem);
        return ResponseEntity.ok(savedItem);
    }

    // 5️⃣ Update item
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody ItemRequestDTO updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }

    // 6️⃣ Delete item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/by-category")
    public List<ItemDTO> getItemsByCategory(@RequestParam(defaultValue = "-1") Long category) {
        return itemService.getItemsByCategory(category);
    }





}
