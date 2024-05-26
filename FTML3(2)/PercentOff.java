package FTml3;

import java.time.LocalDate;

public class PercentOff extends Promotion {
    public PercentOff(String promoCode, LocalDate start, LocalDate end, double percentDisc, double maxDisc,
            double minPrice) {
        super(promoCode, start, end, percentDisc, maxDisc, minPrice);
    }

    public double calculateTotalDiscount(Order order) {
        if (isMinimumPriceEligible(order)) {
            double discount = order.getTotalPrice() * getPercentDisc();
            return Math.min(discount, getMaxDisc());
        } else {
            return 0;
        }
    }

    public int compareTo(Object o) {
        if (o instanceof PercentOff) {
            PercentOff other = (PercentOff) o;
            return Double.compare(this.getPercentDisc(), other.getPercentDisc());
        }
        return 0;
    }
}
