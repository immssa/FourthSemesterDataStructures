package Lr1;

public abstract class NewArray implements NewInterface {
    protected final long[] array;
    private int nElems;

    public NewArray(int size) {
        this.array = new long[size];
        this.nElems = 0;
    }

    public boolean delete(long value) {
        int i;
        for (i = 0; i < this.nElems; i++) {
            if (array[i] == value) {
                break;
            }
        }

        if (i == nElems - 1) {
            return false;
        } else {
            for (int j = i; j < nElems - 1; j++) {
                array[j] = array[j + 1];
            }
            nElems--;
            return true;
        }
    }

    public boolean find(long searchValue) {
        for (int i = 0; i < this.nElems; i++) {
            if (array[i] == searchValue) {
                return true;
            }
        }

        return false;
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

    public long getSize() {
        int count = 0;
        for (int i = 0; i < nElems; i++) {
            count ++;
        }
        return count;
    }

    public long getMax() {
        int maxElem = 0;
        for (int i = 0; i < nElems; i++){
            if (array[i] > maxElem) {
                maxElem = (int) array[i];
            }
        }
        return maxElem;
    }

    public long getMin() {
        long minElem = array[0];
        for (int i = 0; i < nElems; i++){
            if(array[i] < minElem){
                minElem = (int) array[i];
            }
        }
        return minElem;
    }
}