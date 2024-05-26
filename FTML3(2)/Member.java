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
    private Map<String, Car> menu = new HashMap<>();
    private String fullname;
    private LocalDate join;
    LocalDate today = LocalDate.now();
    Car car;
    // String password;

    public Member(String id, String fullName, LocalDate joindate, double balance) {
        super(id, balance);
        this.fullname = fullName;
        this.join = joindate;
    }

    public String getUserid() {
        return super.getId();
    }

    public void makeOrder() {
        super.getOrderpool().add(new Order(this, super.getId()));
    }

    public void add(String id, int qty, LocalDate start) {
        if (menu.containsKey(id)) {
            car = menu.get(id).getVehicle().get(id);
            car.setQty(car.getQty() + qty);
            return;
        }
        if (car.getVehicle().containsKey(id)) {
            Car tmp = car.getVehicle().get(id);
            tmp.setQty(qty);
            tmp.setStart(start);
            menu.put(id, tmp);
        }
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
    public Map<String, Car> menu() {
        return menu;
    }

    public Map<String, Car> getMenu() {
        return menu;
    }

    public String getFullname() {
        return fullname;
    }

    public LocalDate getJoin() {
        return join;
    }
}