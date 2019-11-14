package pl.coderslab.warsztaty1.zad2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LOTTO();
    }

    public static int LOTTO() {

        int[] numbersSelected = selectNumbers();
        showNumbers(numbersSelected, "Wybrane przez Ciebie liczby to:");

        int[] drawnNumbers = drawingNumbers();
        showNumbers(drawnNumbers, "Wylosowane liczby to:");

        System.out.println(checkWin(numbersSelected, drawnNumbers));

        return 1;

    }

    static int[] selectNumbers() {
        int[] numbersSelected = new int[6];

        for (int i = 0; i < 6; i++) {
            int number = 0;
            boolean correct = false;
            while (!correct) {
                number = selecting(i);
                if (number < 1) {
                    System.out.println("Musisz podać liczbę z zakresu od 1 do 49");
                } else if (number > 49) {
                    System.out.println("Musisz podać liczbę z zakresu od 1 do 49");
                } else if (checkIfRepeated(i, number, numbersSelected) == true){
                    System.out.println("Liczba " + number + " została już podana!");
                } else {
                    correct = true;
                }
            }
            numbersSelected[i] = number;
        }
        return numbersSelected;
    }

    static int selecting(int i) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj " + (i+1) + " liczbę");
        while (!scan.hasNextInt()) {
            System.out.println("Musisz podac liczbę!");
            scan.next();
        }
        return scan.nextInt();
    }

    static boolean checkIfRepeated(int i, int number, int[] numbersSelected) {
        int j = 0;
        boolean repeated = false;
        while (j <= i) {
            if (number == numbersSelected[j]) {
                repeated = true;
            }
            j++;
        }
        return repeated;
    }

    static int[] drawingNumbers() {
        Integer[] drawingNumbers = new Integer[49];
        for (int i = 0; i < drawingNumbers.length; i++) {
            drawingNumbers[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(drawingNumbers));

        int[] drownNumbers = new int[6];
        for (int i = 0; i < drownNumbers.length; i++) {
            drownNumbers[i] = drawingNumbers[i];
        }

        return drownNumbers;
    }

    static void showNumbers(int[] numbersTable, String str) {
        Arrays.sort(numbersTable);
        System.out.println(str);
        for (int number : numbersTable) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    static String checkWin(int[] numbersSelected, int[] drawnNumbers) {
        String result = "";
        int theSame = 0;
        for (int i = 0; i < numbersSelected.length; i++) {
            for (int j = 0; j < drawnNumbers.length; j++) {
                if (numbersSelected[i] == drawnNumbers[j]) {
                    theSame++;
                }
            }
        }

        if (theSame < 3) {
            result += "Brak wygranej!";
        } else if (theSame == 3) {
            result += "Masz trójkę!";
        } else if (theSame == 4) {
            result += "Masz czwórkę!";
        } else if (theSame == 5) {
            result += "Masz piątkę!";
        } else if (theSame == 6) {
            result += "Masz szóstkę!!!";
        }

        return result;
    }
}
