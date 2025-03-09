package Lr1;

public class ShellSort {
    protected final long[] array;
    private int nElems;
    private int swapCount; // Переменная для подсчета перестановок

    public ShellSort(int size) {
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

    public void shellSort() {
        int inner, outer;
        long temp;
        int h = nElems / 2; // Начальный шаг равен половине количества элементов
        swapCount = 0; // Обнуляем счетчик перед сортировкой

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = array[outer]; // Сохраняем текущий элемент
                inner = outer;
                // Сдвигаем элементы отсортированной части, пока не найдётся место для temp
                while (inner >= h && array[inner - h] > temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                    swapCount++; // Увеличиваем счетчик перестановок
                }
                array[inner] = temp;
            }
            h /= 2; // Уменьшаем шаг вдвое
        }
    }

    public int getSwapCount() {
        return swapCount;
    }
}
