package main.gameWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<Point> body; //List with coords of snake elements

    public Snake() {
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
}
