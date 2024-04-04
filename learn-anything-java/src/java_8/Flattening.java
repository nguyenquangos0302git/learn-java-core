package java_8;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Flattening {

    public static Map<String, Integer> flattening() {
        // 3 maps
        Map<String, Integer> playerMap1 = new HashMap<>();
        playerMap1.put("Kai", 50);
        playerMap1.put("Liam", 30);

        Map<String, Integer> playerMap2 = new HashMap<>();
        playerMap2.put("Eric", 42);
        playerMap2.put("Kevin", 77);

        Map<String, Integer> playerMap3 = new HashMap<>();
        playerMap3.put("Saajan", 35);

        Map<String, Integer> playerMap4 = new HashMap<>();
        playerMap4.put("Kevin", 90);

        Map<String, Integer> playerMap5 = new HashMap<>();
        playerMap5.put("Kai", null);
        playerMap5.put("Jerry", null);

        return waySecond(playerMap1, playerMap2, playerMap3, playerMap4, playerMap5);
    }

    private static Map<String, Integer> wayFirst(Map<String, Integer> ... players) {
        Map<String, Integer> mergedMap = new HashMap<>();

        Stream
                .of(players)
                .flatMap(player -> player.entrySet().stream())
                .forEach(entry -> {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    if (mergedMap.containsKey(key)) {
                        mergedMap.put(key, maxInteger(mergedMap.get(key), value));
                    } else {
                        mergedMap.put(key, value);
                    }
                });

        return mergedMap;
    }

    private static Integer maxInteger(Integer int1, Integer int2) {
        if (int1 == null) return int2;
        if (int2 == null) return int1;
        return Integer.max(int1, int2);
    }

    private static Map<String, Integer> waySecond(Map<String, Integer> ... players) {
        return Stream
                .of(players)
                .flatMap(player -> player.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, reducing(null, Flattening::maxInteger))));
    }

}
