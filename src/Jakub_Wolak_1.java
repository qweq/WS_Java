import java.util.Scanner;

public class Jakub_Wolak_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj pierwszą liczbę: ");
        int a = scanner.nextInt();
        System.out.println("Podaj drugą liczbę: ");
        int b = scanner.nextInt();
        System.out.println("Podaj trzecią liczbę: ");
        int c = scanner.nextInt();
        int maxInt = 0; // w tę zmienną wpiszę największą liczbę
        
        /*
        możliwe kombinacje dla róznych a, b, c:
        a b c ** !
        a c b **
        c a b *     ##
        c b a       ##
        b c a    !! #
        b a c    !!

        a = b:*    b = c:!    c = a:#
        a a c**    a b b
                   a b b      c c b##
        c a a                 c c b##
        c a a      b b a!!
                   b b a!!    b c c
        a a c**               b c c
         */

        if (a >= b) {           // tutaj rozpatruję przypadki oznaczone *
            if (a > c) {        // tutaj **
                maxInt = a;
            } else {            // to wykonuje się, gdy a == b == c (jako że a >= b i ~(a > c))
                maxInt = c;
            }
        } else if (b >= c) {    // !
            if (b > a) {        // !!
                maxInt = b;
            }
        } else if (c >= a && c > b) { // pierwszy warunek - #, drugi - ##
            maxInt = c;
        }

        if (a == b && a == c && b == c) {   // tutaj drugi raz sprawdza coś, co już wcześniej zostało sprawdzone
                                            // więc pewnie dałoby się to zrobić optymalniej, ale chyba bez przesady :P
            System.out.println("Wszystkie podane liczby są równe.");
        } else {
            System.out.println("Największa liczba spośród " + a + ", " + b + ", " + c + " to: " + maxInt);
        }
    }
}

