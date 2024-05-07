/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Order {
    Scanner sc = new Scanner(System.in);
    LocalDate dateOrder;
    int noOrder;
    double subprice;
    double totalPrice;
    double shippingCost;
    Promotion promo;
    Status orderStatus;
    Applicable applicable;
    Car car;

    public void makeOrder(String destination, String pickupAddress, String phoneNumber, LocalDate date, Car car) {
        // String destination, pickupAddress, phoneNumber;
        // LocalDate date;
        generateNumberOrder();
        while (true) {
            System.out.println("Seat tersedia : (0 tersedia, 1 tidak tersedia)");
            car.availableSeat();
            System.out.println("Silahkan pilih seat Anda : (no urut terkecil dari paling kiri dan terdepan)");
            System.out.println("1. seat 1");
            System.out.println("2. seat 2");
            System.out.println("3. seat 3");
            System.out.println("4. seat 4");
            System.out.println("5. seat 5");
            System.out.println("6. seat 6");
            System.out.println("7. seat 7");
            System.out.println("0. exit");
            int choice = sc.nextInt();
            if (choice > 4) {
                int seatRow = choice - 5;
                car.seat[2][seatRow] = true;
            } else if (choice > 1) {
                int seatRow = choice - 2;
                car.seat[1][seatRow] = true;
            } else
                car.seat[0][0] = true;

            if (choice == 0)
                break;
        }
    }

    public Order() {

    }

    public Order(String destination, String pickupAddress, String phoneNumber, LocalDate date, Car car) {
        makeOrder(destination, pickupAddress, phoneNumber, date, car);
    }

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
        System.out.println(orderStatus);
        System.out.println();
        System.out.println("Nama: " + fullName);
        System.out.println("Nomor HP: " + phoneNumber);
        System.out.println("Nomor pesanan: " + noOrder);
        System.out.println("Alamat penjemputan: " + pickupAddress);
        // System.out.println("Mobil: Avanza putih dengan plat N 1234 O");
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
