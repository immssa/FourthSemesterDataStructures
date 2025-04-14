package Lr5;

public class QuadraticProbingHashTable {
    private int[] hashArray;      // массив для хранения ключей
    private int arraySize;        // размер массива
    private int count;            // общее число элементов в таблице
    private final double loadFactor = 0.75; // порог загрузки
    private final int DELETED = Integer.MIN_VALUE; // маркер для удалённых элементов

    public QuadraticProbingHashTable(int size) {
        arraySize = size;
        hashArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = -1;    // инициализация пустых ячеек значением -1
        }
        count = 0;
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            if (hashArray[j] != -1 && hashArray[j] != DELETED) {
                System.out.print(hashArray[j] + " ");
            } else {
                System.out.print("*** ");
            }
            System.out.println();
        }
    }

    public int hashFunc(int key) {
        return Math.abs(key) % arraySize;
    }

    public void insert(int key) {
        int hashVal = hashFunc(key);
        int step = 1;
        int probeIndex = hashVal;

        while (hashArray[probeIndex] != -1 && hashArray[probeIndex] != DELETED) {
            probeIndex = (hashVal + step * step) % arraySize;
            step++;
            if (step > arraySize) {
                System.out.println("Таблица полна, невозможно вставить элемент " + key);
                return;
            }
        }

        hashArray[probeIndex] = key;
        count++;

        if (count > arraySize * loadFactor) {
            resize();
        }
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        int step = 1;
        int probeIndex = hashVal;

        while (hashArray[probeIndex] != -1) {
            if (hashArray[probeIndex] != DELETED && hashArray[probeIndex] == key) {
                hashArray[probeIndex] = DELETED;
                count--;
                return;
            }
            probeIndex = (hashVal + step * step) % arraySize;
            step++;
            if (step > arraySize) {
                break;
            }
        }
        System.out.println("Ключ " + key + " не найден.");
    }

    public int find(int key) {
        int hashVal = hashFunc(key);
        int step = 1;
        int probeIndex = hashVal;

        while (hashArray[probeIndex] != -1) {
            if (hashArray[probeIndex] != DELETED && hashArray[probeIndex] == key) {
                return hashArray[probeIndex];
            }
            probeIndex = (hashVal + step * step) % arraySize;
            step++;
            if (step > arraySize) {
                break;
            }
        }
        return -1; // ключ не найден
    }

    private void resize() {
        int oldArraySize = arraySize;
        arraySize = arraySize * 2;
        int[] oldHashArray = hashArray;
        hashArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = -1; // инициализация нового массива
        }
        count = 0;

        for (int i = 0; i < oldArraySize; i++) {
            if (oldHashArray[i] != -1 && oldHashArray[i] != DELETED) {
                insert(oldHashArray[i]);
            }
        }
    }
}