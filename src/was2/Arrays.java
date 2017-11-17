package was2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
/*        char[] charTable = {'a', 'b', 'c', 'd'};

        for (int i = 0; i < charTable.length; i++) {
            System.out.println(charTable[i]);
        }
        */

/*        int a = 10;
        int [] intTable = new int[a];

        for (int i = 0; i < intTable.length; i++) {
            intTable[i] = i * i;
        }

        for (int i = 0; i < intTable.length; i++) {
            System.out.print(intTable[i] + "\t");
        }*/

/*        int[][] int2D = new int[3][3];
        int b = 1;

        for (int i = 0; i < int2D.length; i++) {
            for (int j = 0; j < int2D[i].length; j++) {
                int2D[i][j] = b;
                b++;
            }
        }

        for (int i = 0; i < int2D.length; i++) {
            for (int j = 0; j < int2D[i].length; j++) {
                System.out.print(int2D[i][j] + "\t");
            }
            System.out.println("");
        }*/
        Scanner scanner = new Scanner(System.in);
        int dim = 0;

        System.out.println("Podaj wymiar tabliczki mnożenia");

        while (scanner.hasNext()) {
            try {
                dim = scanner.nextInt();

                if (dim > 0) {
                    int[][] tabliczkaMnozenia = new int[dim][dim];
                    for (int i = 0; i < tabliczkaMnozenia.length; i++) {
                        for (int j = 0; j < tabliczkaMnozenia[i].length; j++) {
                            tabliczkaMnozenia[i][j] = (i + 1) * (j + 1); // tabliczkę mnożenia zaczynamy od 1, nie 0
                            System.out.print(tabliczkaMnozenia[i][j] + "\t");
                        }
                        System.out.println("");
                    }
                    break;

                } else {
                    System.out.println("Wymiar musi być dodatni");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wymiar musi być dodatnią liczbą naturalną");
                break;
            }
        }
    }
}
