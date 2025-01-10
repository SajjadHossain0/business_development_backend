package com.business_development_backend.business_development_backend.Admin.Controllers;

import com.business_development_backend.business_development_backend.Admin.Components.JwtTokenUtil;
import com.business_development_backend.business_development_backend.Admin.Entities.LoginRequest;
import com.business_development_backend.business_development_backend.Admin.Entities.User;
import com.business_development_backend.business_development_backend.Admin.Services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserDataService userDataService; // Change to UserDataService for registration and login
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    // Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String response = userDataService.register(user);
        return ResponseEntity.ok(response);
    }

    // Log in an existing user and return JWT token
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginRequest loginRequest) {
        try {
            String token = userDataService.login(loginRequest.getEmail(), loginRequest.getPassword());
            // Retrieve the user object
            User user = userDataService.getUserByEmail(loginRequest.getEmail())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (!user.getRole().equals("ADMIN")) {
                return ResponseEntity.status(403).body(Map.of("message", "Access denied: Only admins can log in."));
            }

            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            response.put("userId", String.valueOf(user.getId())); // add userId to response

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(Map.of("message", "User not found"));
        }
    }

}
