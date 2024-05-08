package FTnew;

public class Cashback extends Promotion {
    private double cashbackAmount;

    public Cashback(String promoCode, int minPrice, double cashbackAmount) {
        super(promoCode, minPrice);
        this.cashbackAmount = cashbackAmount;
    }

    public double getCashbackAmount() {
        return cashbackAmount;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Cashback) {
            Cashback other = (Cashback) o;
            return Double.compare(this.cashbackAmount, other.cashbackAmount);
        }
        return 0;
    }

    @Override
    protected double calculateTotalDiscount(Order order) {
        if (isMinimumPriceEligible(order)) {
            return cashbackAmount;
        } else {
            return 0;
        }
    }
}
