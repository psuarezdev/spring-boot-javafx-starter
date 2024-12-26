package dev.pages.psuarez.spring_boot_javafx_starter.util;

import dev.pages.psuarez.spring_boot_javafx_starter.SpringBootJavafxStarterApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.regex.Pattern;

public class Helpers {
  public static Object navigateTo(ApplicationContext springContext, String fxml, String title, boolean resizable) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SpringBootJavafxStarterApplication.class.getResource("/views/" + fxml + ".fxml"));
    fxmlLoader.setControllerFactory(springContext::getBean);
    Scene scene = new Scene(fxmlLoader.load());

    Stage stage = new Stage();
    stage.setTitle(title);
    stage.setResizable(resizable);
    stage.setScene(scene);
    stage.show();

    return fxmlLoader.getController();
  }

  public static Object navigateTo(ApplicationContext springContext, String fxml, String title, boolean resizable, int width, int height) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(SpringBootJavafxStarterApplication.class.getResource("/views/" + fxml + ".fxml"));
    fxmlLoader.setControllerFactory(springContext::getBean);
    Scene scene = new Scene(fxmlLoader.load(), width, height);

    Stage stage = new Stage();
    stage.setTitle(title);
    stage.setResizable(resizable);
    stage.setScene(scene);
    stage.show();

    return fxmlLoader.getController();
  }

  public static void hideWindow(Control control) {
    control.getScene().getWindow().hide();
  }

  public static void showAlert(Alert.AlertType type, String title, String header, String content) {
    Alert alert = new Alert(type);
    if (title != null) alert.setTitle(title);
    if (header != null) alert.setHeaderText(header);
    if (content != null) alert.setContentText(content);
    alert.showAndWait();
  }

  public static boolean isEmailValid(String email) {
    return Pattern.compile(
        "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
        Pattern.CASE_INSENSITIVE
      )
      .matcher(email)
      .matches();
  }

  /**
   * Regex: ^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$
   * Has minimum 8 characters in length. Adjust it by modifying {8,}
   * At least one uppercase English letter. You can remove this condition by removing (?=.*?[A-Z])
   * At least one lowercase English letter.  You can remove this condition by removing (?=.*?[a-z])
   * At least one digit. You can remove this condition by removing (?=.*?[0-9])
   * At least one special character,  You can remove this condition by removing (?=.*?[#?!@$%^&*-])
   */
  public static boolean isPasswordValid(String password) {
    return Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$")
      .matcher(password)
      .matches();
  }
}