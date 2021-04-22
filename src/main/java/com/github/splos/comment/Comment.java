package com.github.splos.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.splos.car.Car;
import com.github.splos.car.CarView;
import com.github.splos.user.User;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonView(CarView.WithComments.class)
  private Long id;
  @ManyToOne(targetEntity = Car.class)
  @JsonBackReference
  @JsonView(CarView.WithComments.class)
  @NotNull
  private Car car;
  @ManyToOne(targetEntity = User.class)
  @JsonView(CarView.WithComments.class)
  @NotNull
  private User user;
  @JsonView(CarView.WithComments.class)
  @NotNull
  @Size(max = 160)
  private String comment;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
