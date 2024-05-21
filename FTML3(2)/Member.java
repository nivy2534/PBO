/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

//keknya masih sama, cuman beda di makeOrder doang
public class Member extends Customer {
    static ArrayList<Order> orderpool = new ArrayList<>();
    String fullname;
    boolean isMember;
    LocalDate join;
    LocalDate today = LocalDate.now();
    // String password;

    public Member(String id, String fullName, LocalDate joindate, double balance) {
        super(id, balance);
        this.fullname = fullName;
        this.join = joindate;
    }

    // private String makeUserID() {
    // UUID uuid = UUID.randomUUID();
    // String userId = uuid.toString().replaceAll("-", "").substring(0, 8);
    // return userId;
    // }

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

    public String getUserid() {
        return super.getId();
    }

    public void makeOrder(String id, int qty, LocalDate start) {
        orderpool.add(new Order(id, qty, start));
    }

    public String getFullName() {
        return fullname;
    }

    @Override
    public int getAccountAge() {
        return Period.between(join, today).getDays();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return fullname;
    }

}