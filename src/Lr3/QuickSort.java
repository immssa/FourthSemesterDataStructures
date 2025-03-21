package Lr3;

public class QuickSort {

    private final long[] array;
    private int nElems;
    private int swapCount;
    private int comparisonCount;

    public QuickSort(int size) {
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
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        if (right - left <= 0) {  // Базовый случай: 0 или 1 элемент
            return;
        } else {
            long pivot = array[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;

        while (true) {
            // Сдвигаем указатель слева до элемента, большего или равного опорному
            while (++leftPtr < right) {
                comparisonCount++; // сравнение в while
                if (array[leftPtr] >= pivot) {
                    break;
                }
            }
            // Сдвигаем указатель справа до элемента, меньшего опорного
            while (--rightPtr > left) {
                comparisonCount++; // сравнение в while
                if (array[rightPtr] <= pivot) {
                    break;
                }
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);  // Ставим опорный элемент на место
        return leftPtr;
    }

    private void swap(int index1, int index2) {
        long temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        swapCount++;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
