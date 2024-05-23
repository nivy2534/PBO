package FTml3;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FilkomTravel {

    static Scanner sc = new Scanner(System.in);
    static Map<String, Customer> all = new HashMap<>(); // untuk masukkin id customer sm tipenya
    // static LinkedList<Car> car = new LinkedList<>(); // untuk masukkin daftar
    // mobil, jujur aku ga tau fungsinya :v
    // static LinkedList<Car> motor = new LinkedList<>(); // ini buat motor, sama
    // juga, ga tau aku fugnsinya :v
    static List<String> results = new ArrayList<>(); // ini buat ngeprint jawaban biar ga satu masukkan satu jawaban,
                                                     // gpt aja lah ya
    static Car car;

    public static void main(String[] args) {

        List<String> inputLines = new ArrayList<>();
        while (sc.hasNextLine()) {
            inputLines.add(sc.nextLine()); // ini buat masukkin jawabannya
        }
        for (String line : inputLines) {
            String s = line;
            // create member blalbla
            // add userid menuid qty tgl
            // create menu mobil id|nama nama|
            // add userid menuid qty tgl
            String[] command = s.split(" ", 3); // ini buat seperate commandnya, ku bedain karena nanti di bawah yg
                                                // bikin susah
            switch (command[0]) {
                case "CREATE":
                    create(command); // ini ku buat method terpisah kek biasa
                    break;
                case "ADD_TO_CART":
                    add(s); // ini juga
                    break;
                case "REMOVE_FROM_CART":
                    rm(s);
                    break;
                case "APPLY_PROMO":

                    break;
                case "TOPUP":
                    to(s);
                    break;
                case "CHECK_OUT":

                    break;
                case "PRINT":
                    prnt(s);
                    break;
                case "PRINT_HISTORY":

                    break;
                default:
                    results.add("UNKNOWN COMMAND");
                    break;
            }
        }

        for (String result : results) {
            System.out.println(result); // ini buat ngeprint resultnya
        }
    }

    // public static void order(Scanner sc, Customer customer, String s) {
    // System.out.println("jalan");
    // }

    private static void create(String command[]) {
        // create member blalba
        switch (command[1]) {
            case "MEMBER":
                // userid|nama nama|tgl|saldo
                String[] data = command[2].split("\\|"); // nah ini inputnya itu ada spasi sama | makanya aku pisah pake
                                                         // |, regexnya
                // 2023/04/20
                // 2023-04-20
                // 20-04-2023
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // ini format dari string ke
                                                                                      // localdate
                LocalDate join = LocalDate.parse(data[2], format);// ini parse(translate dari string ke localdate)
                if (!all.containsKey(data[0])) { // ini ngecek kalo si id nya udh ada blm di all
                    all.put(
                            data[0], new Member(data[0], data[1], join, Double.parseDouble(data[3]))); // kalo ga ada
                                                                                                       // dimasukkin
                    System.out.println("CREATE MEMBER SUCCESS: " + data[0] + " " + data[1]);// sout hasiknya, ni ga
                                                                                            // masuk ke yg array result,
                                                                                            // aku nyoba dan berhasil
                    // tapi ga tau maksud output bapaknya kek kalo kode ini dijalanin atau engga, jd
                    // coba aja di run
                } else {
                    System.out.println("CREATE MEMBER FAILED: " + data[0] + " IS EXISTS");// ini kalo idnya udh kepake
                }
                break;
            case "GUEST":
                // kurleb yg guest ini sama kek yg member
                String[] data2 = command[2].split("\\|");
                if (!all.containsKey(data2[0])) {
                    all.put(data2[0], new Guest(data2[0], Double.parseDouble(data2[1])));
                    System.out.println("CREATE GUEST SUCCESS: " + data2[0]);
                } else {
                    System.out.println("CREATE GUEST FAILED: " + data2[0] + " IS EXISTS");
                }
                break;
            case "MENU":
                // ini buat masukkin menu
                // create menu mobil id|nama nama|
                String data3[] = command[2].split(" ", 2); // kenapa 2 karena yg ada spasi nya itu mobil bla bla bla,
                                                           // nah nama mobil kan bisa spasi
                // kalo ga dikasih limit, ntar nama mobilnya juga kebelah
                String n[] = data3[1].split("\\|");// ini baru mecah informasi mobil yang mau dimasukkin
                if (data3[0].equalsIgnoreCase("Mobil")) {// ini buat ngecek constructor car yg mana yg mau dipake
                    new Car(n[0], n[1], n[2], Double.parseDouble(n[3]), n[4]); // ini buat objeknya
                } else {
                    new Car(n[0], n[1], n[2], Double.parseDouble(n[3]));// ini juga
                }
                break;
            case "PROMO":
                // under maintennance
                if (command[2].equals("DISCOUNT")) {

                } else if (command[2].equals("CASHBACK")) {

                }
                break;
            default:
                results.add("UNKNOWN CREATE COMMAND");
                break;
        }
    }

    static private void add(String s) {
        // nah ini input yg ribet, soalnya regex nya pake spasi " " bukan | jdnya
        // mending di lempar argument String aja dr pada array
        // add userid menuid qty tgl
        String data[] = s.split(" "); // baru dipisah di sini commandnya (si s)
        Customer cust = all.get(data[1]); // ini buat ngambil cust dari all
        if (cust instanceof Member) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // ini buat parse tanggal dari string,
                                                                                  // formatnya
            LocalDate date = LocalDate.parse(data[4], format);// ini localdate tanggal pesennya
            // System.out.println(data[4]);
            cust.makeOrder(data[2], Integer.valueOf(data[3]), date);// ini make ordernya
            System.out.println("ADD_TO_CART SUCCESS: " + cust.getOrderpool().get(data[2]));
        } else if (cust instanceof Guest) {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // ini buat parse tanggal dari string,
                                                                                  // formatnya
            LocalDate date = LocalDate.parse(data[4], format);
            cust.makeOrder(data[2], Integer.valueOf(data[3]), date);
            System.out.println("ADD_TO_CART SUCCESS: " + cust.getOrderpool().get(data[2]));
        } else {
            System.out.println("ADD_TO_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
        }
    }

    static private void rm(String s) {
        String data[] = s.split(" ");
        Customer cust = all.get(data[1]);

        if (cust != null && car.getVehicle().containsKey(data[2]) && cust.getOrderpool().containsKey(data[2])) {
            Order order = cust.getOrderpool().get(data[2]);
            order.qty -= Integer.parseInt(data[3]);

            if (order.qty <= 0) {
                System.out.println("REMOVE_FROM_CART: " + order.car + " IS REMOVED");
                cust.getOrderpool().remove(data[2]);
            } else {
                System.out.println("REMOVE_FROM_CART: " + order.car + " QUANTITY DECREMENTED");
            }
        } else {
            System.out.println("REMOVE_FROM_CART FAILED: NON EXISTENT CUSTOMER OR MENU");
        }
    }

    static private void to(String s) {
        String data[] = s.split(" ");
        Customer cust = all.get(data[1]);
        if (cust != null) {
            double tmp = cust.getBalance() + Double.parseDouble(data[2]);
            System.out.printf("TOPUP SUCCESS: %s %.0f => %.0f\n", cust.toString(), cust.getBalance(), tmp);
            cust.setBalance(tmp);
        } else {
            System.out.println("TOPUP FAILED: NON EXISTENT CUSTOMER");
        }
    }

    static private void prnt(String s) {
        String data[] = s.split(" ");
        Customer cust = all.get(data[1]);
        if (cust instanceof Member) {
            int index = 1;
            Member member = (Member) cust;
            System.out.println("Kode Pemesan: " + cust.getId());
            System.out.println("Nama : " + member.getFullName());
            System.out.printf(" No | %-26s | Dur. |  Subtotal\n", "menu");
            System.out.println("====================================================");
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
            double total = 0;
            df.applyPattern("#,###");
            for (Map.Entry<String, Order> a : member.getOrderpool().entrySet()) {
                Order order = a.getValue();
                // Format subtotal as string using DecimalFormat
                String subtotal = df.format(order.getSubprice());
                total += order.getSubprice();
                System.out.printf("  %d | %-26s | %4d | %9s\n", index, order.car.toString(), order.qty, subtotal);
                System.out.printf("      %s\n", order.start.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                index++;
            }
            System.out.println("====================================================");
            System.out.printf("%-33s: %16s\n", "Sub Total", df.format(total));
            System.out.println("====================================================");
            System.out.printf("%-33s: %16s\n", "Total", df.format(total));
            System.out.printf("%-33s: %16s\n", "Saldo", df.format(member.getBalance()));
        } else {
            int index = 1;
            Guest guest = (Guest) cust;
            System.out.println("Kode Pemesan: " + cust.getId());
            System.out.println("Nama : " + "NON_MEMBER");
            System.out.printf(" No | %-26s | Dur. |  Subtotal\n", "menu");
            System.out.println("====================================================");
            DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.GERMANY);
            double total = 0;
            df.applyPattern("#,###");
            for (Map.Entry<String, Order> a : guest.getOrderpool().entrySet()) {
                Order order = a.getValue();
                // Format subtotal as string using DecimalFormat
                String subtotal = df.format(order.getSubprice());
                total += order.getSubprice();
                System.out.printf("  %d | %-26s | %4d | %9s\n", index, order.car.toString(), order.qty, subtotal);
                System.out.printf("      %s\n", order.start.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                index++;
            }
            System.out.println("====================================================");
            System.out.printf("%-33s: %16s\n", "Sub Total", df.format(total));
            System.out.println("====================================================");
            System.out.printf("%-33s: %16s\n", "Total", df.format(total));
            System.out.printf("%-33s: %16s\n", "Saldo", df.format(guest.getBalance()));
        }
    }
}