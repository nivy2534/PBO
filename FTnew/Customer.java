/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.time.Period;

public abstract class Customer {
    private String fullName;
    private String firstName;
    private String lastName;
    private String id;
    Order order;

    public Customer(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public String getFullName() {
        setFullName();
        return fullName;
    }

    public String getId() {
        return id;
    }

    public abstract Order makeOrder(String destination, String pickupAddress, String phoneNumber, LocalDate date,
            Car car);

    public void confirmPay(int noOrder) {
        order.pay();
    }

    private void setFullName() {
        this.fullName = firstName + " " + lastName;
    }

    public int getAccountAge() {
        return -1;
    }
}