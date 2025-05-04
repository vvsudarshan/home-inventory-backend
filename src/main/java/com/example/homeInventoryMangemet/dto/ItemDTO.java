package com.example.homeInventoryMangemet.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {
    private Long id;
    private String categoryName;
    private Double price;
    private Integer quantity;
    private LocalDate purchaseDate;
    private String description;
    private String itemname;
    public ItemDTO(Long id, String categoryName, Double price, Integer quantity, LocalDate purchaseDate, String description, String itemname) {
        this.id = id;
        this.categoryName = categoryName;
        this.price = price;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.description = description;
        this.itemname = itemname;
    }

    // Default constructor (important for Jackson)
    public ItemDTO() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters (optional, but useful if you need to modify the object)
    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }
    
}
