/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;

public class Guest extends Customer {
    public Guest(String firstName, String lastName, String id) {
        super(firstName, lastName, id);
    }

    @Override
    public void makeOrder(String destination, String pickupAddress, String phoneNumber, LocalDate date) {
        Order order = new Order();
        order.generateNumberOrder();
        order.printDetails(getFullName(), phoneNumber, destination, pickupAddress);
    }

    @Override
    public String getFullName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}