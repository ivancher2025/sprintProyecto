package com.bce.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bce.demo.entities.User;
import com.bce.demo.services.UserService;



@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping("/{userId}")
   public User getUser(@PathVariable("userId") Integer userId){
      return userService.getUserById(userId);
   }


   /* @GetMapping("/user/{userId}")
   public UserDto getUserDto(@PathVariable("userId") Integer userId){
    ModelMapper
      return userService.getUserById(userId);
   }*/



 @DeleteMapping("delete/{deleteUser}")
    public List<User> deleteUser(@PathVariable("deleteUser")  Integer userId){
       return userService.deleteUserId(userId);
    }


    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }

    
    @PostMapping("/update")
    public List<User> updateUsers(@RequestBody User user){
        return userService.updateUser(user);
    }

}
