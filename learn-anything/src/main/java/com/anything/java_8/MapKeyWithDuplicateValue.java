package com.anything.java_8;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class MapKeyWithDuplicateValue {
    static Map<String, String> INPUT_MAP = new HashMap<>();
    static Map<String, String> INPUT_MAP_WITH_NULLS = new HashMap<>();

    static {
        INPUT_MAP = Map.of(
                "Kai", "Linux",
                "Eric", "MacOS",
                "Kevin", "Windows",
                "Liam", "MacOS",
                "David", "Linux",
                "Saajan", "Windows",
                "Loredana", "MacOS"

        );
        INPUT_MAP_WITH_NULLS = new HashMap<String, String>(INPUT_MAP) {{
            put("Tom", null);
            put("Jerry", null);
            put(null, null);
        }};
    }

    public static Map<String, Set<String>> solution() {
        return solution5();
    }

    private static Map<String, Set<String>> solution1() {
        Map<String, Set<String>> rs = new HashMap<>();

        for (Map.Entry<String, String> entry : INPUT_MAP_WITH_NULLS.entrySet()) {
            if (!rs.containsKey(entry.getValue())) {
                rs.put(entry.getValue(), new HashSet<>());
            }
            rs.get(entry.getValue()).add(entry.getKey());
        }

        return rs;
    }

    private static Map<String, Set<String>> solution2() {
        return INPUT_MAP_WITH_NULLS
                .entrySet()
                .stream()
                .collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toSet())));
    }

    private static Map<String, Set<String>> solution3() {
        Map<String, Set<String>> rs = new HashMap<>();

        INPUT_MAP_WITH_NULLS.forEach((key, value) -> rs.computeIfAbsent(value, k -> new HashSet<>()).add(key));

        return rs;
    }


    private static Map<String, Set<String>> solution4() {
        return INPUT_MAP_WITH_NULLS
                .entrySet()
                .stream()
                .collect(collectingAndThen(Multimaps.toMultimap(Map.Entry::getValue, Map.Entry::getKey, HashMultimap::create), Multimaps::asMap));
    }

    private static Map<String, Set<String>> solution5() {
        SetMultimap<String, String> multiMapWithNulls = Multimaps.invertFrom(Multimaps.forMap(INPUT_MAP_WITH_NULLS), HashMultimap.create());
        return Multimaps.asMap(multiMapWithNulls);
    }


}
