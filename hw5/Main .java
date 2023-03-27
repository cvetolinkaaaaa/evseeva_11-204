import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("honda.csv"))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] lineArray = scanner.nextLine().split(",");
                Integer year = Integer.parseInt(lineArray[0]);
                String[] a = lineArray[1].split(" ");
                int kmsDriven = Integer.parseInt(a[0]);
                String fuelType = lineArray[2];
                String suspension = lineArray[3];
                String[] b = lineArray[4].split(" ");
                double price = Double.parseDouble(b[0]);
                String carModel = lineArray[5];
                cars.add(new Car(year, kmsDriven, fuelType, suspension, price, carModel));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cars.stream()
                .filter(car -> car.getFuelType().equals("Petrol") && car.getSuspension().equals("Automatic"))
                .toList()
                .forEach(System.out::println);
        System.out.println(cars.stream()
                .filter(car -> Integer.valueOf((int)car.getPrice()) %2 == 0)
                .count());
        double average = cars.stream()
                .mapToDouble(car -> car.getPrice())
                .average()
                .getAsDouble();
        int count = (int) cars.stream()
                .filter(car -> car.getPrice() > average)
                .count();
        System.out.println(count);
        cars.stream()
                .filter(car -> car.getKmsDriven()/(2023 - car.getYear()) < 10000*(2023 - car.getYear()))
                .forEach(System.out::println);
        long count2 = cars.stream()
                .filter(car -> car.getYear() < 2015 && car.getCarModel().startsWith("Honda City"))
                .count();
        System.out.println(count2);
    }
    public class Car {
        int year;
        int kmsDriven;
        String fuelType;
        String suspension;
        double price;
        String carModel;

        public Car(int year, int kmsDriven, String fuelType, String suspension, Double price, String carModel) {
            this.year = year;
            this.kmsDriven = kmsDriven;
            this.fuelType = fuelType;
            this.suspension = suspension;
            this.price = price;
            this.carModel = carModel;
        }

        public int getYear() {
            return year;
        }

        public int getKmsDriven() {
            return kmsDriven;
        }

        public String getFuelType() {
            return fuelType;
        }

        public String getSuspension() {
            return suspension;
        }

        public double getPrice() {
            return price;
        }

        public String getCarModel() {
            return carModel;
        }
    }

}