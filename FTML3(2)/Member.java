/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

//keknya masih sama, cuman beda di makeOrder doang
public class Member extends Customer {
    Map<String, Order> orderpool = new HashMap<>();
    String fullname;
    LocalDate join;
    LocalDate today = LocalDate.now();
    // String password;

    public Member(String id, String fullName, LocalDate joindate, double balance) {
        super(id, balance);
        this.fullname = fullName;
        this.join = joindate;
    }

    public String getUserid() {
        return super.getId();
    }

    public void makeOrder(String id, int qty, LocalDate start) {
        if (orderpool.containsKey(id)) {
            orderpool.get(id).setQty(qty);
            return;
        }
        orderpool.put(id, new Order(id, qty, start));
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

    @Override
    public Map<String, Order> getOrderpool() {
        return orderpool;
    }

}