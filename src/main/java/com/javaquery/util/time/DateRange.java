package com.javaquery.util.time;

import java.util.Date;

/**
 * @author vicky.thakor
 * @since 1.0
 */
public final class DateRange {

    private Date startDate;
    private Date endDate;

    private DateRange() {
    }

    public DateRange(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DateRange(Date startDate) {
        this(startDate, new Date());
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
