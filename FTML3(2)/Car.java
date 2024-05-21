/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTml3;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Car {
    private String nama;
    private String jenis;
    private String noPlat;
    private String idMenu;
    private double harga;
    private String customType;
    private static Map<String, Car> vehicle = new HashMap<>(); // ini buat jadiin satu kendaraannya, soalnya bapaknya ga
                                                               // minta bedain
    // minta sih, tapi ga apa ya, inputnya ga bedain gitu pas di add to cart, baca
    // lagi inputnya
    private static Set<String> existingID = new HashSet<>(); // ini buat masukkin id
    private static Set<String> existingPlat = new HashSet<>(); // ini buat no plat

    public Car() {
        // ni kosongan kalo perlu
    }

    public Car(String idMenu, String nama, String noPlat, double harga, String customType) {
        if (existingID.contains(idMenu)) {
            System.out.println("CREATE MENU FAILED: " + idMenu + " IS EXISTS"); // ini buat nyari si idnya udh kepake
                                                                                // apa blm
            return;
        }
        if (existingPlat.contains(noPlat)) {
            System.out.println("CREATE MENU FAILED: " + noPlat + " IS EXISTS"); // ini buat nyari si platnya udh kepake
                                                                                // blm
            return;
        }
        // ini insialisasi biasa
        this.idMenu = idMenu;
        this.nama = nama;
        this.noPlat = noPlat;
        this.harga = harga;
        this.customType = customType;

        // ini buat masuk masukkin data yg udh ada
        existingID.add(idMenu);
        existingPlat.add(noPlat);
        vehicle.put(idMenu, this); // ini buat masukkin ke list vehiclenya, pake map karena biar mudah nyarinya
        System.out.println("CREATE MENU SUCCESS: " + idMenu + " " + nama + " " + noPlat); // ini output kalo berhasil
    }

    public Car(String idMenu, String nama, String noPlat, double harga) {
        // ini kurleb sama kek yg atas
        if (existingID.contains(idMenu)) {
            System.out.println("CREATE MENU FAILED: " + idMenu + " IS EXISTS");
            return;
        }
        if (existingPlat.contains(noPlat)) {
            System.out.println("CREATE MENU FAILED: " + noPlat + " IS EXISTS");
            return;
        }

        this.idMenu = idMenu;
        this.nama = nama;
        this.noPlat = noPlat;
        this.harga = harga;
        // this.customType = customType;

        existingID.add(idMenu);
        existingPlat.add(noPlat);
        vehicle.put(idMenu, this);
        System.out.println("CREATE MENU SUCCESS: " + idMenu + " " + nama + " " + noPlat);
    }

    public static Map<String, Car> getVehicle() {
        // ini buat manggil vehicle
        return vehicle;
    }

    public String getIdMenu() {
        // ini buat ngambil id
        return idMenu;
    }

    public String getNama() {
        // ini buat ngambil nama mobil, nama pabrik sm merk jadi satu
        return nama;
    }

    public String getNoPlat() {
        // ini buat ngambil plat
        return noPlat;
    }

    public double getHarga() {
        // ini buat ngambil harga mobil
        return harga;
    }

    public String getCustomType() {
        // ini khusus mobil
        return customType;
    }

    public static boolean isIdExists(String idMenu) {
        // loh aku baru baca ini :v intinya buat ngecek ada apa negga
        return existingID.contains(idMenu);
    }

    public boolean isPlatExists(String idMenu) {
        // ini juga sama, tapi buat nyari plat
        return existingPlat.contains(noPlat);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return nama;
    }
}