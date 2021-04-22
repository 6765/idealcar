package com.github.splos.car;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.splos.car.CarView.Public;
import com.github.splos.car.CarView.WithComments;
import com.github.splos.comment.Comment;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonView(Public.class)
  private Long id;
  @JsonView(Public.class)
  @NotNull
  @Size(max = 64)
  private String model;
  @JsonView(Public.class)
  @NotNull
  @Size(max = 64)
  private String maker;
  @JsonView(Public.class)
  @NotNull
  private int power;
  @JsonView(Public.class)
  @NotNull
  private int numberOfPlaces;
  @OneToMany(mappedBy = "car")
  @JsonManagedReference
  @JsonView(WithComments.class)
  private Set<Comment> comments;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    this.maker = maker;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public int getNumberOfPlaces() {
    return numberOfPlaces;
  }

  public void setNumberOfPlaces(int numberOfPlaces) {
    this.numberOfPlaces = numberOfPlaces;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  public void setComments(Set<Comment> comments) {
    this.comments = comments;
  }
}
