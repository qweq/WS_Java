package was3;

import java.util.ArrayList;
import java.util.List;

public class Jakub_Wolak_3 {
    public static void main(String[] args) {
        List<Rectangle> rectangles = new ArrayList<>(); // tworzę listę, aby móc zastosować pętlę for do tworzenia obiektów
        List<Circle> circles = new ArrayList<>();

        rectangles.add(new Rectangle(3, 7));                  //
        rectangles.add(new Rectangle(10));                      // spreparowane na potrzeby kolejnych podpunktów
        rectangles.add(new Rectangle(10 / Math.sqrt(2)));       //
        for (int i = 0; i < 3; i++) {
            rectangles.add(new Rectangle(Math.random() * 10, Math.random() * 10)); // kolejne już o dowolnych bokach
        }
        System.out.println("");

        // toString(), getArea(), modifyEdges()
        Rectangle rect = rectangles.get(0); // żeby nie trzeba było za każdym razem pisać rectangles.get(0)
        System.out.println(rect);
        System.out.println("Pole tego prostokąta wynosi " + rect.getArea());
        rect.modifyEdges(1, -2);
        System.out.println(rect);
        System.out.println("Pole tego prostokąta wynosi teraz " + rect.getArea());
        System.out.println("");

        // fittingSquares()
        rect.fittingSquares(18);
        rect.fittingSquares(2.5);
        rect.fittingSquares(4);
        rect.fittingSquares(0.3);
        System.out.println("");

        circles.add(new Circle(3.5)); // spreparowane
        for (int i = 0; i < 5; i++) {
            circles.add(new Circle(Math.random() * 10)); // o dowolnych promieniach
        }
        System.out.println("");

        // toString(), getArea(), modifyRadius()
        Circle circle = circles.get(0);
        System.out.println(circle);
        System.out.println("Pole tego koła wynosi " + circle.getArea());
        circle.modifyRadius(1.5);
        System.out.println(circle);
        System.out.println("Pole tego koła wynosi teraz " + circle.getArea());
        System.out.println("");

        // wpisywanie w/opisywanie na kwadracie
        circle.canFitIntoSquare(rectangles.get(1));
        circle.canFitSquareInside(rectangles.get(1));
        System.out.println("");
        circle.canFitIntoSquare(rectangles.get(2));
        circle.canFitSquareInside(rectangles.get(2));
    }
}
