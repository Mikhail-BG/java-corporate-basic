package corporate.basic.task.storage;

import java.util.Iterator;

public class ContainerList<T> implements Iterable<T>{

    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public ContainerList() {

    }

    public T getFirst() {
        if (first != null) {
            return first.item;
        }

        return null;
    }

    public T getLast() {
        if (last != null) {
            return last.item;
        }

        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean setFirst(T item) {
        if (item == null) {
            return false;
        }

        Node<T> newFirst = this.first;
        Node<T> newNode = new Node<>(item, newFirst, null);

        first = newNode;
        if (newFirst == null) {
            last = newNode;
        } else {
            newFirst.prev = newNode;
        }

        size++;
        return true;
    }

    public boolean add(T item) {
        if (item == null){
            return false;
        }

        Node<T> currentLast = last;
        Node<T> newNode = new Node<>(item, null, currentLast);

        last = newNode;

        if (currentLast == null) {
            first = newNode;
        }
        else {
            currentLast.next = newNode;
        }

        size++;
        return true;
    }

    public boolean remove(T item) {
        if (item == null){
            return false;
        }

        for (Node<T> node = first; node != null; node = node.next) {
            if (item.equals(node.item)) {
                unlinkNode(node);
                return true;
            }
        }

        return false;
    }

    private void unlinkNode(Node<T> node) {
        Node<T> next = node.next;
        Node<T> prev = node.prev;

        // Handle first
        // node is the first
        if (prev == null) {
            first = next;

        // node is not the first
        } else {
            prev.next = next;
            node.prev = null;
        }

        // Handle last
        // node is the last
        if (next == null) {
            last = prev;

        // node is not the last
        } else {
            next.prev = prev;
            node.next = null;
        }

        // Delete item linkage
        node.item = null;
        size--;
    }

    public T get(int position) {
        if (position < 0 || position > size) {
            return null;
        }

        int counter = 0;
        for (Node<T> node = first; node != null; node = node.next) {
            if (counter == position) {
                return node.item;
            }
            counter ++;
        }

        return null;
    }

    public boolean contains(T item) {
        if (item == null){
            return false;
        }

        for (Node<T> node = first; node != null; node = node.next) {
            if (node.item.equals(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ContainerListIterator<>(this);
    }

    static class ContainerListIterator<T> implements Iterator<T> {
        Node<T> current;

        // initialize pointer to head of the list for iteration
        public ContainerListIterator(ContainerList<T> containerList)
        {
            current = containerList.first;
        }

        // returns false if next element does not exist
        public boolean hasNext()
        {
            return current != null;
        }

        // return current data and update pointer
        public T next()
        {
            T data = current.item;
            current = current.next;
            return data;
        }

        // implement if needed
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
