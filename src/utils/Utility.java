package utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Shuffling idea: https://www.digitalocean.com/community/tutorials/shuffle-array-java
 */
public class Utility {
    public static Integer[] generateArray(int size) {
        Integer[] arr = new Integer[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        List<Integer> toList = Arrays.asList(arr);
        Collections.shuffle(toList);

        toList.toArray(arr);
        return arr;
    }
    public static Integer[] generateRandomArray(int size) {
        Integer[] arr = new Integer[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * size * 1000);
        }

        List<Integer> toList = Arrays.asList(arr);
        Collections.shuffle(toList);

        toList.toArray(arr);
        return arr;
    }
}
