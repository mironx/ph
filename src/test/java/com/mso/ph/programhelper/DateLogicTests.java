package com.mso.ph.programhelper;

import com.mso.ph.programhelper.blogic.DateLogic;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DateLogicTests {

    @Test
    public void testGenerateMondaysAroundReferenceDate() {
        LocalDate referenceDate = LocalDate.of(2023, 11, 19);
        int weekCountBefore = 2;
        int weekCountAfter = 2;

        List<LocalDate> expectedMondays = List.of(
                LocalDate.of(2023, 10, 30),
                LocalDate.of(2023, 11, 6),
                LocalDate.of(2023, 11, 13),
                LocalDate.of(2023, 11, 20),
                LocalDate.of(2023, 11, 27)
        );

        List<LocalDate> actualMondays = DateLogic.generateMondays(referenceDate, weekCountBefore, weekCountAfter);
        assertEquals(expectedMondays, actualMondays, "Mondays generated around the reference date are incorrect");
    }

    @Test
    public void testGenerateMondaysWhenWeekCountsAreZero() {
        LocalDate referenceDate = LocalDate.of(2023, 11, 19);

        List<LocalDate> expectedMondays = List.of(
                LocalDate.of(2023, 11, 13) // Only the Monday of the reference week
        );

        List<LocalDate> actualMondays = DateLogic.generateMondays(referenceDate, 0, 0);
        assertEquals(expectedMondays, actualMondays, "Mondays generated when week counts are zero are incorrect");
    }

    @Test
    public void testGenerateMondaysWhenReferenceDateIsMonday() {
        LocalDate referenceDate = LocalDate.of(2023, 11, 13); // This is a Monday

        List<LocalDate> expectedMondays = List.of(
                LocalDate.of(2023, 10, 30),
                LocalDate.of(2023, 11, 6),
                LocalDate.of(2023, 11, 13),
                LocalDate.of(2023, 11, 20),
                LocalDate.of(2023, 11, 27)
        );

        List<LocalDate> actualMondays = DateLogic.generateMondays(referenceDate, 2, 2);
        assertEquals(expectedMondays, actualMondays, "Mondays generated when reference date is a Monday are incorrect");
    }

    @Test
    public void testFindMondayForMondayDate() {
        LocalDate mondayDate = LocalDate.of(2023, 11, 13); // Poniedziałek
        LocalDate expectedMonday = LocalDate.of(2023, 11, 13);
        assertEquals(expectedMonday, DateLogic.findMonday(mondayDate));
    }

    @Test
    public void testFindMondayForNonMondayDate() {
        LocalDate nonMondayDate = LocalDate.of(2023, 11, 15); // Wednesday
        LocalDate expectedMonday = LocalDate.of(2023, 11, 13);
        assertEquals(expectedMonday, DateLogic.findMonday(nonMondayDate));
    }

    @Test
    public void testIsSameWeekAsMondayForSameWeek() {
        LocalDate mondayDate = LocalDate.of(2023, 11, 13); // Monday
        LocalDate referenceDate = LocalDate.of(2023, 11, 15); // Wednesday the same week
        assertTrue(DateLogic.isSameWeekAsMonday(referenceDate, mondayDate));
    }

    @Test
    public void testIsSameWeekAsMondayForDifferentWeek() {
        LocalDate mondayDate = LocalDate.of(2023, 11, 13); // Monday
        LocalDate referenceDate = LocalDate.of(2023, 11, 20); // Monday next week
        assertFalse(DateLogic.isSameWeekAsMonday(referenceDate, mondayDate));
    }

    @Test
    public void testIsMondayForMonday() {
        LocalDate monday = LocalDate.of(2023, 11, 13); // Poniedziałek
        assertTrue(DateLogic.isMonday(monday));
    }

    @Test
    public void testIsMondayForNonMonday() {
        LocalDate notMonday = LocalDate.of(2023, 11, 14); // Wtorek
        assertFalse(DateLogic.isMonday(notMonday));
    }

}
