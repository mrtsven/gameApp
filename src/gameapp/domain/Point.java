package gameapp.domain;

import javafx.scene.paint.Color;

public class Point {
    public static final Color COLOR = Color.BROWN;
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point translate(int dx, int dy){
        return new Point(x + dx, y + dy);
    }

    public boolean equals(Object other){
        if(!(other instanceof Point)) return false;
        Point point = (Point) other;
        return x == point.x & y == point.y;
    }

}
