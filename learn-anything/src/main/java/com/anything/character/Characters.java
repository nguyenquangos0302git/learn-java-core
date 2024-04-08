package com.anything.character;

import org.apache.commons.lang3.StringUtils;

public class Characters {

    public static String getCharacter() {
        String s = "10-03-2024";
        int n = 4;

        return getCharacter2(s, n);
    }

    private static String getCharacter1(String s, int index) {
        int beginIndex = s.length() - index;
        return s.substring(beginIndex, s.length());
    }

    private static String getCharacter2(String s, int index) {
        return StringUtils.right(s, index);
    }

}
