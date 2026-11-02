package com.ecom.application.controller;

import com.ecom.application.entity.User;
import com.ecom.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserController {
    private final UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllusers(){
        return ResponseEntity.ok(userService.GetAllUsers());
        //or
        // return new ResponseEntity<>(userService.GetAllUsers(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public void addUser(@RequestBody User user){
      userService.addUsers(user);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
//        if(userService.getUserById(id)==null){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(userService.getUserById(id));
        return userService.getUserById(id).map(user -> ResponseEntity.ok(user)).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user ,@PathVariable Long id){
      return userService.getUserById(id).map(Exuser ->{userService.updateUser(Exuser,user);return ResponseEntity.ok("User updated");}).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found"));
    }

}
