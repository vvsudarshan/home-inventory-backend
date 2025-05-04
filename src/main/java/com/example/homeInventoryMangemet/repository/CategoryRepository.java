package com.example.homeInventoryMangemet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.homeInventoryMangemet.model.Category;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @SuppressWarnings("null")
    Optional<Category> findById(Long id);
}