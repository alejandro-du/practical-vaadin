package com.apress.practicalvaadin.ch05;

public class Product {

  private String name;

  private boolean available = true;

  public Product() {
  }

  public Product(String name, boolean available) {
    this.name = name;
    this.available = available;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

}
