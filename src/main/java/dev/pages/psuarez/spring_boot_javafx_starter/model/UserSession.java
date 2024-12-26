package dev.pages.psuarez.spring_boot_javafx_starter.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public class UserSession {
  private User user;
  private LocalDateTime loggedAt = LocalDateTime.now();
}
