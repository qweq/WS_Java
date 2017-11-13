import java.util.Scanner;

public class FirstApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // klasa musiala zostac zaimportowana -> Alt+Enter
                                                    // klasa nazwa = konstruktor(parametry);

        System.out.println("Jak masz na imię? ");
        String name = scanner.next();
        System.out.println("Ile masz lat? ");
        int age = scanner.nextInt();
        System.out.println("Cześć, " + name + "! Masz " + age + " lat.");

        if(age >= 20) {
            System.out.println("Jesteś starym dziadem jak Strejlau i niedługo umrzesz.");
        } else if (age < 20 && age >= 10) {
            System.out.println("Jesteś gimbusem.");
        } else {
            System.out.println("Gu gu gu.");
        }
        System.out.println("Ale i tak cię lubię.");

        System.out.println("Podaj hasło");
        String pwd = scanner.next();
        if(pwd.equals("dupa.8")) {
            System.out.println("C64 BASIC\n64342 BYTES FREE");
        } else {
            System.out.println("ERROR. Złe hasło podałeś!");
        }
    }
}
