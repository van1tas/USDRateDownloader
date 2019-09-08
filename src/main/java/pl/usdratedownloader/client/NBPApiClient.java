package pl.usdratedownloader.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import pl.usdratedownloader.url.URLGenerator;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
public class NBPApiClient {

    public static final String NO_DATA_ERR = "404 NotFound - Not Found - Brak danych";
    private String[] params = null;

    public NBPApiClient(String params[]) {
        this.params = params;
    }

    public String getJSONResponseInString() throws IOException {
        String jsonInString;
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
            String url = new URLGenerator(params).getURL();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufReader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
            jsonInString = builder.toString();
        }

        return jsonInString;
    }
}
