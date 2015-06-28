package com.superbia.documentflow.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dmorozov on 6/23/15.
 */
@Controller
public class HomeController {

  @RequestMapping("/")
  public String index() {
    return "index.html";
  }
}
