package com.example.homeInventoryMangemet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.homeInventoryMangemet.dto.ItemDTO;
import com.example.homeInventoryMangemet.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    //List<Item> findByCategory(String category); 
    
    @Query("SELECT new com.example.homeInventoryMangemet.dto.ItemDTO(i.id, i.category.name, i.price, i.quantity, i.purchaseDate, i.description,i.name) " +
    "FROM Item i " +
    "WHERE (:categoryId IS NULL OR :categoryId = -1 OR i.category.id = :categoryId)")
    List<ItemDTO> getItemsByCategory(@Param("categoryId") Long categoryId);

}