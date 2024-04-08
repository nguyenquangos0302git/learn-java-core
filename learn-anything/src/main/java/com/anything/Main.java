package com.anything;

import com.anything.algorithm.Interval;
import com.anything.algorithm.MergerInterval;
import com.anything.character.Characters;
import com.anything.collection.SetCollection;
import com.anything.date_time.CheckTimeIsBetween;
import com.anything.java_8.MapKeyWithDuplicateValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Set<String>> result = MapKeyWithDuplicateValue.solution();
        for (Map.Entry<String, Set<String>> rs : result.entrySet()) {
            System.out.println(rs.getKey() + " -> " + rs.getValue());
        }
    }
}