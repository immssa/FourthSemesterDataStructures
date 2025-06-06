package Lr1;

public class InsertionSort{
    protected final long[] array;
    private int nElems;

    public InsertionSort(int size) {
        this.array = new long[size];
        this.nElems = 0;
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


    public void insertionSort() {
        for (int out = 1; out < nElems; out++) { // out - разделительный маркер
            long temp = array[out]; // Скопировать помеченный элемент
            int in = out; // Начать перемещения с out
            while(in > 0 && array[in - 1] >= temp) { // Пока не найден меньший элемент
                array[in] = array[in - 1]; // Сдвинуть элемент вправо
                --in; // Перейти на одну позицию влево
            }
            array[in] = temp; // Вставить помеченный элемент
        }
    }
}
