package com.wacevazl.date;

import com.wacevazl.WarehouseStockManagerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateExamples {

    private static final Logger log = LoggerFactory.getLogger(DateExamples.class);

    public void DateExamples(){
        LocalDate currentDate = LocalDate.now();
        log.info("Get the current date: {}", currentDate);

        LocalDate dateSpecifiedExplicitly = LocalDate.of(2018, 8, 6);
        log.info("Get the date specified: {}", dateSpecifiedExplicitly);

        LocalDate nextDay = LocalDate.now().plusDays(1);
        log.info("Get the day after the current day: {}", nextDay);

        LocalDate previousMonthDate = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        log.info("Get the previous month: {}", previousMonthDate);
    }
}
