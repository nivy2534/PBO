/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.util.Random;

public class Order {
    LocalDate dateOrder;
    int noOrder;
    double subprice;
    double totalPrice;
    double shippingCost;
    Promotion promo;
    Status orderStatus;
    Applicable applicable;
    Car car;

    // public void makeOrder(){

    // }

    public void generateNumberOrder() {
        Random rand = new Random();
        this.noOrder = rand.nextInt(100);
    }

    public void checkOut() {
        LocalDate today = LocalDate.now();
        this.dateOrder = today;
        pay();
    }

    public void printDetails(String fullName, String phoneNumber, String destination, String pickupAddress) {
        System.out.println("Nama: " + fullName);
        System.out.println("Nomor HP: " + phoneNumber);
        System.out.println("Nomor pesanan: " + noOrder);
        System.out.println("Alamat penjemputan: " + pickupAddress);
        System.out.println("Mobil: Avanza putih dengan plat N 1234 O");
    }

    public void applyPromo(Promotion x) {
        this.promo = x;
    }

    public void pay() {
        if (orderStatus == Status.UNPAID) {
            System.out.println("Pesanan telah dibayar.");
        } else {
            System.out.println("Pesanan telah dibayar pada tanggal: " + dateOrder);
        }
    }
}