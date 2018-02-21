package gameapp.domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Grid {
    public static final int SIZE = 10;
    public static final Color COLOR = new Color(0.1,0.1,0.1,1);

    private int cols;
    private int rows;

    private Snake snake;
    private Point food;

    public Grid(double width, double height){
        rows = (int) width /SIZE;
        cols = (int) height /SIZE;


        // initialize the snake at the centre of the screen
        snake = new Snake(this, new Point(rows / 2, cols / 2));

        // put the food at a random location
        food = new Point(getRandomX(), getRandomY());
    }

    public Point wrap(Point point){
        int x = point.getX();
        int y = point.getY();
        if(x >= rows) x = 0;
        if(y >= cols) y = 0;
        if(x < 0) x = rows - 1;
        if(y < 0) y = cols - 1;
        return new Point(x,y);
    }



    private int getRandomX(){
        Random randomX = new Random();
        int xa;

            xa = randomX.nextInt(rows);


        return xa;
    }
    private int getRandomY(){
        Random randomY = new Random();
        int ya;

            ya = randomY.nextInt(cols);

        return ya;
    }

    void paint(GraphicsContext gc)
    {




        //gc.setFill(Grid.COLOR);
        //gc.fillRect(0, 0, rows * SIZE, cols * SIZE);
        //etc...
    }

    //(food.getPoint().equals(snake.getHead())

    public void update(){
        if (food.equals(snake.getHead())) {
            snake.extend();
            food.setPoint(getRandomX(), getRandomY());
        } else {
            snake.move();
        }
    }

    public Snake getSnake(){
        return snake;
    }

    public Point getFood(){
        return food;
    }

    public double getWidth(){
        return rows * SIZE;
    }

    public double getHeight(){
        return cols * SIZE;
    }
}
