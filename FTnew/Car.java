/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

public class Car {
    private String nama;
    private String jenis;
    private String noPlat;
    private int qty;
    boolean seat[][]; // apakah butuh static?

    public Car() {

    }

    public void setSeat() {
        int row = (qty - 1) / 3;
        seat = new boolean[row + 1][3];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                seat[i][j] = false;
            }
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
        int row = (qty - 1) / 3;
        System.out.println("| " + (seat[0][0] ? 1 : 0) + " |");
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("| %s |", (seat[i][j] ? 1 : 0));
            }
            System.out.println();
        }
    }
}
