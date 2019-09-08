package pl.usdratedownloader.pojo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
public class Rates {

    private String no;
    private String effectiveDate;
    private String bid;
    private String ask;

    public Rates() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getDifferentBetweenBids(BigDecimal previousBid) {
        BigDecimal bidBigDecimal = new BigDecimal(this.bid);
        return bidBigDecimal.subtract(previousBid).toString();
    }
    
    public String getDifferentBetweenAsks(BigDecimal previousAsk) {
        BigDecimal askBigDecimal = new BigDecimal(this.ask);
        return askBigDecimal.subtract(previousAsk).toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.no);
        hash = 17 * hash + Objects.hashCode(this.effectiveDate);
        hash = 17 * hash + Objects.hashCode(this.bid);
        hash = 17 * hash + Objects.hashCode(this.ask);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rates other = (Rates) obj;
        if (!Objects.equals(this.no, other.no)) {
            return false;
        }
        if (!Objects.equals(this.effectiveDate, other.effectiveDate)) {
            return false;
        }
        if (!Objects.equals(this.bid, other.bid)) {
            return false;
        }
        if (!Objects.equals(this.ask, other.ask)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rates{" + "no=" + no + ", effectiveDate=" + effectiveDate + ", bid=" + bid + ", ask=" + ask + '}';
    }
}
