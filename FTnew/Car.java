/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

public class Car {
    private String nama;
    private String jenis;
    private String noPlat;
    static private int qty;
    static boolean seat[]; // apakah butuh static? -> butuh -> tergantung tanggal

    public Car() {

    }

    public static int getQty() {
        return qty;
    }

    public void setSeat() {
        // int row = (qty - 1) / 3;
        // seat = new boolean[row + 1][3];
        // for (int i = 0; i < row; i++) {
        // for (int j = 0; j < 3; j++) {
        // seat[i][j] = false;
        // }
        // }
        seat = new boolean[qty];
        for (boolean b : seat) {
            b = false;
        }
    }

    public Car(String nama, String jenis, String noPlat, int qty) {
        this.nama = nama;
        this.jenis = jenis;
        this.noPlat = noPlat;
        this.qty = qty;
        setSeat();
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public String getNoPlat() {
        return noPlat;
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
        System.out.println("Nama mobil : " + nama);
        System.out.println("Jenis mobil : " + jenis);
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
}
