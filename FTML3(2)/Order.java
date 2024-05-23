package FTml3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Order {
    Scanner sc = new Scanner(System.in);
    LocalDate dateOrder;
    double subprice;
    double totalPrice;
    double shippingCost;
    Status orderStatus;
    LocalDate start;
    int qty = 0;
    Car car;
    Customer customer;

    public Order(String id, int qty, LocalDate start) {
        this.car = car.getVehicle().get(id); // ini buat ngisi car yg disini, sebenrya keknny enak pake map, soalnya
                                             // nanti kalo ada pesanan yg sama
        // tinggal panggil keynya trs tambahin qtynya, paling perlu setter buat qty
        this.qty += qty;
        this.start = start; // nah jujur ini aku bingung, kalo misalkan beda tanggal qtynya berubah atau
                            // engga
    }

    public void setQty(int qty) {
        this.qty += qty;
    }

    // public void generateNumberOrder() {
    // Random rand = new Random();
    // this.noOrder = rand.nextInt(100);
    // }

    public void checkOut() {
        LocalDate today = LocalDate.now();
        this.dateOrder = today;
        pay();
        printDetails();
    }

    public void printDetails() {
        // if (orderStatus == Status.UNPAID) {
        // System.out.println("=============================================================");
        // System.out.println();
        // System.out.println("Nama: " + customer.getFullName());
        // System.out.println("Nomor HP: " + phoneNumber);
        // // System.out.println("Nomor pesanan: " + noOrder);
        // System.out.println("Alamat penjemputan: " + pickupAddress);
        // System.out.println("Tujuan : " + destination);
        // System.out.println("Harga pesanan : " + subprice);
        // System.out.println("=============================================================");
        // } else {
        // System.out.println("Tanggal Checkout : " + dateOrder);
        // System.out.printf("%s%s\n", "No. Order : ", noOrder);
        // System.out.printf("%s%s\n", "Status : ", orderStatus);
        // System.out.println("Tipe akun : " + ((customer instanceof Member) ? "Member"
        // : "Guest"));
        // System.out.println("=============================================================");
        // System.out.println();
        // System.out.println("Nama: " + customer.getFullName());
        // System.out.println("Nomor HP: " + phoneNumber);
        // System.out.println("Nomor pesanan: " + noOrder);
        // System.out.println("Alamat penjemputan: " + pickupAddress);
        // car.printInfo();
        // System.out.println("Kursi pesanan : " + car.getChoiceqty());
        // System.out.println("Tujuan : " + destination);
        // System.out.println("Harga pesanan : " + getTotalPrice());
        // System.out.println("=============================================================");
        // }

        // System.out.println("Mobil: Avanza putih dengan plat N 1234 O");
    }

    // public void applyPromo(Promotion x) {
    // this.promo = x;
    // }

    public void pay() {
        if (orderStatus == Status.UNPAID) {
            orderStatus = Status.SUCCESSFULL;
            System.out.println("Pesanan telah dibayar.");
        } else {
            System.out.println("Pesanan telah dibayar pada tanggal: " + dateOrder);
        }
    }

    public double getSubprice() {
        this.subprice = qty * car.getHarga();
        return subprice;
    }

    public double getTotalPrice() {
        // ini nanti kali diskon kali qty
        return car.getHarga();
    }

    // ini aku nyoba buat debug, biar tau salah atau engga
    public String toString() {
        // TODO Auto-generated method stub
        if (qty > 1) {
            return qty + " days " + car + " " + ("UPDATE");
        }
        return qty + " day " + car + " " + ("NEW");
    }
}