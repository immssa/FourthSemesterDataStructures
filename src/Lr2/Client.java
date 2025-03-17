package Lr2;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 100000;
        long start, end;
        String sep = "----------";
        QuickSortArray array = new QuickSortArray(size);
        QuickSortArrayNoRecursion without = new QuickSortArrayNoRecursion(size);

        for (int i = 0; i < size; i++) {
            array.insert(random.nextLong(100000));
            without.insert(random.nextLong(100000));
        }

        //array.display();
        start = System.currentTimeMillis();
        array.sort();
        end = System.currentTimeMillis();
        //System.out.println(sep);
        //array.display();
        array.getSwapCount();
        System.out.printf("Время выполнения: %d мс \n", end - start);

        System.out.println(sep);

        //without.display();
        start = System.currentTimeMillis();
        without.sort();
        end = System.currentTimeMillis();
        //System.out.println(sep);
        //without.display();
        without.getSwapCount();
        System.out.printf("Время выполнения: %d мс \n", end - start);
    }
}