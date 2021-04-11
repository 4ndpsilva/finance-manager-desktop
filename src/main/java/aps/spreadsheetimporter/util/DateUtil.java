package aps.spreadsheetimporter.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {
    private static final String DATE_PATTERN              = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    public static String format(final LocalDate date){
        return date == null ? null : DATE_FORMATTER.format(date);
    }

    public static LocalDate parse(final String value){
        try {
            return DATE_FORMATTER.parse(value, LocalDate::from);
        }
        catch (DateTimeParseException ex){
            return null;
        }
    }

    public static boolean validDate(final String value){
        return parse(value) != null;
    }
}