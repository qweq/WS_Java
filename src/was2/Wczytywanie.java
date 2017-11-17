package was2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Wczytywanie {
    public static void main(String[] args) {
        File input = new File("C:\\Users\\rzezucha\\Desktop\\slowa.txt");
        int counter = 0;

        try {
            Scanner scanner = new Scanner(input);
            while(scanner.hasNext()) {
                String word1 = scanner.next();
                String word2 = scanner.next();

                int a = word1.length();
                int b = word2.length();

                if (word1.equalsIgnoreCase(word2)) {
                    System.out.println("Znaleziono identyczne słowo");
                    if (a == b) {
                        System.out.println("są one tej samej długości");
                    }
                }
                System.out.println(word1 + "\t" + word2);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
