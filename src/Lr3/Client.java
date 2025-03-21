package Lr3;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 500000;
        long start, end;
        String sep = "----------";
        QuickSort array = new QuickSort(size);
        ShellSort_Knuth prinik = new ShellSort_Knuth(size);
        MergeSort merch = new MergeSort(size);


        for (int i = 0; i < size; i++) {
            array.insert(random.nextLong(100000));
            prinik.insert(random.nextLong(100000));
            merch.insert(random.nextLong(100000));
        }

        //array.display();
        start = System.currentTimeMillis();
        array.sort();
        end = System.currentTimeMillis();
        //array.display();
        System.out.println("Quick");
        System.out.printf("Кол-во сравнений: %d \n", array.getComparisonCount());
        System.out.printf("Кол-во перестановок: %d \n", array.getSwapCount());
        System.out.printf("Время выполнения: %d мс \n", end - start);

        System.out.println(sep);

        //prinik.display();
        start = System.currentTimeMillis();
        prinik.sort();
        end = System.currentTimeMillis();
        //prinik.display();
        System.out.println("Shell");
        System.out.printf("Кол-во сравнений: %d \n", prinik.getComparisonCount());
        System.out.printf("Кол-во перестановок: %d \n", prinik.getSwapCount());
        System.out.printf("Время выполнения: %d мс \n", end - start);

        System.out.println(sep);

        //merch.display();
        start = System.currentTimeMillis();
        merch.sort();
        end = System.currentTimeMillis();
        //merch.display();
        System.out.println("Merge");
        System.out.printf("Кол-во сравнений: %d \n", merch.getComparisonCount());
        System.out.printf("Кол-во перестановок: %d \n", merch.getSwapCount());
        System.out.printf("Время выполнения: %d мс \n", end - start);
    }
}