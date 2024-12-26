package dev.pages.psuarez.spring_boot_javafx_starter.repository;

import dev.pages.psuarez.spring_boot_javafx_starter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
