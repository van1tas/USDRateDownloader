package pl.usdratedownloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import pl.usdratedownloader.client.NBPApiClient;
import pl.usdratedownloader.gui.ResultPrinter;
import pl.usdratedownloader.pojo.NBPApiResponse;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
public class USDRateDownloader {

    public static void main(String[] params) throws IOException {
        String jsonInString = new NBPApiClient(params).getJSONResponseInString();
        if (!jsonInString.contains(NBPApiClient.NO_DATA_ERR)) {
            ObjectMapper mapper = new ObjectMapper();
            NBPApiResponse apiResponse = mapper.readValue(jsonInString, NBPApiResponse.class);
            new ResultPrinter(apiResponse).print();
        } else {
            System.out.println(NBPApiClient.NO_DATA_ERR + " - zapytanie dotyczy dni w których giełda nie pracuje.");
        }
    }
}
