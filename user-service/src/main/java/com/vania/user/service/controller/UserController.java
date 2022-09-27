/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vania.user.service.controller;

import com.vania.user.service.dto.User;
import com.vania.user.service.service.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author HP
 */
public class UserController {
    private UserService userService;
    
    @GetMapping("/user")
    public List<SecurityProperties.User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/user/(id)")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }
    
    public ResponseEntity<Object> addUser(User user){
        userService.addUser(user);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/(id)")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }
    
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    
    @DeleteMapping("/user/(id)")
    public User deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
