package com.mypieceofcode.recommendation.correlation;

import reactor.core.publisher.Flux;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Correlation {

    public static double measure(Map<String, Integer> firstProfile, Map<String, Integer> secondProfile) {
        double sumA = 0;
        double sumC = 0;
        double sumD = 0;
        int counter = 0;
        Integer[] firstSorted = new Integer[firstProfile.size()];
        Integer[] secondSorted = new Integer[secondProfile.size()];
        TreeMap<String, Integer> sortedFirst = new TreeMap<>(firstProfile);
        TreeMap<String, Integer> sortedSecond = new TreeMap<>(secondProfile);

        for (Map.Entry<String, Integer> entry : sortedFirst.entrySet()) {
            firstSorted[counter] = entry.getValue();
            counter++;
        }
        counter = 0;

        for (Map.Entry<String, Integer> entry : sortedSecond.entrySet()) {
            secondSorted[counter] = entry.getValue();
            counter++;
        }

        for (int i = 0; i < firstSorted.length; i++) {
            double tempA = firstSorted[i];
            double tempB = secondSorted[i];
            double tempC = Math.pow(tempA, 2);
            double tempD = Math.pow( tempB, 2);

            sumA = sumA + (tempA * tempB);
            sumC += tempC;
            sumD += tempD;
        }

        return sumA/(Math.sqrt(sumC) * Math.sqrt(sumD));
    }

}
