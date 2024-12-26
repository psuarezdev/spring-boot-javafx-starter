package dev.pages.psuarez.spring_boot_javafx_starter;

import dev.pages.psuarez.spring_boot_javafx_starter.util.Helpers;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringBootJavafxStarterApplication extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    ApplicationContext context = SpringApplication.run(SpringBootJavafxStarterApplication.class);
    Helpers.navigateTo(context, "auth/login", "Sign In", false);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
