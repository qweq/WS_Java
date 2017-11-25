package was3;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    private double radius;
    private static List<Circle> circles = new ArrayList<>();

    Circle (double r) {
        if (circles.size() < 5) {
            this.radius = r;
            System.out.println("Stworzono koło o promieniu " + radius);
            circles.add(this);
        } else {
            System.out.println("Istnieje już pięć kół u tego wozu i więcej nie trzeba.");
        }
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public void modifyRadius(double delta) {
        radius += delta;
        System.out.println("Zmieniono promień koła o " + delta);
    }

    // opisywanie koła na kwadracie -> średnica == przekątna
    public void canFitSquareInside(Rectangle rect) {
        if (rect.getEdgeA() == rect.getEdgeB()) { // czy jest kwadratem?
            if (radius == rect.getEdgeA() * Math.sqrt(2) * 0.5) { // promień = połowa przekątnej kwadratu
                System.out.println("Koło o promieniu " + radius + " można opisać na kwadracie o boku " + rect.getEdgeA());
            } else {
                System.out.println("Koła o promieniu " + radius + " nie można opisać na kwadracie o boku " + rect.getEdgeA());
            }
        } else System.out.println("Argument nie jest kwadratem.");
    }

    // wpisywanie koła w kwadrat -> średnica == bok
    public void canFitIntoSquare(Rectangle rect) {
        if (rect.getEdgeA() == rect.getEdgeB()) {
            if (radius == rect.getEdgeA() * 0.5) { // promień = połowa boku kwadratu
                System.out.println("W kwadrat o boku " + rect.getEdgeA() + " można wpisać koło o promieniu " + radius);
            } else {
                System.out.println("W kwadrat o boku " + rect.getEdgeA() + " nie można wpisać koła o promieniu " + radius);
            }
        } else System.out.println("Argument nie jest kwadratem");
    }

    public String toString() {
        return "Koło o promieniu " + radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
