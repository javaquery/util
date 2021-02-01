package com.javaquery.util.time;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public class TestDateRange {

    @Test
    public void test_constructor() {
        Date startDate = new Date();
        Date endDate = new Date();

        DateRange dateRange = new DateRange(startDate, endDate);
        Assertions.assertEquals(startDate, dateRange.getStartDate());
        Assertions.assertEquals(endDate, dateRange.getEndDate());
    }

    @Test
    public void test_constructor_1() {
        Date startDate = new Date();

        DateRange dateRange = new DateRange(startDate);
        Assertions.assertEquals(startDate, dateRange.getStartDate());
        Assertions.assertNotNull(dateRange.getEndDate());
    }
}
