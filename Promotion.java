package FTnew;

public abstract class Promotion implements Comparable, Applicable {
    private String promoCode;
    private int minPrice;

    public Promotion(String promoCode, int minPrice) {
        this.promoCode = promoCode;
        this.minPrice = minPrice;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public int getMinPrice() {
        return minPrice;
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