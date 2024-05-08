package FTnew;

import java.time.LocalDate;
import java.util.Date;
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
    String destination, pickupAddress, phoneNumber;
    Date departureTime;
    Car car;
    // Customer customer;

    public Order(String destination, String pickupAddress, String phoneNumber, Date departureTime, Car car) {
        generateNumberOrder();
        this.destination = destination;
        this.pickupAddress = pickupAddress;
        this.phoneNumber = phoneNumber;
        this.car = car;
        this.departureTime = departureTime;
        this.orderStatus = orderStatus.UNPAID;
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

    public void printDetails(Customer customer) {
        System.out.printf("%-53s%s\n", "No. Order :", noOrder);
        System.out.printf("%-53s%s\n", "Status    :", orderStatus);
        System.out.println("Tipe akun : " + ((customer instanceof Member) ? "Member" : "Guest"));
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Nama: " + customer.getFullName());
        System.out.println("Nomor HP: " + phoneNumber);
        System.out.println("Nomor pesanan: " + noOrder);
        System.out.println("Alamat penjemputan: " + pickupAddress);
        System.out.println("Tujuan : " + destination);
        System.out.println("=============================================================");
        // System.out.println("Mobil: Avanza putih dengan plat N 1234 O");
    }

    public void applyPromo(Promotion x) {
        this.promo = x;
    }

    public void pay() {
        if (orderStatus == Status.UNPAID) {
            orderStatus = Status.SUCCESSFULL;
            System.out.println("Pesanan telah dibayar.");
        } else {
            System.out.println("Pesanan telah dibayar pada tanggal: " + dateOrder);
        }
    }
}
