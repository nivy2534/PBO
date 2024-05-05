/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package FTnew;

import java.time.LocalDate;
import java.util.*;

public class Ft_copy {
    static Customer mempool[] = new Member[20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = null;
        String firstName;
        String lastName;
        String id;
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
                    boolean cek = cekMember();
                    // cekMember();
                    if (cek) {
                        System.out.println("1. Pesan travel");
                        System.out.println("0. Exit");
                        System.out.println("Masukkan pilihan Anda: ");
                        int loginChoice = sc.nextInt();
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
                                LocalDate date = LocalDate.now();
                                if (customer != null) {
                                    customer.makeOrder(destination, pickupAddress, phoneNumber, date);
                                } else {
                                    System.out.println(
                                            "Silakan pilih opsi '2' atau '3' terlebih dahulu untuk membuat akun.");
                                }
                                break;
                            case 0:
                                System.out.println("Terima kasih telah menggunakan layanan kami.");
                                System.exit(0);
                            default:
                                System.out.println("Pilihan tidak tersedia.");
                                break;
                        }
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
                    System.out.println("Masukkan nama depan Anda: ");
                    firstName = sc.nextLine();
                    System.out.println("Masukkan nama belakang Anda: ");
                    lastName = sc.nextLine();
                    System.out.println("Masukkan nomor KTP Anda: ");
                    id = sc.nextLine();
                    customer = new Guest(firstName, lastName, id);
                    System.out.println("1. Pesan travel");
                    System.out.println("0. Exit");
                    System.out.println("Masukkan pilihan Anda: ");
                    int loginChoice = sc.nextInt();
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
                            LocalDate date = LocalDate.now();
                            if (customer != null) {
                                customer.makeOrder(destination, pickupAddress, phoneNumber, date);
                            } else {
                                System.out
                                        .println("Silakan pilih opsi '2' atau '3' terlebih dahulu untuk membuat akun.");
                            }
                            break;
                        case 0:
                            System.out.println("Terima kasih telah menggunakan layanan kami.");
                            System.exit(0);
                        default:
                            System.out.println("Pilihan tidak tersedia.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    break;
            }
        }
    }

    static boolean cekMember() {
        Scanner sc = new Scanner(System.in);
        boolean cek = false;
        boolean keepgoing = true;
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
        return cek;
    }
}
