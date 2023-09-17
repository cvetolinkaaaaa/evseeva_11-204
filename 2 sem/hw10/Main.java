import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.InputStream;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws Exception {
        CatFactPerformer catFactPerformer = new CatFactPerformer();
        System.out.println(catFactPerformer.catToPrettyFormat());
    }
}