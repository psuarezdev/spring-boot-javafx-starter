package dev.pages.psuarez.spring_boot_javafx_starter.service;

import dev.pages.psuarez.spring_boot_javafx_starter.model.User;
import dev.pages.psuarez.spring_boot_javafx_starter.model.UserSession;
import dev.pages.psuarez.spring_boot_javafx_starter.util.Helpers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
  private final UserSession userSession;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  public User login(String email, String password) throws CredentialException {
    User user = userService.findByEmail(email).orElse(null);

    if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
      throw new CredentialException("Wrong credentials");
    }

    userSession.setUser(user);
    return user;
  }

  public User register(String firstName, String lastName, String email, String password) throws CredentialException {
    if (firstName.trim().length() < 3) {
      throw new CredentialException("First Name must have at least 3 characters long");
    }

    if (lastName.trim().length() < 3) {
      throw new CredentialException("Last Name must have at least 3 characters long");
    }

    if (!Helpers.isEmailValid(email)) {
      throw new CredentialException("Invalid email address");
    }

    if (!Helpers.isPasswordValid(password)) {
      throw new CredentialException("Password must have at least 8 characters long, a capital letter and a number");
    }

    Optional<User> userFound = userService.findByEmail(email);

    if (userFound.isPresent()) {
      throw new CredentialException("User with email " + email + "already exists");
    }

    String passwordHash = passwordEncoder.encode(password);

    User user = userService.save(
      User.builder()
        .firstName(firstName)
        .lastName(lastName)
        .email(email)
        .password(passwordHash)
        .build()
    );

    userSession.setUser(user);
    return user;
  }
}
