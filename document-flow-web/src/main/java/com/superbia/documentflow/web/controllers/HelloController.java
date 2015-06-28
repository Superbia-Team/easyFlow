package com.superbia.documentflow.web.controllers;

import com.superbia.documentflow.domain.User;
import com.superbia.documentflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/hello")
  @Transactional(readOnly = true)
  public String helloWorld() {
    List<User> users = userRepository.findActive();
    return "count: " + users.size();
  }
}