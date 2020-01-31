package main.ru.epam.javacore.homework_17_date_stream.common.solutions.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class JavaTimeUtils {

    private static final String PATTERN = "dd.MM.yyyy";

    private JavaTimeUtils() {

    }

    public static LocalDate valueOf(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateStr, formatter);
    }

    public static LocalDate valueOf(String dateStr) {
        return valueOf(dateStr, PATTERN);
    }

}
