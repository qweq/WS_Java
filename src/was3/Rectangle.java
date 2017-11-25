package was3;

public class Rectangle {
    private double edgeA;
    private double edgeB;
    private static int rectangles = 0;

    Rectangle (double ab) { // kwadrat
        if (rectangles < 5) {
            this.edgeA = ab;
            this.edgeB = ab;
            System.out.println("Stworzono kwadrat o boku " + this.edgeA);
            rectangles++;
        } else {
            System.out.println("Istnieje przecież już 5 prostokątów. Ileż można?");
        }
    }

    Rectangle (double a, double b) { // prostokąt
        if (rectangles < 5) {
            this.edgeA = a;
            this.edgeB = b;
            System.out.println("Stworzono prostokąt o bokach " + this.edgeA + " oraz " + this.edgeB);
            rectangles++;
        } else {
            System.out.println("Istnieje przecież już 5 prostokątów. Ileż można?");
        }
    }

    public double getArea() {
        return edgeA * edgeB;
    }

    public void modifyEdges(double deltaA, double deltaB) {
        this.edgeA += deltaA;
        this.edgeB += deltaB;
        System.out.println("Zmieniono bok \"a\" o " + deltaA + " oraz bok \"b\" o " + deltaB);
    }

    public void fittingSquares(double edge) {
        if (edge > edgeA || edge > edgeB) {
            System.out.println("Tak duży kwadrat nie zmieści się w tym prostokącie!");
        } else {
            int result = (int) (Math.floor(edgeA / edge) * Math.floor(edgeB / edge)); // zaokrąglamy w dół, bo liczymy całe kwadraty

            // ---------- deklinacja w j. polskim :P -----------
            String kwadrat;
            String moc;
            switch (result % 10) { // ostatnia cyfra
                case 1:
                    kwadrat = "cały kwadrat";
                    moc = "może";
                    break;
                case 2:
                case 3:
                case 4:
                    kwadrat = "całe kwadraty";
                    moc = "mogą";
                    break;
                default:
                    kwadrat = "całych kwadratów";
                    moc = "może";
                    break;
            } // -----------------------------------------------

            System.out.println("W tym prostokącie " + moc + " zmieścić się " + result + " " + kwadrat + " o boku " + edge);
        }
    }

    public String toString() {
        return "Prostokąt o bokach " + edgeA + " i " + edgeB;
    }

    public double getEdgeA() {
        return edgeA;
    }

    public void setEdgeA(double edgeA) {
        this.edgeA = edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public void setEdgeB(double edgeB) {
        this.edgeB = edgeB;
    }
}
