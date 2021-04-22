package com.github.splos.comment;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentRequest {

  @NotNull
  @Size(max = 160)
  private String comment;

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
