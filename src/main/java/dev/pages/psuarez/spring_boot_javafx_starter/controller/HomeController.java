package dev.pages.psuarez.spring_boot_javafx_starter.controller;

import dev.pages.psuarez.spring_boot_javafx_starter.model.User;
import dev.pages.psuarez.spring_boot_javafx_starter.model.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

@Component
public class HomeController implements Initializable {

  @Autowired
  private ApplicationContext context;

  @Autowired
  private UserSession userSession;

  @FXML
  private Label message;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    User authUser = userSession.getUser();
    message.setText("Hello, " + authUser.getFirstName() + " " + authUser.getLastName() + "!");
  }
}
