/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.usdratedownloader.gui;

import java.math.BigDecimal;
import pl.usdratedownloader.pojo.NBPApiResponse;
import pl.usdratedownloader.pojo.Rates;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
public class ResultPrinter {
    
    private NBPApiResponse apiResponse = null;
    
    public ResultPrinter(NBPApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }
    
    public void print() {
        StringBuilder result = new StringBuilder("Data\t\tCena skupu\tCena sprzedaży\tZmiana ceny skupu\tZmiana ceny sprzedaży\n");
        BigDecimal previousDayBid = null;
        BigDecimal previousDayAsk = null;
        for (Rates rate : apiResponse.getRates()) { 
            result.append(rate.getEffectiveDate())
                    .append("\t")
                    .append(rate.getBid())
                    .append("\t\t")
                    .append(rate.getAsk())
                    .append("\t\t");
            if (previousDayBid != null && previousDayAsk != null) {
                result.append(rate.getDifferentBetweenBids(previousDayBid))
                        .append("\t\t\t")
                        .append(rate.getDifferentBetweenAsks(previousDayAsk));
            }
            result.append("\n");
            previousDayBid = new BigDecimal(rate.getBid());
            previousDayAsk = new BigDecimal(rate.getAsk());
        }
        System.out.println(result.toString());
    }
}
