package FTml3;

import java.time.LocalDate;

public class CashBack extends Promotion {
    public CashBack(String promoCode, LocalDate start, LocalDate end, double percentDisc, double maxDisc,
            double minPrice) {
        super(promoCode, start, end, percentDisc, maxDisc, minPrice);
    }

    public double calculateTotalDiscount(Order order) {
        if (isMinimumPriceEligible(order)) {
            double cashback = order.getTotalPrice() * getPercentDisc();
            return Math.min(cashback, getMaxDisc());
        } else {
            return 0;
        }
    }

    public boolean isCostumerEligible(Customer x) {
        return true;
    }

    public boolean isMinimumPriceEligible(Order x) {
        return true;
    }

    public boolean isShippingFeeEligible(Order x) {
        return true;
    }

    public int compareTo(Object o) {
        if (o instanceof Cashback) {
            Cashback other = (Cashback) o;
            return Double.compare(this.getPercentDisc(), other.getPercentDisc());
        }
        return 0;
    }
}
