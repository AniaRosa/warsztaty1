package pl.coderslab.warsztaty1.zad5;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String urlList = "pl/coderslab/warsztaty1/zad5/urlList.txt";
        String wordsList = "pl/coderslab/warsztaty1/zad5/wordsList.txt";
        String popularWords = "pl/coderslab/warsztaty1/zad5/popular_words.txt";
        String filteredPopularWords = "pl/coderslab/warsztaty1/zad5/filtered_popular_words.txt";

        String[] urlTable = createTable(urlList);
        String[] specialSignsTable = createTable(wordsList);

        for (int i = 0; i < urlTable.length; i++) {
            savePopularWords(urlTable[i], popularWords);
        }
        saveFilteredPopularWords(filteredPopularWords, popularWords, specialSignsTable);
        System.out.println("Done!");
    }

    static String[] createTable(String list){
        String[] table = new String[0];
        try {
            Path path = Paths.get(list);
            Scanner scan = new Scanner(path);
            while (scan.hasNext()) {
                table = Arrays.copyOf(table, table.length + 1);
                table[table.length-1] = scan.next();
            }
        } catch (IOException ex) {
            System.out.println("Coś poszło nie tak");
        }
        return table;
    }

    static void savePopularWords(String url, String popularWords) {
        Connection connect = Jsoup.connect(url);
        File file = new File(popularWords);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            FileWriter fileWriter = new FileWriter(file, true);
            for (Element elem : links) {
                fileWriter.append(elem.text() + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveFilteredPopularWords(String filteredPopularWords, String popularWords, String[] specialSignsTable) {
        Path path = Paths.get(popularWords);
        File file = new File(filteredPopularWords);
        int l = 0, all = 0;
        try {
            Scanner scan = new Scanner(path);
            FileWriter fileWriter = new FileWriter(file, true);
            while (scan.hasNext()) {
                boolean excludedWord = false;
                String word = scan.next();
                all++;
                while (!Character.isLetter(word.charAt(0)) && word.length() >= 3) {
                    word = word.substring(1);
                }
                while (!Character.isLetter(word.charAt(word.length()-1)) && word.length() >= 3) {
                        word = word.substring(0, word.length()-1);
                }
                if (word.length() >= 3) {
                    for (int i = 0; i < specialSignsTable.length; i++) {
                        if (word.equals(specialSignsTable[i])) {
                            excludedWord = true;
                        }
                    }
                    if (!excludedWord) {
                        fileWriter.append(word + "\n");
                        l++;
                    }
                }
            }
            fileWriter.close();
            System.out.println("Zapisano " + l + " słów z " + all);

        } catch (IOException ex) {
            System.out.println("Coś poszło nie tak");
        }

    }
}
