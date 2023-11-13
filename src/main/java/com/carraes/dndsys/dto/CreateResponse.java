package com.carraes.dndsys.dto;

public class CreateResponse {
  private String message;

  public CreateResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
