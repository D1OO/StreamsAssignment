package net.shvdy;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random r = new Random();
        int k = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(99) + 1;
        }

        Arrays.stream(numbers).forEach(s -> System.out.print(s + " "));
        System.out.print("\n\n" + ++k + ") Average:");
        System.out.print("\n" + Arrays.stream(numbers).average().getAsDouble());
        System.out.print("\n" + Arrays.stream(numbers).summaryStatistics().getAverage());
        System.out.print("\n" + (double) Arrays.stream(numbers).sum() / numbers.length);

        System.out.print("\n\n" + ++k + ") Min:");


        int[] minElemIndexAndVal = IntStream.of(
                Arrays.stream(numbers).boxed()
                        .collect(Collectors.toList())
                        .indexOf(Arrays.stream(numbers).min().getAsInt()),
                Arrays.stream(numbers).min().getAsInt()).toArray();
        System.out.print("\n[" + minElemIndexAndVal[0] + "]: " + minElemIndexAndVal[1]);

        System.out.print("\n\n" + ++k + ") == 0:");
        System.out.print("\n" + Arrays.stream(numbers).filter(i -> i == 0).count());

        System.out.print("\n\n" + ++k + ") > 0:");
        System.out.print("\n" + Arrays.stream(numbers).filter(i -> i > 0).count());

        System.out.println("\n\nMultiply array's elements by:");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        System.out.print("\n");
        Arrays.stream(numbers).map(i -> i * m).forEach(s -> System.out.print(s + " "));
        
    }
}
