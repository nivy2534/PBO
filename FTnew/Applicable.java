/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package FTnew;

public interface Applicable {
    boolean isCostumerEligible(Customer x);

    boolean isMinimumPriceEligible(Order x);

    boolean isShippingFeeEligible(Order x);
}