package was3;

public class Jakub_Wolak_3 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(4, 5);
        rect.getArea();
        rect.fittingSquares(8);
        rect.fittingSquares(2.5);
        rect.fittingSquares(4);
        rect.fittingSquares(0.2);

        Rectangle rect2 = new Rectangle(5, 8);
        Rectangle rect3 = new Rectangle(2, 3);
        Rectangle rect4 = new Rectangle(4.2, 99.3);
        Rectangle rect5 = new Rectangle(10/Math.sqrt(2), 10/Math.sqrt(2));
        Rectangle rect6 = new Rectangle(10, 10);

        Circle circle = new Circle(10);
        Circle circle2 = new Circle(5);
        Circle circle3 = new Circle(4.8);
        Circle circle4 = new Circle(Math.PI);
        Circle circle5 = new Circle(1);
        Circle circle6 = new Circle(42);

        System.out.println(circle2.canFitIntoSquare(rect6) + "\t" + circle2.canFitSquareInside(rect6));
        System.out.println(circle2.canFitIntoSquare(rect5) + "\t" + circle2.canFitSquareInside(rect5));
    }
}
