/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

//ini juga msh sama, cuman beda di makeOrder
public class Guest extends Customer {
    static ArrayList<Order> orderpool = new ArrayList<>();

    public Guest(String id, double balance) {
        super(id, balance);
    }

    @Override
    public void makeOrder(String destination, String pickupAddress, String phoneNumber, Date date, Car car,
            Customer customer) {
        // Order order = new Order();
        // order.generateNumberOrder();
        // order.printDetails(getFullName(), phoneNumber, destination, pickupAddress);
    }

    // public void confirmPay(int noOrder, int index) {
    // Scanner sc = new Scanner(System.in);
    // if (orderPool[index].orderStatus == Status.UNPAID) {
    // System.out.println("Anda yakin untuk checkout? : (y/n)");
    // String choice = sc.nextLine();
    // switch (choice) {
    // case "y":
    // orderPool[index].checkOut();
    // orderPool[index].orderStatus = Status.SUCCESSFULL;
    // if (orderPool[index].orderStatus == Status.SUCCESSFULL) {
    // if (orderIndex == 1) {
    // orderIndex = 0;
    // } else {
    // for (int i = 0; i < orderIndex; i++) {
    // orderPool[i] = orderPool[i + 1];
    // }
    // orderIndex--;
    // }
    // }
    // break;
    // case "n":

    // break;
    // default:
    // break;
    // }
    // } else {
    // System.out.println("Pesanan Telah dibayar");
    // }
    // }
}