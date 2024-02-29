package com.larseckart.sprng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @Value("${optional.config.value:}")
  String other;

  @Value("${mandatory.config.value}")
  String name;

  @RequestMapping("/")
  @ResponseBody
  String home() {
    if (!other.isEmpty()) {
      throw new IllegalStateException("optional config value will result in empty string");
    }
    return "Hello World! " + name;
  }

}
