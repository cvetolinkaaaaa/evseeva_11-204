import java.util.Objects;
import java.util.Comparator;
public class MyLinkedList<T> {
    private Node<T> firstNode;

    public int size(){
        int size = 0;
        for (Node<T> i = firstNode; i.getNext() != null ; i = i.getNext()) {
            size++;
        }
        return size;
    }

    public boolean add(T elem){
        if (firstNode == null) {
            firstNode = new Node<>(elem, null);
        } else {
            Node<T> lastNode = firstNode;
            for (Node<T> i = firstNode; i.getNext() != null ; i = i.getNext()) {
                lastNode = i;
            }
            Node<T> newNode = new Node<>(elem,null);
            newNode.setValue(elem);
            lastNode.setNext(newNode);
        }
        return true;
    }
    public boolean addAll(MyLinkedList<T> otherList) {
        Node<T> lastNode = firstNode;
        for (Node<T> i = firstNode; i.getNext() != null ; i = i.getNext()) {
            lastNode = i;
        }
        Node <T> newNode = otherList.firstNode;
        lastNode.setNext(newNode);
        return true;
    }
    public void clear() {
        firstNode = null;
    }
    public boolean contains(T s) {
        Node<T> lastNode = firstNode;
        for (Node<T> i = firstNode; i.getNext() != null ; i = i.getNext()) {
            if (s == lastNode) {
                return true;
            }
            lastNode = i;
        }
        return false;
    }
//    public boolean containsAll(MyLinkedList<T> otherList) {
//
//    }
    public boolean isEmpty() {
        if (firstNode == null) {
            return true;
        } else {
            return false;
        }
    }
    public int indexOf(T s) {
        Node<T> lastNode = firstNode;
        int a = 0;
        for (Node<T> i = firstNode; i.getNext() != null ; i = i.getNext()) {
            if (s == lastNode) {
                return a;
            }
            lastNode = i;
            a++;
        }
        return -1;
    }
    public T remove(int index) {
        Node <T> currentNode;
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0){
            currentNode = firstNode;
            firstNode = firstNode.getNext();
            return currentNode.getValue();
        } else {
            while (indexOf((T) firstNode) < index ) {
                firstNode = firstNode.getNext();
            }
            currentNode = firstNode;
            firstNode = firstNode.getNext();
            return currentNode.getValue();
        }
    }

    public boolean remove(T s) {
        if (!(contains(s))) {
            return false;
        } else {
            remove(indexOf(s));
            return true;
        }
    }
//
//    public boolean removeAll(MyLinkedList<T> otherList) {
//
//    }

    public T set(int index, T elem) {
        if (index <0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Node<T> currentNode = firstNode;
            while (indexOf((T) firstNode) < index ) {
                currentNode = firstNode.getNext();
            }
            firstNode.setValue(elem);
            return currentNode.getValue();
        }
    }

    public Object[] toArray(){
        Object[] arr = new Object[size()];
        int a = 0;
        for (Node<T> i = firstNode; i.getNext() != null ; i = i.getNext()) {
            arr[a] = i;
            a++;
        }
        return arr;
    }

    public int lastIndexOf(T elem) {
        if (!(contains(elem))) {
            return -1;
        } else {
            int index = 0;
            int count = 0;
            Node<T> currentNode = firstNode;
            while (currentNode.getNext()!=null) {
                if (currentNode.getValue().equals(elem)) {
                    index = count;
                }
                count++;
                currentNode = currentNode.getNext();
            }
            return index;
        }
    }

//    public MyLinkedList<T> sublist(int fromIndex, int toIndex) {
//
//    }

    @Override
    public String toString() {
        if (firstNode == null) {
            return "[]";
        } else {
            String a = "[ ";
            while (firstNode.getNext() != null) {
                a += firstNode.getValue();
                firstNode = firstNode.getNext();
            }
            a+= "]";
            return a;
        }
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o){
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) return false;
//        MyLinkedList<?> that = (MyLinkedList<?>) o;
//        return Objects.equals(firstNode, that.firstNode);
//    }
//
//    public void sort(Comparator<? super T> c) {
//
//    }
}