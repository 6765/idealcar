package com.github.splos.user;

public class UserCreationResponse {

  private Long id;
  private String accessToken;

  public UserCreationResponse(User user, String accessToken) {
    this.id = user.getId();
    this.accessToken = accessToken;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}
