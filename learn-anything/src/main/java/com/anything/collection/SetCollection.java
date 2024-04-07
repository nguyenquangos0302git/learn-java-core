package com.anything.collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.SetUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetCollection {

    public static boolean setCollection() {
        Set<String> cities = new HashSet<>();

        cities.add("Paris");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Tamassint");
        cities.add("New york");

        return containsAny(cities);
    }

    public static Set<String> setCollection1() {
        Set<String> cities = new HashSet<>();

        cities.add("Paris");
        cities.add("London");
        cities.add("Tokyo");
        cities.add("Tamassint");
        cities.add("New york");

        return intersection(cities);
    }

    private static boolean disJoint(Set<String> cities) {
        Set<String> citiesJoint = new HashSet<>();

        citiesJoint.add("Paris1");

        return !Collections.disjoint(cities, citiesJoint);
    }

    private static boolean containsAny(Set<String> cities) {
        Set<String> citiesJoint = new HashSet<>();

        citiesJoint.add("Paris1");
        citiesJoint.add("Paris");

        return CollectionUtils.containsAny(cities, citiesJoint);
    }

    private static Set<String> intersection(Set<String> cities) {
        Set<String> citiesJoint = new HashSet<>();

        citiesJoint.add("Paris1");
        citiesJoint.add("Paris");
        citiesJoint.add("Tokyo");

        return SetUtils.intersection(cities, citiesJoint);
    }

}
