package com.superbia.documentflow.domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Created by dmorozov on 6/23/15.
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Long> {

  @Override
  public Long convertToDatabaseColumn(LocalDate date) {
    if (date == null) {
      return null;
    }
    return date.toEpochDay();
  }

  @Override
  public LocalDate convertToEntityAttribute(Long timestamp) {
    if (timestamp == null || timestamp == 0) {
      return null;
    }

    try {
      return LocalDate.ofEpochDay(timestamp);
    } catch (DateTimeException ignored) {
      return null;
    }
  }
}
