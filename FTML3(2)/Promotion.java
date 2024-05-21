package FTml3;

import java.time.LocalDate;

public abstract class Promotion implements Comparable, Applicable {
    private String promoCode;
    private LocalDate start, end;
    private double percentDisc;
    private double maxDisc;
    private doublet minPrice;

    public Promotion(String promoCode, LocalDate start, LocalDate end, double percentDisc, double maxDisc,
            double minPrice) {
        this.promoCode = promoCode;
        this.start = start;
        this.end = end;
        this.percentDisc = percentDisc * 0.01;
        this.maxDisc = maxDisc;
        this.minPrice = minPrice;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public LocalDate getEnd() {
        return end;
    }

    public double getPercentDisc() {
        return percentDisc;
    }

    public double getMaxDisc() {
        return maxDisc;
    }

    public LocalDate getStart() {
        return start;
    }

    public boolean isCostumerEligible(Customer x) {
        if (x instanceof Member) {
            if (x.getAccountAge() > 30) {
                return true;
            }
        }
        return false;
    }

    public boolean isMinimumPriceEligible(Order x) {
        if (x.totalPrice > 50000) {
            return true;
        }
        return false;
    }

    public boolean isShippingFeeEligible(Order x) {
        return true;
    }

    public int compareTo(Object o) {
        return -1;
    }
}