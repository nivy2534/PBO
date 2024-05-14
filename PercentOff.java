package FTnew;

/*
ketika dipanggil, maka akan mereturn atau memberikan fungsi diskon
ketika inisialiasi
PercentOff (generate ranodm String atau kode sendiri) = new PercentOff();
-> (isi) double diskon
-> harga setelah diskon akan ada di class order

*/
public class PercentOff extends Promotion {
    private double discountPercentage;

    public PercentOff(String promoCode, int minPrice, double discountPercentage) {
        super(promoCode, minPrice);
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double calculateTotalDiscount(Order order) {
        if (isMinimumPriceEligible(order)) {
            return order.getTotalPrice() * (discountPercentage / 100);
        } else {
            return 0;
        }
    }

    public int compareTo(Object o) {
        if (o instanceof PercentOff) {
            PercentOff other = (PercentOff) o;
            return Double.compare(this.discountPercentage, other.discountPercentage);
        }
        return 0;
    }
}