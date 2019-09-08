package pl.usdratedownloader.url;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
public class ParametersValidator {

    private static final String DATE_PARAMETER_FORMAT = "yyyy-mm-DD";

    public ParametersValidator() {
    }

    public static boolean isValid(String[] params) {
        boolean isValid = isParametersAreDefine(params) 
                && !isToManyParamatersAreDefine(params);
        if (isValid) {
            for (String param : params) {
                isValid = isValidDateFormat(param);
            }
        }
        return isValid;
    }

    private static boolean isParametersAreDefine(String params[]) {
        return params != null && params.length > 0;
    }

    private static boolean isToManyParamatersAreDefine(String params[]) {
        return params.length > 2;
    }

    private static boolean isValidDateFormat(String dateString) {
        DateFormat simpleDateFormat = new SimpleDateFormat(DATE_PARAMETER_FORMAT);
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
