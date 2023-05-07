import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.InputStream;
import java.net.URL;

@Data
@AllArgsConstructor
public class ApiRequestExecutor {
    public String getCatFactsFromApi (String url) throws Exception{
        InputStream inputStream = new URL(url)
                .openStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return new String(bytes);
    }
}
