package pl.coderslab.warsztaty1.zad3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String more = "więcej", less = "mniej", hit = "trafiłeś";
        int l = 0, min = 0, max = 1000;

        System.out.println("Pomyśl liczbę od 0 do 100, a ja ją zgadnę w maksymanlnie 10 próbach");
        boolean correct = true;
        int num = 0;

        while (l < 10) {
            int number = guessNumber(min, max, correct, num);
            System.out.println(number);
            String check = check(less, more, hit);
            correct = true;
            l++;

            if (check.equals(more)) {
                if (10-l > 0) {
                    System.out.println("Masz jeszcze " + (10-l) + " szans!");
                    min = number;
                } else {
                    System.out.println("Nie zgadłeś!");
                }
            } else if (check.equals(less)) {
                if (10-l > 0) {
                    System.out.println("Masz jeszcze " + (10-l) + " szans!");
                    max = number;
                } else {
                    System.out.println("Nie zgadłeś!");
                }
            } else if (check.equals(hit)) {
                System.out.println("Udało Ci się za " + l + " razem. Moja liczba to: " + number + "!");
                l = 10;
            } else {
                System.out.println("Literówka!");
                correct = false;
                num = number;
                l--;
            }
        }
    }

    static int guessNumber(int min, int max, boolean correct, int num) {
        Random r = new Random();
        boolean ok = false;
        int number = 0;
        if (correct == true) {
            while (!ok) {
                number = r.nextInt(max)+min;
                if (number > min && number < max) {
                    ok = true;
                }
            }
        } else {
            number = num;
        }
        return number;
    }

    static String check(String less, String more, String hit) {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
