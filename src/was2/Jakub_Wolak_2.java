package was2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jakub_Wolak_2 {
    public static void main(String[] args) {
        File file = new File("src\\was2\\napisy.txt");
        int counter = 0;
        boolean flag = false; // dodatkowa pomocnicza zmienna, żeby wypisać tylko jedną parę słów

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word1 = scanner.next();
                String word2 = scanner.next();

                if (word1.length() >= 3 * word2.length() || word2.length() >= 3 * word1.length()) { // pierwsze może być dłuższe od drugiego lub na odwrót
                    counter++;  // zwiększ licznik
                    if (flag == false) {    // jeśli flaga nie została jeszcze podniesiona
                        System.out.println(word1 + "\t" + word2); // wypisz parę
                        flag = true; // podnieś flagę - więcej par już się nie wypisze
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Liczba wierszy, w których jedno słowo jest co najmniej trzy razy dłuższe od drugiego: " + counter);
    }
}
