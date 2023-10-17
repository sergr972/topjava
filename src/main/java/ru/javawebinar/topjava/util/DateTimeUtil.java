package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static <T extends Comparable<T>> boolean isBetweenHalfOpen(T value, T startTime, T endTime) {
        return (startTime == null || value.compareTo(startTime) >= 0) && (endTime == null || value.compareTo(endTime) < 0);
    }

    public static LocalDateTime getDateOrMin(LocalDate localDate) {
        return localDate != null ? localDate.atStartOfDay() : LocalDateTime.of(LocalDate.MIN, LocalTime.MIN);
    }

    public static LocalDateTime getDateOrMax(LocalDate localDate) {
        return localDate != null ? localDate.plusDays(1).atStartOfDay() : LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);
    }

    public static LocalDate parseLocalDate(String str) {
        return str == null || str.isEmpty() ? null : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(String str) {
        return str == null || str.isEmpty() ? null : LocalTime.parse(str);
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}

