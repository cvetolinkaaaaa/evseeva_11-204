import java.util.*;

public class SortedModifiableCollection<E extends Comparable<E>> extends AbstractCollection<E> {
    List<E> list;

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return list.size();
    }

    public boolean add(E e){
        Comparator<E> comporator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                return o1.compareTo(o2);
            }
        };
        list.sort(comporator);
        list.add(list.size()-1,e);
        return true;
    }



}
