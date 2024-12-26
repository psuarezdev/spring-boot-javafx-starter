package dev.pages.psuarez.spring_boot_javafx_starter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HomeController {

  @Autowired
  private ApplicationContext context;
}
