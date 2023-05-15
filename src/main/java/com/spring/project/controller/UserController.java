package com.spring.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.project.entity.User;
import com.spring.project.sevice.userService;

@RestController
public class UserController {

  @Autowired
  userService uService;

  @GetMapping("/user")
  public List<User> getAllUsers(){
    
    return uService.getUsers();

  }

  @PostMapping("/user")
  public void addUser(@RequestBody User user){
    uService.addUser(user.getName().toString(),user.getEmail().toString());
  }
	
	
	
}
