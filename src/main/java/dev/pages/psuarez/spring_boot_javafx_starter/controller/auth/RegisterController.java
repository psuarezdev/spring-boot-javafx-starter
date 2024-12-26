package dev.pages.psuarez.spring_boot_javafx_starter.controller.auth;

import dev.pages.psuarez.spring_boot_javafx_starter.model.User;
import dev.pages.psuarez.spring_boot_javafx_starter.service.AuthService;
import dev.pages.psuarez.spring_boot_javafx_starter.util.Helpers;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.security.auth.login.CredentialException;
import java.io.IOException;

@Component
public class RegisterController {

  @Autowired
  private ApplicationContext context;

  @Autowired
  private AuthService authService;

  @FXML
  private TextField firstName, lastName, email;

  @FXML
  private PasswordField password;

  @FXML
  protected void onSumbit() {
    try {
      User user = authService.register(
        firstName.getText(),
        lastName.getText(),
        email.getText(),
        password.getText()
      );

      if (user == null) {
        throw new CredentialException("Something went wrong, please try again");
      }

      Helpers.hideWindow(email);
      Helpers.navigateTo(context, "home", "Home", false);
    } catch (CredentialException e) {
      Helpers.showAlert(Alert.AlertType.ERROR, "Error", null, e.getMessage());
    } catch (IOException e) {
      Helpers.showAlert(Alert.AlertType.ERROR, "Error", null, "Error navigating to home");
    }
  }

  @FXML
  protected void goToSignIn() {
    try {
      Helpers.hideWindow(email);
      Helpers.navigateTo(context, "auth/login", "Sign In", false);
    } catch (IOException e) {
      Helpers.showAlert(Alert.AlertType.ERROR, "Error", null, "Error navigating to login");
    }
  }
}
