/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FTnew;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import FT.Rent;

public class Ft_copy {
    static Customer mempool[] = new Member[20];
    static Order orderPool[] = new Order[20];

    public static void main(String[] args) {
        // Car carpool[] = new Car[20];
        // setCar(carpool);
        Car car = new Car("Avanza", "Putih", "N 1234 O", 7);
        Scanner sc = new Scanner(System.in);
        Customer customer;
        String firstName = "";
        String lastName = "";
        String id = "";
        int index = 0;
        while (true) {
            System.out.println("Halo, selamat datang di Filkom Travel");
            System.out.println("1. Log in");
            System.out.println("2. Sign in");
            System.out.println("3. Guest");
            System.out.println("Masukkan pilihan anda: ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Masukkan angka saja");
                sc.nextLine();
                continue;
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    // boolean cek = cektrue(false);
                    customer = cekMember();
                    if (customer != null) {
                        orderTravel(sc, car, customer, firstName, lastName, id, index);
                    } else {
                        System.out.println("Mohon buat akun atau login sebagai Guest");
                        continue;
                    }
                    break;
                case 2:
                    System.out.println("Masukkan nama depan Anda: ");
                    firstName = sc.nextLine();
                    System.out.println("Masukkan nama belakang Anda: ");
                    lastName = sc.nextLine();
                    System.out.println("Masukkan nomor KTP Anda: ");
                    id = sc.nextLine();
                    System.out.println("Masukkan password Anda: ");
                    String pass = sc.nextLine();
                    customer = new Member(firstName, lastName, id, pass);
                    mempool[index] = customer;
                    index++;
                    break;
                case 3:
                    orderTravelGuest(sc, car, firstName, lastName, id, index);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
        }
    }

    static void orderTravel(Scanner sc, Car car, Customer customer, String firstName, String lastName, String id,
            int index) {
        int loginChoice;
        do {
            System.out.println("1. Pesan travel");
            System.out.println("2. Checkout");
            System.out.println("0. Exit");
            System.out.println("Masukkan pilihan Anda: ");
            loginChoice = sc.nextInt();
            switch (loginChoice) {
                case 1:
                    System.out.println("Silakan pilih tujuan:");
                    System.out.println("1. Surabaya");
                    System.out.println("2. Malang");
                    System.out.println("3. Yogyakarta");
                    System.out.println("4. Semarang");
                    System.out.println("5. Jakarta");
                    System.out.println("6. Bandung");
                    System.out.println("Masukkan pilihan Anda: ");
                    int destinationChoice = sc.nextInt();
                    String destination = "";
                    switch (destinationChoice) {
                        case 1:
                            destination = "Surabaya";
                            break;
                        case 2:
                            destination = "Malang";
                            break;
                        case 3:
                            destination = "Yogyakarta";
                            break;
                        case 4:
                            destination = "Semarang";
                            break;
                        case 5:
                            destination = "Jakarta";
                            break;
                        case 6:
                            destination = "Bandung";
                            break;
                        default:
                            System.out.println("Tujuan tidak valid.");
                            break;
                    }
                    sc.nextLine(); // Consume newline character
                    System.out.println("Masukkan alamat penjemputan: ");
                    String pickupAddress = sc.nextLine();
                    System.out.println("Masukkan nomor HP: ");
                    String phoneNumber = sc.nextLine();
                    System.out.println("Masukkan tanggal keberangkatan : ");
                    Date dateDeparture;
                    SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
                    System.out.println("Masukkan tanggal Rent : (dd/mm/yyyy)");
                    try {
                        String departure = sc.next();
                        dateDeparture = date.parse(departure);
                    } catch (ParseException e) {
                        System.out.println("Format tanggal tidak valid. Gunakan format dd/MM/yyyy.");
                        return;
                    }
                    System.out.println("Silahkan pilih tempat duduk Anda : ");
                    chooseSeat(car, sc);
                    if (customer != null) {
                        customer.makeOrder(destination, pickupAddress, phoneNumber, dateDeparture, car);
                    } else {
                        System.out.println(
                                "Silakan pilih opsi '2' atau '3' terlebih dahulu untuk membuat akun.");
                    }
                    car.printInfo();
                    break;
                case 2:
                    checkOut(sc, customer);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
        } while (loginChoice != 0);

    }

    static void orderTravelGuest(Scanner sc, Car car, String firstName, String lastName, String id, int index) {
        Customer customer;
        int loginChoice;
        // int orderIndex = 0;
        System.out.println("Masukkan nama depan Anda: ");
        firstName = sc.nextLine();
        System.out.println("Masukkan nama belakang Anda: ");
        lastName = sc.nextLine();
        System.out.println("Masukkan nomor KTP Anda: ");
        id = sc.nextLine();
        customer = new Guest(firstName, lastName, id);
        do {
            System.out.println("1. Pesan travel");
            System.out.println("2. Checkout");
            System.out.println("0. Exit");
            System.out.println("Masukkan pilihan Anda: ");
            loginChoice = sc.nextInt();
            switch (loginChoice) {
                case 1:
                    System.out.println("Silakan pilih tujuan:");
                    System.out.println("1. Surabaya");
                    System.out.println("2. Malang");
                    System.out.println("3. Yogyakarta");
                    System.out.println("4. Semarang");
                    System.out.println("5. Jakarta");
                    System.out.println("6. Bandung");
                    System.out.println("Masukkan pilihan Anda: ");
                    int destinationChoice = sc.nextInt();
                    String destination = "";
                    switch (destinationChoice) {
                        case 1:
                            destination = "Surabaya";
                            break;
                        case 2:
                            destination = "Malang";
                            break;
                        case 3:
                            destination = "Yogyakarta";
                            break;
                        case 4:
                            destination = "Semarang";
                            break;
                        case 5:
                            destination = "Jakarta";
                            break;
                        case 6:
                            destination = "Bandung";
                            break;
                        default:
                            System.out.println("Tujuan tidak valid.");
                            break;
                    }
                    sc.nextLine(); // Consume newline character
                    System.out.println("Masukkan alamat penjemputan: ");
                    String pickupAddress = sc.nextLine();
                    System.out.println("Masukkan nomor HP: ");
                    String phoneNumber = sc.nextLine();
                    System.out.println("Masukkan tanggal keberangkatan : ");
                    Date dateDeparture;
                    SimpleDateFormat date = new SimpleDateFormat("dd/mm/yyyy");
                    System.out.println("Masukkan tanggal Rent : (dd/mm/yyyy)");
                    try {
                        String departure = sc.next();
                        dateDeparture = date.parse(departure);
                    } catch (ParseException e) {
                        System.out.println("Format tanggal tidak valid. Gunakan format dd/MM/yyyy.");
                        return;
                    }
                    System.out.println("Silahkan pilih tempat duduk Anda : ");
                    chooseSeat(car, sc);
                    if (customer != null) {
                        customer.makeOrder(destination, pickupAddress, phoneNumber, dateDeparture, car);
                    }
                    car.printInfo();
                    break;
                case 2:
                    checkOut(sc, customer);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
        } while (loginChoice != 0);
    }

    static Customer cekMember() {
        Scanner sc = new Scanner(System.in);
        boolean cek = false;
        boolean keepgoing = true;
        Customer memberCek = null;
        while (keepgoing) {
            System.out.println("Masukkan nama depan anda: ");
            String name = sc.nextLine();
            System.out.println("Masukkan nama belakang anda: ");
            String ln = sc.nextLine();
            System.out.println("Masukkan password akun anda: ");
            String password = sc.nextLine();

            for (Customer member : mempool) {
                if (member instanceof Member && ((Member) member).getPassword().equals(password)
                        && member.getFullName().equals(name + " " + ln)) {
                    memberCek = member;
                    cek = true;
                    break;
                }
            }
            if (!cek) {
                System.out.println("Data tidak ditemukan");
                System.out.println("Login ulang? (y/n)");
                String choice = sc.nextLine();
                switch (choice) {
                    case "y":

                        break;
                    case "n":
                        keepgoing = false;
                        break;
                    default:
                        break;
                }
            } else {
                keepgoing = false;
            }
        }
        return memberCek;
    }

    static Car chooseSeat(Car car, Scanner sc) {
        Car tmp = car;
        int choice;
        do {
            System.out.println("Seat tersedia : (0 tersedia, 1 tidak tersedia)");
            car.availableSeat();
            System.out.println("Silahkan pilih seat Anda : (no urut terkecil dari paling kiri dan terdepan)");
            for (int i = 0; i < car.getQty(); i++) {
                System.out.println((i + 1) + ". Seat " + (i + 1));
            }
            System.out.println("0. Exit");
            System.out.println("Pilihan Anda : ");
            choice = sc.nextInt();
            if (choice == 0)
                break;
            else if (choice > car.getQty())
                System.out.println("Pilihan tidak tersedia");
            else {
                if (!car.seat[choice - 1]) {
                    car.seat[choice - 1] = true;
                } else {
                    car.seat[choice - 1] = false;
                }
            }
        } while (choice != 0);
        return tmp;
    }

    // static void setCar(Car carpool[]) {
    // carpool[0] = new Car("Avanza", "Mobil Sedang", "N 1234 ABC", 7);
    // carpool[1] = new Car("Pregio", "Mobil Sedang", "N 5678 DEF", 10);
    // carpool[2] = new Car("Hiace", "Mobil besar", "N 9101 GHI", 15);
    // }
    static void checkOut(Scanner sc, Customer customer) {
        int choice;
        if (customer != null) {
            do {
                System.out.println("Pilih pesanan yang akan checkout : ");
                customer.printOrder();
                System.out.println("0. Exit");
                System.out.println("Pilihan Anda : ");
                choice = sc.nextInt();
                customer.orderPool[choice - 1].printDetails(customer);
            } while (choice != 0);
        } else {
            System.out.println("Buat pesanan terlebih dahulu");
        }
    }
}
