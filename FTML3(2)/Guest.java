/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//ini juga msh sama, cuman beda di makeOrder
public class Guest extends Customer {
    private Map<String, Car> menu = new HashMap<>();
    Car car;

    public Guest(String id, double balance) {
        super(id, balance);
    }

    @Override
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
    @Override
    public Map<String, Car> menu() {
        // TODO Auto-generated method stub
        return menu;
    }

    public Map<String, Car> getMenu() {
        return menu;
    }

    @Override
    public double getBalance() {
        // TODO Auto-generated method stub
        return super.getBalance();
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return super.getId();
    }

    public Car getCar() {
        return car;
    }

    @Override
    public int getAccountAge() {
        // TODO Auto-generated method stub
        return super.getAccountAge();
    }
}