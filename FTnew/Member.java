/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.UUID;

public class Member extends Customer {
    String userid;
    boolean isMember;
    LocalDate join;
    LocalDate today = LocalDate.now();
    String password;

    public Member(String firstName, String lastName, String id, String password) {
        super(firstName, lastName, id);
        this.userid = makeUserID();
        this.isMember = true;
        this.password = password;
    }

    private String makeUserID() {
        UUID uuid = UUID.randomUUID();
        String userId = uuid.toString().replaceAll("-", "").substring(0, 8);
        return userId;
    }

    public String getUserid() {
        return userid;
    }

    public Order makeOrder(String destination, String pickupAddress, String phoneNumber, LocalDate date, Car car) {
        return new Order(destination, pickupAddress, phoneNumber, date, car);
    }

    public String getFullName() {
        return super.getFullName(); // Generated from
                                    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAccountAge() {
        return Period.between(join, today).getDays();
    }

    public String getPassword() {
        return password;
    }
}