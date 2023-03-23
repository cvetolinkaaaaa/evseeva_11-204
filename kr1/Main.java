import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main{
    public static void main(String[]args){
        MyStack <Car> myStack = new MyStack<Car>();
        try (Scanner scanner = new Scanner(new File("honda.csv"))){
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] a = scanner.nextLine().split(",");
                Integer year = Integer.parseInt(a[0]);
                Integer kmsDriven = Integer.parseInt(a[1]);
                String fuelType = a[2];
                String suspention = a[3];
                Integer price = Integer.parseInt(a[4]);
                String carModel = a[5];
                myStack.push(new Car(year, kmsDriven, fuelType, suspention, price, carModel));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

//        List<Car> sortedCars = new ArrayList<>();

    }
//
//    @Override
//    public int compare(Object o1, Object o2) {
//        return 0;
//    }
public static class MyStack<T> extends AbstractCollection<T> {
    List<T> list = new ArrayList<T>();

    public T push(T elem) {
        list.add(elem);
        return elem;
    }

    public T pop(){
        int len = list.size();
        if (len == 0){
            throw new EmptyStackException();
        } else {
            list.remove(len - 1);
            return list.get(len - 1);
        }

    }

    public T peek() {
        int len = list.size();
        if (len == 0){
            throw new EmptyStackException();
        } else {
            return list.get(len - 1);
        }
    }

    public boolean empty() {
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int search(T elem) {
        int i = list.lastIndexOf(elem);
        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
    public static class Car {
        int year;
        int kmsDriven;
        String fuelType;
        String supension;
        int price;
        String carModel;

        public Car(int year, int kmsDriven, String fuelType, String supension, int price, String carModel) {
            this.year = year;
            this.kmsDriven = kmsDriven;
            this.fuelType = fuelType;
            this.supension = supension;
            this.price = price;
            this.carModel = carModel;
        }
    }
}
