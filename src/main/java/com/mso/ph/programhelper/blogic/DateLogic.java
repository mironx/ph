package com.mso.ph.programhelper.blogic;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class DateLogic {

    public static List<LocalDate> generateMondays(LocalDate referenceDate, int weekCountBefore, int weekCountAfter) {
        List<LocalDate> mondays = new ArrayList<>();

        LocalDate monday = referenceDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        for (int i = weekCountBefore; i > 0; i--) {
            mondays.add(monday.minusWeeks(i));
        }
        mondays.add(monday);

        for (int i = 1; i <= weekCountAfter; i++) {
            mondays.add(monday.plusWeeks(i));
        }
        return mondays;
    }

    public static LocalDate findMonday(LocalDate referenceDate) {
        return referenceDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
    }

    public static boolean isSameWeekAsMonday(LocalDate referenceDate, LocalDate mondayDate) {
        LocalDate mondayOfReferenceDate = referenceDate.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        return mondayOfReferenceDate.equals(mondayDate);
    }

    public static boolean isMonday(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.MONDAY;
    }
}
