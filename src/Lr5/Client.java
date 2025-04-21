package Lr5;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        int size = 5;
        String sep = "------";
        Random random = new Random();

        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(size);

        for (int i = 0; i < size; i++) {
            hashTable.insert(random.nextInt(1, 50));
        }

        System.out.println("Хэш-таблица перед вставкой:");
        hashTable.displayTable();
        System.out.println(sep);

        // Вставка дополнительного элемента, чтобы вызвать расширение
        hashTable.insert(20);

        System.out.println("Хэш-таблица после вставки:");
        hashTable.displayTable();
        System.out.println(sep);

        // Поиск элемента
        int searchKey = 20;
        int found = hashTable.find(searchKey);
        if (found != -1) {
            System.out.println("Найден ключ: " + found);
        } else {
            System.out.println("Ключ " + searchKey + " не найден.");
        }
        System.out.println(sep);

        // Удаление элемента
        hashTable.delete(20);
        System.out.println("Хэш-таблица после удаления ключа 20:");
        hashTable.displayTable();
    }
}