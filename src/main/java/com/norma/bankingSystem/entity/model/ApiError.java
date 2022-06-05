package com.norma.bankingSystem.entity.model;

import lombok.Data;

@Data
public class ApiError {
  private int status;
  private String message;

}
