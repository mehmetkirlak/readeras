package com.narval.readeras.controller;

import com.narval.readeras.dto.userdto.UserCreationDTO;
import com.narval.readeras.dto.userdto.UserCreationRequest;
import com.narval.readeras.dto.userdto.UserDTO;
import com.narval.readeras.dto.userdto.UserUpdationRequest;
import com.narval.readeras.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreationRequest userCreationRequest){
        return ResponseEntity.ok(userService.createUser(userCreationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,@RequestBody UserUpdationRequest userUpdationRequest){
        return ResponseEntity.ok(userService.updateUser(id, userUpdationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
