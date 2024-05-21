/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

//beda makerOrder doang
public abstract class Customer {

    private String id;
    private double balance;
    Order order;

    public Customer(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public abstract void makeOrder(String id, int qty, LocalDate start);

    // public abstract void confirmPay(int noOrder, int index);

    public int getAccountAge() {
        return -1;
    }

    // public void printOrder() {
    // for (int i = 0; i < orderIndex; i++) {
    // System.out.println((i + 1) + ". " + orderPool[i].destination + " - " +
    // orderPool[i].totalPrice);
    // System.out.printf(" %s\n", "Tanggal Keberangkatan : " +
    // orderPool[i].departureTime);
    // System.out.printf(" %s\n", "Nomor pesanan : " + orderPool[i].noOrder);
    // }
    // }
}