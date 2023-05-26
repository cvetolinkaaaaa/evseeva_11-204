

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fileName = "admissions_releases_states.csv";
        SortedModifiableCollection<Crimes> collection = new SortedModifiableCollection();

        try (BufferedReader br = new BufferedReader(new FileReader("admissions_releases_states.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int admissionsTotal = Integer.parseInt(parts[1]);
                int admissionsWhite = Integer.parseInt(parts[2]);
                int admissionsBlack = Integer.parseInt(parts[3]);
                String state = parts[15];
                Crimes crimes = new Crimes(admissionsTotal, admissionsWhite, admissionsBlack,state);
                collection.add(crimes);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int count = (int) collection.stream()
                .filter(crime -> crime.getState().equals("Arizona"))
                .count();
        System.out.println(count);

    }
}
