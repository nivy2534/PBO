/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

import java.util.Set;
import java.util.HashSet;

public class Car {
    private String nama;
    //private String jenis;
    private static String noPlat;
    //static private int qty;
    // static boolean seat[]; // apakah butuh static? -> butuh -> tergantung tanggal
    //private int choiceqty;
    private String idMenu;
    private int harga;
    private String customType;
    private boolean[] seat;

    private static Set<String> existingID = new HashSet<>();
    private static Set<String> existingPlat = new HashSet<>();

    public Car() {

    }

    public Car(String idMenu, String nama, String noPlat, int harga, String customType){
        if(existingID.contains(idMenu)){
            System.out.println("CREATE MENU FAILED: " + idMenu + " IS EXISTS");
            return;
        }
        if(existingPlat.contains(noPlat)){
            System.out.println("CREATE MENU FAILED: " + noPlat + " IS EXISTS");
            return;
        }

        this.idMenu = idMenu;
        this.nama = nama;
        this.noPlat = noPlat;
        this.harga = harga;
        this.customType = customType;
        setSeat();

        existingID.add(idMenu);
        existingPlat.add(noPlat);

        System.out.println("CREATE MENU SUCCESS: " + idMenu + " " + nama + " " + noPlat);
    }

    public void setSeat(){
        int qty = customType.equals("R") ? 4 : 6;
        seat = new boolean[qty];
        for (int i = 0; i < seat.length; i++) {
            seat[i] = false;
        }
    }

    // public int getChoiceqty() {
    //     return choiceqty;
    // }

    // public static int getQty() {
    //     return qty;
    // }

    // public void setSeat() {
    //     // int row = (qty - 1) / 3;
    //     // seat = new boolean[row + 1][3];
    //     // for (int i = 0; i < row; i++) {
    //     // for (int j = 0; j < 3; j++) {
    //     // seat[i][j] = false;
    //     // }
    //     // }
    //     seat = new boolean[qty];
    //     for (boolean b : seat) {
    //         b = false;
    //     }
    // }

    // public Car(String nama, String jenis, String noPlat, int qty) {
    //     this.nama = nama;
    //     this.jenis = jenis;
    //     this.noPlat = noPlat;
    //     this.qty = qty;
    //     setSeat();
    // }

    public String getIdMenu(){
        return idMenu;
    }

    public String getNama() {
        return nama;
    }

    // public String getJenis() {
    //     return jenis;
    // }

    public String getNoPlat() {
        return noPlat;
    }

    public int getHarga(){
        return harga;
    }

    public String getCustomType(){
        return customType;
    }

    public void availableSeat() {
        for (int i = 0; i < seat.length; i++) {
            if (i == 0) {
                System.out.println("| " + (seat[i] ? "1" : "0") + " |");
            } else {
                System.out.print("| " + (seat[i] ? "1" : "0") + " |");
                if (i % 3 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public void printInfo() {
        // System.out.println("Nama mobil : " + nama);
        // System.out.println("Jenis mobil : " + jenis);
        // for (int i = 0; i < seat.length; i++) {
        //     if (i == 0) {
        //         System.out.println("| " + (seat[i] ? "1" : "0") + " |");
        //     } else {
        //         System.out.print("| " + (seat[i] ? "1" : "0") + " |");
        //         if (i % 3 == 0) {
        //             System.out.println();
        //         }
        //     }
        // }
        System.out.println("ID Menu: " + idMenu);
        System.out.println("Nama: " + nama);
        System.out.println("No Plat: " + noPlat);
        System.out.println("Harga: " + harga);
        System.out.println("Type: " + customType);
        System.out.print("Seat: ");
        for (boolean s : seat) {
            System.out.print(s ? "1 " : "0 ");
        }
        System.out.println();
    }

    public static boolean isIdExists(String idMenu){
        return existingID.contains(idMenu);
    }

    public static boolean isPlatExists(String idMenu){
        return existingPlat.contains(noPlat);
    }

    // public void setChoiceqty(int choiceqty) {
    //     this.choiceqty = choiceqty;
    // }
}
