package com.github.splos.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.splos.car.CarView;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonView(CarView.WithComments.class)
  private Long id;
  @JsonView(CarView.WithComments.class)
  @NotNull
  @Size(max = 64)
  private String firstName;
  @JsonView(CarView.WithComments.class)
  @NotNull
  @Size(max = 64)
  private String lastName;
  @JsonView(CarView.WithComments.class)
  @NotNull
  @Size(max = 128)
  @Column(unique = true)
  private String email;
  @JsonIgnore
  @NotNull
  @Size(min = 8, max = 64)
  private String password;

  public User() {

  }

  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
