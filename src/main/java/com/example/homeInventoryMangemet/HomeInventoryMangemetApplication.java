package com.example.homeInventoryMangemet;

import java.util.Base64;

import javax.crypto.SecretKey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class HomeInventoryMangemetApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeInventoryMangemetApplication.class, args);
		System.out.println("Servr is up u can start it ur work...!!!!");
		SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Generated Secret Key: " + base64Key);
    }
	

}
