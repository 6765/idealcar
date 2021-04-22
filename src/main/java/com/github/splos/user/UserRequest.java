package com.github.splos.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequest {

  @NotNull
  @Size(max = 64)
  private String firstName;
  @NotNull
  @Size(max = 64)
  private String lastName;
  @NotNull
  @Size(max = 128)
  private String email;
  @NotNull
  @Size(min = 8, max = 64)
  private String password;

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
