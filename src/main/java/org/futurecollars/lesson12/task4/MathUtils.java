package org.futurecollars.lesson12.task4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathUtils {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Runnable firstTask = () -> {
            double average = numbers.stream()
                    .mapToInt(Integer::intValue)
                    .average()
                    .orElse(Double.NaN);
            System.out.println("Average: " + average);
        };

        Runnable secondTask = () -> {
            double sum = numbers.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println("Sum: " + sum);
        };

        Thread firstThread = new Thread(firstTask);
        Thread secondThread = new Thread(secondTask);

        firstThread.start();
        secondThread.start();
    }
}
