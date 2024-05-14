/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;
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
        this.join = join.now();
    }

    private String makeUserID() {
        UUID uuid = UUID.randomUUID();
        String userId = uuid.toString().replaceAll("-", "").substring(0, 8);
        return userId;
    }

    public void confirmPay(int noOrder, int index) {
        Scanner sc = new Scanner(System.in);
        if (orderPool[index].orderStatus == Status.UNPAID) {
            System.out.println("Anda yakin untuk checkout? : (y/n)");
            String choice = sc.nextLine();
            switch (choice) {
                case "y":
                    orderPool[index].checkOut();
                    orderPool[index].orderStatus = Status.SUCCESSFULL;
                    if (orderPool[index].orderStatus == Status.SUCCESSFULL) {
                        if (orderIndex == 1) {
                            orderIndex = 0;
                        } else {
                            for (int i = 0; i < orderIndex; i++) {
                                orderPool[i] = orderPool[i + 1];
                            }
                            orderIndex--;
                        }
                    }
                    break;
                case "n":

                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Pesanan Telah dibayar");
        }
    }

    public String getUserid() {
        return userid;
    }

    public void makeOrder(String destination, String pickupAddress, String phoneNumber, Date date, Car car,
            Customer customer) {
        orderPool[orderIndex] = new Order(destination, pickupAddress, phoneNumber, date, car, customer);
        orderIndex++;
    }

    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public int getAccountAge() {
        return Period.between(join, today).getDays();
    }

    public String getPassword() {
        return password;
    }
}