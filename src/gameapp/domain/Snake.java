package gameapp.domain;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public static Color COLOR = Color.GREEN;
    public static Color DEAD = Color.RED;
    private Grid grid;
    private int joints;
    private Point head;
    private boolean safe = true;
    private List<Point> points;
    private int x;
    private int y;

    public Snake(Grid grid, Point initialPoint) {
        joints = 1;
        points = new LinkedList<>();
        points.add(initialPoint);
        head = initialPoint;
        this.grid = grid;
        x = 0;
        y = 0;
    }
    
    private void growTo(Point point){
        joints++;
        checkAndAdd(point);
    }

    private void shiftTo(Point point){
        checkAndAdd(point);

        points.remove(0);
    }

    private void checkAndAdd(Point point) {
        point = grid.wrap(point);
        safe &= !points.contains(point);
        points.add(point);
        head = point;
    }

    public boolean isSafe(){
        return safe || joints == 1;
    }

    public boolean isStill(){
        return x == 0 & y == 0;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point getHead(){
        return head;
    }

    public void move(){
        if(!isStill()){
            shiftTo(head.translate(x,y));
        }
    }

    public void extend(){
        if(!isStill()){
            growTo(head.translate(x,y));
        }
    }

    public void goUp(){
        if(y == 1 && joints > 1) return;
        x = 0;
        y = -1;
    }

    public void goDown(){
        if(y == -1 && joints > 1)return;
        x = 0;
        y = 1;
    }

    public void goLeft() {
        if (x == 1 && joints > 1) return;
        x = -1;
        y = 0;
    }

    public void goRight() {
        if (x == -1 && joints > 1) return;
        x = 1;
        y = 0;
    }
}
