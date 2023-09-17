
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            list.add(i);
        }
        PartitionService partitionService = new PartitionService(list, 3);
        partitionService.countArrayPartitionSum();

    }
    public static class CountThread extends Thread {
        private List<Integer> integers;
        private int sum;

        public CountThread(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        public void run() {
            sum = integers.stream().mapToInt(Integer::intValue).sum();
        }

        public int getSum() {
            return sum;
        }
    }
    public static class PartitionService {
        private List<Integer> integerList;
        private int partitionSize;

        public PartitionService(List<Integer> integerList, int partitionSize) {
            this.integerList = integerList;
            this.partitionSize = partitionSize;
        }

        public int countArrayPartitionSum() throws InterruptedException {
            List<List<Integer>> partitions = new ArrayList<>();
            for (int i = 0; i < integerList.size(); i += partitionSize) {
                partitions.add(integerList.subList(i, Math.min(i + partitionSize, integerList.size())));
            }

            List<CountThread> threads = new ArrayList<>();
            for (List<Integer> partition : partitions) {
//                Set<Thread> threads1 = CountThread.getAllStackTraces().keySet();
//
//                System.out.printf("%-15s \t %-15s \t %-15s \t %s\n", "Name", "State", "Priority", "isDaemon");
//
//                for (Thread t : threads) {
//
//                    System.out.printf("%-15s \t %-15s \t %-15d \t %s\n", t.getName(), t.getState(), t.getPriority(), t.isDaemon());
//                }
                CountThread thread = new CountThread(partition);

                thread.start();
                threads.add(thread);
            }

            int sum = 0;
            for (CountThread thread : threads) {
                thread.join();
                sum += thread.getSum();
                System.out.println(sum);
            }
            return sum;
        }
    }
}
