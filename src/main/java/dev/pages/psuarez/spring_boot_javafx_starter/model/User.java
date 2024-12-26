package dev.pages.psuarez.spring_boot_javafx_starter.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "first_name")
  @NotBlank(message = "FirstName is required")
  @Length(min = 3, message = "FirstName must have at least 3 characters")
  private String firstName;

  @Column(nullable = false, name = "last_name")
  @NotBlank(message = "LastName is required")
  @Length(min = 3, message = "LastName must have at least 3 characters")
  private String lastName;

  @Column(nullable = false, unique = true)
  @NotBlank(message = "Email is required")
  @Email(message = "Email does not have a valid format")
  private String email;

  @Column(nullable = false)
  @NotBlank(message = "Password is required")
  @Length(min = 6, message = "Pasword must have at least 6 characters")
  private String password;

  private String avatar;
}
