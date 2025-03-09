package Lr1;

public class ShellSort_Sedgewick {
    protected final long[] array;
    private int nElems;
    private int swapCount; // Переменная для подсчета перестановок

    public ShellSort_Sedgewick(int size) {
        this.array = new long[size];
        this.nElems = 0;
        this.swapCount = 0;
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

    public void shellSort_Sedgewick() {
        int inner, outer;
        long temp;
        int h = 1;
        swapCount = 0; // Обнуляем счетчик перед сортировкой

        // Вычисляем максимальный шаг из последовательности Седжвика
        int k = 0;
        while (h < nElems) {
            h = (k % 2 == 0) ? (9 * (1 << (2 * k)) - 9 * (1 << k) + 1) : (8 * (1 << (2 * k)) - 6 * (1 << k) + 1);
            k++;
        }
        k -= 2;
        h = (k % 2 == 0) ? (9 * (1 << (2 * k)) - 9 * (1 << k) + 1) : (8 * (1 << (2 * k)) - 6 * (1 << k) + 1);

        // Сортировка с использованием последовательности Седжвика
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer]; // выбирается "внешний" элемент интервальной последовательности
                inner = outer;
                while (inner > h - 1 && array[inner - h] >= temp) { // "внешний" элемент сравнивается с предыдущим элементом интервальной последовательности
                    array[inner] = array[inner - h];
                    inner -= h;
                    swapCount++; // Увеличиваем счетчик перестановок
                }
                array[inner] = temp;
            }
            k--;
            h = (k >= 0) ? ((k % 2 == 0) ? (9 * (1 << (2 * k)) - 9 * (1 << k) + 1) : (8 * (1 << (2 * k)) - 6 * (1 << k) + 1)) : 0;
        }
    }

    public int getSwapCount() {
        return swapCount;
    }
}