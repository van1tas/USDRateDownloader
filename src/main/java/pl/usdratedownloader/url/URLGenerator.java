package pl.usdratedownloader.url;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
public class URLGenerator {

    private final String DATE_FROM_PARAMETER = "{date_from}";
    private final String DATE_TO_PARAMETER = "{date_to}";
    private final String baseUrl = "http://api.nbp.pl/api/exchangerates/rates/c/usd/"
            + DATE_FROM_PARAMETER + "/" + DATE_TO_PARAMETER + "/?format=json";
    private String[] params = null;

    public URLGenerator(String[] params) {
        this.params = params;
    }

    public String getURL() {
        if (ParametersValidator.isValid(params)) {
            return getURLWithParametersValue();
        }
        return baseUrl.replace(DATE_FROM_PARAMETER, "").replace(DATE_TO_PARAMETER, "");
    }

    private String getURLWithParametersValue() {
        return baseUrl.replace(DATE_FROM_PARAMETER, params[0])
                .replace(DATE_TO_PARAMETER, params.length > 1 ? params[1] : "");
    }
}
