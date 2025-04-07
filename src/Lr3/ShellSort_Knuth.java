package Lr3;

public class ShellSort_Knuth {

    private final long[] array;
    private int nElems;
    private int swapCount;
    private int comparisonCount;

    public ShellSort_Knuth(int size) {
        this.array = new long[size];
        this.nElems = 0;
        this.swapCount = 0;
        this.comparisonCount = 0;
    }

    public void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort() {
        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;  // последовательность Кнута
        }
        while (h > 0) {
            for (int outer = h; outer < nElems; outer++) {
                long temp = array[outer];
                int inner = outer;
                // Перемещаем элементы, пока не найдём место для вставки
                while (inner >= h && array[inner - h] >= temp) {
                    comparisonCount++; // успешное сравнение
                    array[inner] = array[inner - h];
                    inner -= h;
                    swapCount++; // перемещение элемента
                }
                comparisonCount++;
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
