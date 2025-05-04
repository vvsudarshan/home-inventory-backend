package com.example.homeInventoryMangemet.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequestDTO {
    private String name;
    private int quantity;
    private double price;
    private String description;
    private String purchaseDate;
    private Long categoryId; 
}
