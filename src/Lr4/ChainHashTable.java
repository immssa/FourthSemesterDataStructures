package Lr4;

public class ChainHashTable {
    private LinkedList[] hashArray;
    private int arraySize;
    private int count;         // общее число элементов в таблице
    private final double loadFactor = 1.0; // порог загрузки = 1 элемент на ячейку

    public ChainHashTable(int size) {
        arraySize = size;
        hashArray = new LinkedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }
        count = 0;
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    // Простая хеш-функция, использующая операцию остатка
    public int hashFunc(int key) {
        return Math.abs(key) % arraySize;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
        count++;

        // Если достигнут порог загрузки, расширяем таблицу
        if (count > arraySize * loadFactor) {
            resize();
        }
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        // Если элемент найден и удалён, уменьшаем счётчик
        Link found = hashArray[hashVal].find(key);
        if (found != null) {
            hashArray[hashVal].delete(key);
            count--;
        }
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

    // Расширение таблицы: удваиваем размер массива и перераспределяем все элементы
    private void resize() {
        int oldArraySize = arraySize;
        arraySize = arraySize * 2;
        LinkedList[] oldHashArray = hashArray;
        hashArray = new LinkedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new LinkedList();
        }

        // Сброс общего счётчика. Поскольку insert() увеличивает count,
        // установим его в 0 и затем добавим все элементы заново.
        count = 0;

        // Перехеширование всех элементов
        for (int i = 0; i < oldArraySize; i++) {
            Link current = oldHashArray[i].getFirst();
            while (current != null) {
                // Сохраняем ссылку на следующий элемент, так как при вставке ссылка может измениться
                Link next = current.getNext();
                current.setNext(null); // очищаем старую связь
                insert(current);
                current = next;
            }
        }
    }
}