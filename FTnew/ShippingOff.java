package FTnew;

public class ShippingOff extends Promotion {
    private double shippingDiscount;

    public ShippingOff(String promoCode, int minPrice, double shippingDiscount) {
        super(promoCode, minPrice);
        this.shippingDiscount = shippingDiscount;
    }

    public double getShippingDiscount() {
        return shippingDiscount;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof ShippingOff) {
            ShippingOff other = (ShippingOff) o;
            return Double.compare(this.shippingDiscount, other.shippingDiscount);
        }
        return 0;
    }

    @Override
    protected double calculateTotalDiscount(Order order) {
        if (isMinimumPriceEligible(order)) {
            return shippingDiscount;
        } else {
            return 0;
        }
    }
}
