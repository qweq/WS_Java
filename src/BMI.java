import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //BMI = waga/wzrost^2 [kg/m^2]

        System.out.println("Podaj swoja wage w kg: ");
        double weight = scanner.nextDouble();
        System.out.println("Podaj swoj wzrost w cm: ");
        double height = scanner.nextDouble();
        height = height/100; // cm -> m
        System.out.println("Twoje BMI wynosi: " + weight/(height*height));
    }
}
