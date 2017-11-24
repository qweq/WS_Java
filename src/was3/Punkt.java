package was3;

public class Punkt {
    private int x;
    private int y;

    Punkt() {
        this.x = 0;
        this.y = 0;
    }

    Punkt(int xy) {
        this.x = xy;
        this.y = xy;
    }

    Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return this.x;
    }

    void setX(int newX) {
        this.x = newX;
    }

    int getY() {
        return this.y;
    }

    void setY(int newY) {
        this.y = newY;
    }

    void moveXY(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
