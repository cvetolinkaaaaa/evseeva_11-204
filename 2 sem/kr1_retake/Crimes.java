import java.util.Comparator;
import java.util.Date;

public class Crimes implements Comparable<Crimes>, Comparator<Crimes> {
    int admissionsTotal;
    int admissionsWhite;
    int admissionsBlack;
    String state;

    public Crimes(int admissionsTotal, int admissionsWhite, int admissionsBlack, String state) {
        this.admissionsTotal = admissionsTotal;
        this.admissionsWhite = admissionsWhite;
        this.admissionsBlack = admissionsBlack;
        this.state = state;
    }

    public int getAdmissionsTotal() {
        return admissionsTotal;
    }

    public int getAdmissionsWhite() {
        return admissionsWhite;
    }

    public int getAdmissionsBlack() {
        return admissionsBlack;
    }

    public String getState() {
        return state;
    }

    @Override
    public int compareTo(Crimes crimes) {
        return Integer.compare(admissionsTotal - admissionsWhite, crimes.getAdmissionsTotal() - crimes.getAdmissionsWhite());
    }


    @Override
    public int compare(Crimes o1, Crimes o2) {
        return o1.compareTo(o2);
    }
}
