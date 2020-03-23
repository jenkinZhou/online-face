package com.jenkin.onlineface.commons.config;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class LocalDateTimeConverter extends DozerConverter<LocalDateTime, LocalDateTime> {

  public LocalDateTimeConverter() {
    super(LocalDateTime.class, LocalDateTime.class);
  }

  @Override
  public LocalDateTime convertFrom(LocalDateTime source, LocalDateTime destination) {
    return LocalDateTime.ofInstant(source.toInstant(ZoneOffset.MAX), ZoneId.systemDefault());
  }

  @Override
  public LocalDateTime convertTo(LocalDateTime source, LocalDateTime destination) {
    return LocalDateTime.from(source.atZone(ZoneId.systemDefault()).toInstant());
  }

}