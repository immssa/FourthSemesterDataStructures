package Lr3;

public class MergeSort {

    private final long[] array;
    private int nElems;
    private int swapCount;
    private int comparisonCount;

    public MergeSort(int size) {
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
        long[] tempArray = new long[nElems];
        mergeSort(tempArray, 0, nElems - 1);
    }

    private void mergeSort(long[] tempArray, int lowerBound, int upperBound) {
        if (lowerBound != upperBound) { // Если только один элемент, сортировка не требуется.
            int middle = (lowerBound + upperBound) / 2; // Поиск середины
            mergeSort(tempArray, lowerBound, middle); // Сортировка нижней половины
            mergeSort(tempArray, middle + 1, upperBound); // Сортировка верхней половины
            merge(tempArray, lowerBound, middle + 1, upperBound); // Слияние
        }
    }

    private void merge(long[] tempArr, int lowPtr, int highPtr, int upperBound) {
        int tempArrIndex = 0;
        int lowerBound = lowPtr;
        int middle = highPtr - 1;
        int elementsNumber = upperBound - lowerBound + 1;

        boolean loopEntered = false;
        // Основной цикл слияния с учётом дополнительного неудачного сравнения
        while (lowPtr <= middle && highPtr <= upperBound) {
            loopEntered = true;
            comparisonCount++; // сравнение элементов
            if (array[lowPtr] < array[highPtr]) {
                tempArr[tempArrIndex++] = array[lowPtr++];
                swapCount++; // считаем выбор элемента как перестановку
            } else {
                tempArr[tempArrIndex++] = array[highPtr++];
                swapCount++;
            }
        }
        // Добавляем одно сравнение, завершившее цикл, если цикл хотя бы раз выполнялся
        if (loopEntered) {
            comparisonCount++;
        }

        // Копируем оставшиеся элементы – эти копирования не считаем как перестановки
        while (lowPtr <= middle) {
            tempArr[tempArrIndex++] = array[lowPtr++];
        }
        while (highPtr <= upperBound) {
            tempArr[tempArrIndex++] = array[highPtr++];
        }

        // Перекопирование из временного массива в основной – также не учитываем как перестановки
        for (tempArrIndex = 0; tempArrIndex < elementsNumber; tempArrIndex++) {
            array[lowerBound + tempArrIndex] = tempArr[tempArrIndex];
        }
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getSwapCount() {
        return swapCount;
    }
}
