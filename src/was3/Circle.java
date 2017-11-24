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
    }

    public boolean canFitSquareInside (Rectangle rect) {
        if (rect.getEdgeA() == rect.getEdgeB()) {
            return (radius == rect.getEdgeA() * Math.sqrt(2) * 0.5); // promień = połowa przekątnej kwadratu
        }
        return false;
    }

    public boolean canFitIntoSquare (Rectangle rect) {
        if (rect.getEdgeA() == rect.getEdgeB()) {
            return (radius == rect.getEdgeA() * 0.5); // promień = połowa boku kwadratu
        }
        return false;
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
