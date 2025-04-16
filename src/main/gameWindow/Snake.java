package main.gameWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Point> body; //List with coords of snake elements
    private Direction direction; // move direction

    public Snake() {
        direction = Direction.D; //set default move to DOWN
        body = new ArrayList<>();

        //snake start elements (length)
        body.add(new Point(2, 5)); //snake head
        body.add(new Point(2, 4)); //snake 2nd element
        body.add(new Point(2, 3)); //snake 3rd element
    }

    public void draw (Graphics g) {
        g.setColor(Color.BLUE);
        for (Point point : getTail()) {
            g.fillRect(point.x*Board.SIZE, point.y*Board.SIZE, Board.SIZE, Board.SIZE);
        }

        g.setColor(new Color(54, 56, 200));
        g.fillOval(getHead().x*Board.SIZE, getHead().y*Board.SIZE, Board.SIZE, Board.SIZE);
    }

    private Point getHead() {
        return body.get(0);
    }

    private List<Point> getTail() {
        return body.subList(1, body.size());
    }

    public void move() {
        for (int i = body.size()-1; i > 0 ; i--) {
            body.get(i).setLocation(body.get(i-1)); // moving object form last to first (without head)
        }

        switch (direction) {
            case D -> getHead().y++;
            case U -> getHead().y--;
            case L -> getHead().x--;
            case R -> getHead().x++;
        }

    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isCollision() {
        Point head = getHead();

        //Head Collision with Tail - Game Over
        for (Point point : getTail()){
            if (head.equals(point)) {
                return true;
            }
        }

        //Head Collision with Bound - Game Over
        if (head.x < 0 || head.x >= Board.FIELD_X
        || head.y < 0 || head.y >= Board.FIELD_Y) {
            return true;
        }

        return false;
    }
}
