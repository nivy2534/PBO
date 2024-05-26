/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

//beda makerOrder doang
public abstract class Customer {
    static ArrayList<Order> orderpool = new ArrayList<>();
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

    public abstract void makeOrder();

    public abstract void add(String id, int qty, LocalDate start);

    // public abstract void confirmPay(int noOrder, int index);

    public int getAccountAge() {
        return -1;
    }

    public abstract Map<String, Car> menu();

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal += subtotal;
    }

    public static ArrayList<Order> getOrderpool() {
        return orderpool;
    }

    public abstract Map<String, Car> getMenu();
}