package com.anything.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergerInterval {

    public static List<Interval> mergerd() {
        List<Interval> intervalsOriginal = Arrays.asList(
                new Interval(2, 5),
                new Interval(11, 15),
                new Interval(1, 4),
                new Interval(13, 20)
        );


        intervalsOriginal.sort(Comparator.comparingInt(Interval::getStart));

        List<Interval> mergedInterval = new ArrayList<>();
        mergedInterval.add(intervalsOriginal.get(0));

        intervalsOriginal.forEach(interval -> {
            if (mergedInterval.get(mergedInterval.size() - 1).getEnd() > interval.getStart()) {
                mergedInterval.get(mergedInterval.size() - 1).setEnd(interval.getEnd());
            } else {
                mergedInterval.add(interval);
            }
        });

        return mergedInterval;
    }

}
