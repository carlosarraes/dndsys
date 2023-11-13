package com.carraes.dndsys.exceptions;

public class ItemInUseException extends RuntimeException {
  public ItemInUseException(String message) {
    super(message);
  }
}
