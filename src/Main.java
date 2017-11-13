public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello World!"); // jest to polecenie do wyswietlania

        // TYPY ZMIENNYCH, PRINTLN
        byte b = 10; // (-128; 127) calkowite - zawsze signed (jak w sumie wszystko)
        short s = 300; // (-32768; 32767) 2 bajty calkowite
        int i = 1000; // tylko calkowite - najczestszy
        long l = 2000; // island ice tea

        float f = 3.14f; // pamietac o przyrostku!
        double d = 3.14d;

        char c = 'a';
        String pierwszyNapis = "Pierwsze zdanie";

        /*System.out.println(pierwszyNapis);
        System.out.println("nasz double wynosi: " + d);
        System.out.println(c);*/

        //OPERATORY + - * / %
        int num1 = 50/2;
        int num2 = 10*3;
        int num3 = num1 - num2;
        int num4 = 5%3;

        System.out.println("Pierwsza liczba: " + num1 + "\nDruga liczba: " + num2 + "\nTrzecia liczba: " + num3
                + "\nCzwarta liczba: " + num4);

        System.out.println(5/3f);
        double xd = 5/3d; // mozna 1.0*5/3
        System.out.println(xd);

        char literka = 'e'; // ASCII A = 65; a = 97
        System.out.println((byte)literka);

        // ZADANIE - uzywajac jednego operatora zamien duza litere na mala
        char lit = 'c';

        System.out.println((char)(lit-(97-65))); // w sumie dwa operatory, ale nie chce mi sie liczyc, ile to jest 97 - 65 (32)

        // OPERATORY LOGICZNE == && || !=

        boolean p = (10 != 3);
        System.out.println(p);
    }
}
