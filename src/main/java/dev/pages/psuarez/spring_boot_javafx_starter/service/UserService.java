package dev.pages.psuarez.spring_boot_javafx_starter.service;

import dev.pages.psuarez.spring_boot_javafx_starter.model.User;
import dev.pages.psuarez.spring_boot_javafx_starter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public Optional<User> findById(Long id) {
    return repository.findById(id);
  }

  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  public User save(User user) {
    return repository.save(user);
  }

  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
