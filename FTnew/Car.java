/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FTnew;

public class Car {
    private String nama;
    private String jenis;
    private String noPlat;
    static boolean seat[] = new boolean[7];

    public Car() {

    }

    public Car(String nama, String jenis, String noPlat) {
        this.nama = nama;
        this.jenis = jenis;
        this.noPlat = noPlat;
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
}