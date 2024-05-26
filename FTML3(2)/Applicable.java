package FTml3;

public interface Applicable {
    boolean isCostumerEligible(Customer x);

    boolean isMinimumPriceEligible(Order x);

    boolean isShippingFeeEligible(Order x);
}