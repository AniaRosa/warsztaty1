package pl.coderslab.warsztaty1.zad4;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int wynik = rollDice("2D10+10");
        System.out.println(wynik);
    }

    public static int rollDice(String dice) {
        int x, y, z, indexD, indexPlus, indexMinus, result = 0;

        indexD = dice.indexOf("D");
        if (indexD == 0) {
            x = 1;
        } else {
            x = Integer.parseInt(dice.substring(0, indexD));
        }

        if (dice.contains("+")) {
            indexPlus = dice.indexOf("+");
            y = Integer.parseInt(dice.substring(indexD+1, indexPlus));
            z = Integer.parseInt(dice.substring(indexPlus+1));
        } else if (dice.contains("-")) {
            indexMinus = dice.indexOf("-");
            y = Integer.parseInt(dice.substring(indexD+1, indexMinus));
            z = Integer.parseInt(dice.substring(indexMinus));
        } else {
            y = Integer.parseInt(dice.substring(indexD+1));
            z = 0;
        }

        Random r = new Random();

        for (int i = 1; i <= x; i++) {
            int l = r.nextInt(y)+1;
            result += l;
        }

        return result+z ;
    }


}
