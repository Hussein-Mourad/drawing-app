/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.app;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author hussein
 */
public class MainFrameController {

    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Square> squares = new ArrayList<>();
    private float stroke = 1;
    private Color color = Color.BLACK;

    public MainFrameController() {
    }

//    MouseAdapter mouseAdapter = new MouseAdapter() {
    protected void onMousePress(MouseEvent evt, ShapesEnum shape) {
        switch (shape) {
            case RECTANGLE:
                Rectangle rectangle = new Rectangle(evt.getPoint(), evt.getPoint(), stroke, color);
                rectangles.add(rectangle);
            case SQUARE:
                Square square = new Square(evt.getPoint(), evt.getPoint(), stroke, color);
                squares.add(square);
        }
    }
//    }

    protected void onMouseDrag(MouseEvent evt, ShapesEnum shape) {
//        Shapes whichShape = Shapes.values()[shape];
        switch (shape) {
            case RECTANGLE:
                rectangles.get(rectangles.size() - 1).setBottomCornerPosition(evt.getPoint());
            case SQUARE:
                squares.get(squares.size() - 1).setBottomCornerPosition(evt.getPoint());
        }
    }

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(ArrayList<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public void setSquares(ArrayList<Square> squares) {
        this.squares = squares;
    }

    public float getStroke() {
        return stroke;
    }

    public void setStroke(float stroke) {
        this.stroke = stroke;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
