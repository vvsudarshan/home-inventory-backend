package com.example.homeInventoryMangemet.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.homeInventoryMangemet.model.User;
import com.example.homeInventoryMangemet.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private  UserService  userService;
    @GetMapping("/{id}")
  //  @PreAuthorize("isAuthenticated()") // ✅ Allows any logged-in user
    public ResponseEntity<?> getUserDetails(@PathVariable Long id) {
        Optional<User> user = userService.findById(id);
        
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // ✅ Return user details
        } else {
            return ResponseEntity.status(404).body("User not found with ID: " + id); // ✅ Return 404 response
        }
    }
    


    
}
