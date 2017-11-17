package was2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        // PĘTLA WHILE

/*        int a = 0;
        while (a < 10) {
            System.out.println("a: " + a);
            a++;
        }*/
/*
        int b = 0;
        do {
            System.out.println("To uruchomi się zawsze");
        } while (b > 10);*/

        // PĘTLA FOR

/*        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("For loop has ran " + i + " times (outer) and " + j + " times (inner)");
            }
        }*/

        Scanner scanner = new Scanner(System.in);
        int ocena = 0;

        System.out.println("Podaj ocenę 1-10");
        while (scanner.hasNext()) {
            try {
                ocena = scanner.nextInt();

                if (ocena >= 1 && ocena <= 10) {
                    System.out.println("Twoja ocena to: " + ocena);
                    break;
                } else {
                    System.out.println("Twoja ocena musi być w przedziale 1-10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Błąd: ocena musi być liczbą naturalną.");
                break;
            }

        }
    }
}
