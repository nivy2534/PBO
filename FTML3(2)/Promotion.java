package FTml3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public abstract class Promotion implements Comparable, Applicable {
    private String promoCode;
    private LocalDate start;
    private LocalDate end;
    private double percentDisc;
    private double maxDisc;
    private double minPrice;

    private static Map<String, Promotion> promoCodes = new HashMap<>();

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

    public double getMinPrice() {
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

    public boolean isCustomerEligible(Customer x) {
        if (x instanceof Member) {
            if (x.getAccountAge() > 30) {
                return true;
            }
        }
        return false;
    }

    public boolean isMinimumPriceEligible(Order x) {
        return x.getTotalPrice() > minPrice;
    }

    public boolean isShippingFeeEligible(Order x) {
        return true;
    }

    public int compareTo(Object o) {
        return -1;
    }

    public static void createPromo(String s, String t) {
        String[] details = t.split("\\|");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate start = LocalDate.parse(details[1], format);
        LocalDate end = LocalDate.parse(details[2], format);
        switch (s) {
            case "DISCOUNT":
                promoCodes.put(details[0],
                        new PercentOff(details[0], start, end,
                                Double.parseDouble(details[3].replace("%", "")), Double.parseDouble(details[4]),
                                Double.parseDouble(details[5])));
                System.out.println(("CREATE PROMO SUCCESS: DISCOUNT " + details[0]));
                break;
            case "CASHBACK":
                promoCodes.put(details[0],
                        new CashBack(details[0], start, end,
                                Double.parseDouble(details[3].replace("%", "")), Double.parseDouble(details[4]),
                                Double.parseDouble(details[5])));
                System.out.println(("CREATE PROMO SUCCESS: CASHBACK " + details[0]));
                break;
        }
    }
}
