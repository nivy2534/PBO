/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.util.Date;

import online_book_store.customer;

public class Guest extends Customer {
    public Guest(String firstName, String lastName, String id) {
        super(firstName, lastName, id);
    }

    @Override
    public void makeOrder(String destination, String pickupAddress, String phoneNumber, Date date, Car car,
            Customer customer) {
        super.orderPool[orderIndex] = new Order(destination, pickupAddress, phoneNumber, date, car, customer);
        orderIndex++;
        // Order order = new Order();
        // order.generateNumberOrder();
        // order.printDetails(getFullName(), phoneNumber, destination, pickupAddress);
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }
}