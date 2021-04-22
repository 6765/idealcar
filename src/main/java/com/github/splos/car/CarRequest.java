package com.github.splos.car;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.splos.car.CarView.Public;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarRequest {

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
}
