package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        if (numbers == null || numbers.isEmpty()) {
            return result;
        }

        for (Integer number : numbers) {
            if (number != null && number % 2 == 0) {
                result.add(number);
            }
        }
        return result;
    }

}
