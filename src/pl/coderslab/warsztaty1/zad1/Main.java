package pl.coderslab.warsztaty1.zad1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        System.out.println("Zadanie1");

        Random r = new Random();
        int wylosowanaLiczba = r.nextInt(100)+1;

        System.out.println("Wylosowałem liczbę, zgadnij jaką?");

        boolean win = false;
        int l = 0;
        while (!win) {
            int liczba = wczytajLiczbe();
            l++;

            if (liczba < wylosowanaLiczba) {
                System.out.println("Podana liczba jest za mała!");
            } else if (liczba > wylosowanaLiczba) {
                System.out.println("Podana liczba jest za duża!");
            } else {
                System.out.println("Zgadłeś za " + l + " razem");
                win = true;

            }
        }
    }

    public static int wczytajLiczbe() {
        System.out.println("Podaj liczbę");

        Scanner scan = new Scanner(System.in);
        while (!scan.hasNextInt()) {
            System.out.println("Musisz podać liczbę!");
            scan.next();
        }

        return scan.nextInt();
    }
}
