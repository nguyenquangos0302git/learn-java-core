package com.anything.date_time;

import java.time.LocalTime;

public class CheckTimeIsBetween {

    public static boolean checkTimeIsBetweenWay1() {
        LocalTime startTime = LocalTime.parse("09:00:00");
        LocalTime endTime = LocalTime.parse("17:00:00");
        LocalTime targetTime = LocalTime.parse("12:30:00");

        return targetTime.isAfter(startTime) && targetTime.isBefore(endTime);
    }

    public static boolean checkTimeIsBetweenWay2() {
        LocalTime startTime = LocalTime.parse("09:00:00");
        LocalTime endTime = LocalTime.parse("17:00:00");
        LocalTime targetTime = LocalTime.parse("09:00:00");

        return targetTime.compareTo(startTime) >= 0 && targetTime.compareTo(endTime) <= 0;
    }

}
