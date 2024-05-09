package FTnew;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import online_book_store.customer;

public class Order {
    Scanner sc = new Scanner(System.in);
    LocalDate dateOrder;
    int noOrder;
    double subprice;
    double totalPrice;
    double shippingCost;
    Promotion promo[];
    Status orderStatus;
    Applicable applicable;
    String destination, pickupAddress, phoneNumber;
    Date departureTime;
    Car car;
    Customer customer;

    public Order(String destination, String pickupAddress, String phoneNumber, Date departureTime, Car car,
            Customer customer) {
        generateNumberOrder();
        this.destination = destination;
        this.pickupAddress = pickupAddress;
        this.phoneNumber = phoneNumber;
        this.car = car;
        this.departureTime = departureTime;
        this.orderStatus = orderStatus.UNPAID;
        this.customer = customer;
        destinationPrice(destination);
    }

    public void generateNumberOrder() {
        Random rand = new Random();
        this.noOrder = rand.nextInt(100);
    }

    public void checkOut() {
        LocalDate today = LocalDate.now();
        this.dateOrder = today;
        pay();
        printDetails();
    }

    public void printDetails() {
        if (orderStatus == Status.UNPAID) {
            System.out.println("=============================================================");
            System.out.println();
            System.out.println("Nama: " + customer.getFullName());
            System.out.println("Nomor HP: " + phoneNumber);
            System.out.println("Nomor pesanan: " + noOrder);
            System.out.println("Alamat penjemputan: " + pickupAddress);
            System.out.println("Tujuan : " + destination);
            System.out.println("Harga pesanan : " + subprice);
            System.out.println("=============================================================");
        } else {
            System.out.println("Tanggal Checkout : " + dateOrder);
            System.out.printf("%s%s\n", "No. Order : ", noOrder);
            System.out.printf("%s%s\n", "Status    : ", orderStatus);
            System.out.println("Tipe akun : " + ((customer instanceof Member) ? "Member" : "Guest"));
            System.out.println("=============================================================");
            System.out.println();
            System.out.println("Nama: " + customer.getFullName());
            System.out.println("Nomor HP: " + phoneNumber);
            System.out.println("Nomor pesanan: " + noOrder);
            System.out.println("Alamat penjemputan: " + pickupAddress);
            car.printInfo();
            System.out.println("Kursi pesanan : " + car.getChoiceqty());
            System.out.println("Tujuan : " + destination);
            System.out.println("Harga pesanan : " + subprice);
            System.out.println("=============================================================");
        }

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

    // public double getTotalPrice(Promotion promo){
    // double discPrice = promo.;
    // this.totalPrice = subprice - discPrice;
    // return totalPrice;
    // }
    public void destinationPrice(String dest) {
        double price = 0;
        switch (dest) {
            case "Surabaya":
                price = 50000;
                break;
            case "Malang":
                price = 25000;
                break;
            case "Yogyakarta":
                price = 100000;
                break;
            case "Semarang":
                price = 100000;
                break;
            case "Jakarta":
                price = 150000;
                break;
            case "Bandung":
                price = 150000;
                break;
            default:
                break;
        }
        this.subprice = price * car.getChoiceqty();
    }

    public double getTotalPrice() {

    }
}
