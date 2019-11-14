package pl.coderslab.warsztaty1.zad1;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random r = new Random();
        int wylosowanaLiczba = r.nextInt(100)+1;
        System.out.println("Wylosowałem liczbę, zgadnij jaką?");

        boolean win = false;
        int l = 0, liczbaSzans = 4;
        while (liczbaSzans <= 4 && liczbaSzans >= 0 && !win) {
            int liczba = wczytajLiczbe();
            l++;

            if (liczbaSzans > 0) {
                if (liczba < wylosowanaLiczba) {
                    System.out.println("Podana liczba jest za mała!");
                    System.out.println("Masz jeszcze " + liczbaSzans + " szanse");
                } else if (liczba > wylosowanaLiczba) {
                    System.out.println("Podana liczba jest za duża!");
                    System.out.println("Masz jeszcze " + liczbaSzans + " szanse");
                } else {
                    System.out.println("Zgadłeś za " + l + " razem");
                    win = true;
                }
            } else {
                if (liczba == wylosowanaLiczba) {
                    System.out.println("Zgadłeś za " + l + " razem");
                } else {
                    System.out.println("Koniec szans! Nie udało się zgadnąć!");
                }
            }
            liczbaSzans--;
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
