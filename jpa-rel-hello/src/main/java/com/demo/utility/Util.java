package com.demo.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

  public static LocalDate date(String s) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.parse(s, formatter);
    return localDate;
  }
}

