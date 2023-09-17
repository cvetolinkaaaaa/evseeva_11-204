import java.util.List;

public class CatFactGetter {
    public String getCatFacts (List<CatFact> catFact ) {
        String s = new String("");
        int a = 1;
        for (int i = 0; i < catFact.size(); i++) {
            s += ("Fact " + a + " " + catFact.get(i).getText() + "\n");
            a ++;
        }
        return s;
    }
}