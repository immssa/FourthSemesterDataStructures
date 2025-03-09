package Lr1;
import java.util.Random;

public class NewClient {
    public static void main(String[] args) {
        Random random = new Random();

        long start;
        long end;

        int size = 100000;
        SelectionSort korjik = new SelectionSort(size);
        InsertionSort karamelika = new InsertionSort(size);
        BubbleSort kompot = new BubbleSort(size);
        ShellSort sheldon = new ShellSort(size);
        ShellSort_Knuth knuth = new ShellSort_Knuth(size);
        ShellSort_Sedgewick sedgewick = new ShellSort_Sedgewick(size);

        for (int i = 0; i < size; i++) {
            kompot.insert(random.nextLong(100000));
            karamelika.insert(random.nextLong(100000));
            korjik.insert(random.nextLong(100000));
            sheldon.insert(random.nextLong(100000));
            knuth.insert(random.nextLong(100000));
            sedgewick.insert(random.nextLong(100000));
        }

        System.out.println("Bubble");
        //kompot.display();
        start = System.currentTimeMillis();
        kompot.bubbleSort();
        end = System.currentTimeMillis();
        //kompot.display();
        System.out.printf("Время выполнения: %d мс \n", end - start);

        System.out.println("\nInsertion");
        //karamelika.display();
        start = System.currentTimeMillis();
        karamelika.insertionSort();
        end = System.currentTimeMillis();
        //karamelika.display();
        System.out.printf("Время выполнения: %d мс \n", end - start);

        System.out.println("\nSelection");
        //korjik.display();
        start = System.currentTimeMillis();
        korjik.selectionSort();
        end = System.currentTimeMillis();
        //korjik.display();
        System.out.printf("Время выполнения: %d мс \n", end - start);

        System.out.println("\nShell");
        //sheldon.display();
        start = System.currentTimeMillis();
        sheldon.shellSort();
        end = System.currentTimeMillis();
        //sheldon.display();
        System.out.printf("Время выполнения: %d мс \n", end - start);
        System.out.printf("Кол-во перествновок: %d \n", sheldon.getSwapCount());

        System.out.println("\nShell by Knuth");
        //knuth.display();
        start = System.currentTimeMillis();
        knuth.shellSort_Knuth();
        end = System.currentTimeMillis();
        //knuth.display();
        System.out.printf("Время выполнения: %d мс \n", end - start);
        System.out.printf("Кол-во перествновок: %d \n", knuth.getSwapCount());

        System.out.println("\nShell by Sedgewick");
        //sedgewick.display();
        start = System.currentTimeMillis();
        sedgewick.shellSort_Sedgewick();
        end = System.currentTimeMillis();
        //sedgewick.display();
        System.out.printf("Время выполнения: %d мс \n", end - start);
        System.out.printf("Кол-во перествновок: %d \n", sedgewick.getSwapCount());
    }
}
