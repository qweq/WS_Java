package was2;

public class Switches {
    public static void main(String[] args) {
        int miesiac = 2;
        String monthString = null;
        switch (miesiac) {
            case 1:
                monthString = "styczeń";
                break;
            case 2:
                monthString = "luty";
                break;
            case 3:
                monthString = "marzec";
                break;
            default:
                monthString = "error";
                break;
        }
        System.out.println(monthString);
    }
}
