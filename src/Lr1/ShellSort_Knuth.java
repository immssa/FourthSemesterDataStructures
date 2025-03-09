package Lr1;

public class ShellSort_Knuth {
    protected final long[] array;
    private int nElems;
    private int swapCount; // Переменная для подсчета перестановок

    public ShellSort_Knuth(int size) {
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

    public void shellSort_Knuth() {
        int inner, outer;
        long temp;
        int h = 1;
        swapCount = 0; // Обнуляем счетчик перед сортировкой

        // Вычисляем максимальный шаг из последовательности Кнута
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        // Сортировка с использованием последовательности Кнута
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
            h = (h - 1) / 3; // интервальная последовательность пересчитывается
        }
    }

    public int getSwapCount() {
        return swapCount;
    }
}
