import java.lang.reflect.Array;
import java.util.*;
import java.util.Collection;

public class MySet<E> extends AbstractSet<E>implements SortedSet<E> {
    private E[] elements;
    private Comparator<? super E> comparator;
    private E current;

    public MySet(Collection<? extends E> c, Comparator<? super E> comparator, Class<E> eClass) {
        this.comparator = comparator;
        this.elements = (E[]) Array.newInstance(eClass, c.size());
        c.toArray(this.elements);
        Arrays.sort(this.elements, comparator);
    }

    public MySet(Comparator<? super E> comparator, Class<E> eClass) {
        this.comparator = comparator;
        this.elements = (E[]) Array.newInstance(eClass, 0);
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.comparator;
    }


    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++){
            if (elements[i] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        else {
            for(int i = 0; i < elements.length; i++){
                if(elements[i] == o){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                if(index < size()){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                current = elements[index];
                index++;
                return current;
            }

            @Override
            public void remove() {
                if (current == null) {
                    throw new IllegalStateException();
                }
                MySet.this.remove(current);
                current = null;
                index--;
            }
        };
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        MySet<E> newMySet = new MySet<E>(comparator, (Class<E>) elements.getClass().getComponentType());
        for (int i = 0; i < elements.length; i++) {
            if (comparator.compare(elements[i], toElement) < 0) {
                newMySet.add(elements[i]);
            }
        }
        return newMySet;
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        MySet<E> newSet = new MySet<E>(comparator, (Class<E>) elements.getClass().getComponentType());
        for (int i = 0; i < elements.length; i++) {
            if (comparator.compare(elements[i], fromElement) >= 0) {
                newSet.add(elements[i]);
            }
        }
        return newSet;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        int fromIndex = Arrays.binarySearch(this.elements, fromElement, comparator);
        int toIndex = Arrays.binarySearch(this.elements, toElement, comparator);
        if (fromIndex < 0) {
            fromIndex = -fromIndex - 1;
        }
        if (toIndex < 0) {
            toIndex = -toIndex - 1;
        }
        return new MySet<>(Arrays.asList(elements).subList(fromIndex, toIndex), comparator(),
                (Class<E>) elements.getClass().getComponentType());
    }

    @Override
    public E first() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return elements[0];
    }

    @Override
    public E last() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return elements[size() - 1];
    }


    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        else {
            for(int i = 0; i < elements.length; i++){
                if (!contains(e)) {

                    if (size() == elements.length + 1) {
                        elements = Arrays.copyOf(elements, elements.length * 2);
                        elements[size()] = e;
                    }
                    else {
                        elements[size()] = e;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elements.length; i++){
            if(elements[i] == o){
                elements[i] = null;
                return true;
            }
        }
        return  false;
    }


}
