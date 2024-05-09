/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public abstract class Customer {
    static Order orderPool[] = new Order[20];
    static int orderIndex = 0;
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

    public abstract void makeOrder(String destination, String pickupAddress, String phoneNumber, Date date,
            Car car, Customer customer);

    public abstract void confirmPay(int noOrder, int index);

    private void setFullName() {
        this.fullName = firstName + " " + lastName;
    }

    public int getAccountAge() {
        return -1;
    }

    public void printOrder() {
        for (int i = 0; i < orderIndex; i++) {
            System.out.println((i + 1) + ". " + orderPool[i].destination + " - " + orderPool[i].totalPrice);
            System.out.printf("   %s\n", "Tanggal Keberangkatan : " + orderPool[i].departureTime);
            System.out.printf("   %s\n", "Nomor pesanan : " + orderPool[i].noOrder);
        }
    }
}
