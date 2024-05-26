package FTml3;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Order {
    Scanner sc = new Scanner(System.in);
    LocalDate dateOrder;
    double subprice;
    double totalPrice;
    double shippingCost;
    Status orderStatus;
    Car car;
    ArrayList<Map> orderMenu = new ArrayList<>();

    // public Order(String id, int qty, LocalDate start) {
    // this.car = car.getVehicle().get(id); // ini buat ngisi car yg disini,
    // sebenrya keknny enak pake map, soalnya
    // // nanti kalo ada pesanan yg sama
    // // tinggal panggil keynya trs tambahin qtynya, paling perlu setter buat qty
    // this.qty += qty;
    // this.start = start; // nah jujur ini aku bingung, kalo misalkan beda tanggal
    // qtynya berubah atau
    // // engga
    // this.orderStatus = Status.UNPAID;
    // }

    public Order(Customer cust, String id) {
        this.orderStatus = Status.UNPAID;
        if (cust instanceof Member) {
            Member member = (Member) cust;
            orderMenu.add(member.getMenu());
        }
    }

    // public void setQty(int qty) {
    // this.qty += qty;
    // }

    // public void generateNumberOrder() {
    // Random rand = new Random();
    // this.noOrder = rand.nextInt(100);
    // }

    public void checkOut() {
        LocalDate today = LocalDate.now();
        this.dateOrder = today;
        pay();
        // printDetails();
    }

    // public String printDetails(Customer cust, String customerId, double balance)
    // {
    // DecimalFormat df = (DecimalFormat)
    // NumberFormat.getNumberInstance(Locale.GERMANY);
    // df.applyPattern("#,###");
    // String subtotal = df.format(getSubprice());
    // cust.setSubtotal(getSubprice());
    // String s = String.format(" %-26s | %4d | %9s\n %s", car.toString(), qty,
    // subtotal, start);
    // return s;
    // }

    public void printDetails2(Customer cust) {
        int index = 1;
        System.out.println("Kode Pemesan: " + cust.getId());
        System.out.println("Nama : " + (cust instanceof Member ? ((Member) cust).getFullName() : "NON_MEMBER"));
        if (orderStatus.equals(Status.SUCCESSFULL)) {
            System.out.println("Nomor Pesanan: " + cust.getOrderpool().indexOf(this));
            System.out.println("Tanggal Pemesanan: ");
        }
        System.out.printf("%3s | %-25s | %3s | %8s\n", "No", "Menu", "Dur.", "Subtotal");
        System.out.println("====================================================");

        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
        df.applyPattern("#,###");
        double Subtotal = 0;
        for (Map.Entry<String, Car> a : cust.getMenu().entrySet()) {
            Car car = a.getValue();
            double tmp = car.getHarga() * car.getQty();
            String subtotal = df.format(tmp);
            Subtotal += tmp;
            System.out.printf("%3d | %-25s | %4d | %8s \n", index, car.toString(), car.getQty(), subtotal);
            System.out.println("      " + car.getStart() + " - " + car.getStart().plus(Period.ofDays(car.getQty())));
            index++;
        }

        System.out.println("====================================================");
        System.out.printf("%-32s: %15s\n", "Sub Total", df.format(Subtotal));
        System.out.println("====================================================");
        System.out.printf("%-32s: %15s\n", "Total", df.format(Subtotal));
        System.out.printf("%-32s: %15s\n", "Saldo", df.format((cust.getBalance())));

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
    // public String toString() {
    // // TODO Auto-generated method stub
    // if (qty > 1) {
    // return qty + " days " + car + " " + ("UPDATE");
    // }
    // return qty + " day " + car + " " + ("NEW");
    // }
}