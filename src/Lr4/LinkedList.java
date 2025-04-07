package Lr4;

public class LinkedList {
    private Link first;

    public void insert(Link theLink) {
        // Вставка в конец списка
        if (first == null) {
            first = theLink;
        } else {
            Link current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(theLink);
        }
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;

        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return;
        }

        if (previous == null) {
            first = first.getNext();
        } else {
            previous.setNext(current.getNext());
        }
    }

    public Link find(int key) {
        Link current = first;
        while (current != null) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println();
    }

    // Возвращает первый элемент списка
    public Link getFirst() {
        return first;
    }
}