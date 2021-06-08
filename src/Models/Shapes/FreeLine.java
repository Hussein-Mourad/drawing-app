/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.Shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author hussein
 */
public class FreeLine extends Shape {

    private ArrayList<Point> path = new ArrayList<>();

    public FreeLine(Point topCornerPosition, Point bottomCornerPosition) {
        super(topCornerPosition, bottomCornerPosition);
    }

    public FreeLine(Point topCornerPosition, Point bottomCornerPosition, float stroke) {
        super(topCornerPosition, bottomCornerPosition, stroke);
    }

    public FreeLine(Point topCornerPosition, Point bottomCornerPosition, float stroke, Color color) {
        super(topCornerPosition, bottomCornerPosition, stroke, color);
    }

    public FreeLine(FreeLine copy, Point mousePosition) { // copy constructor
        super(copy, mousePosition);
        this.path = copy.path;
    }

    @Override
    public void draw(Graphics2D g2D) {
        Point from = null;
        for (Point to : path) {
            if (from != null) {
                g2D.drawLine(from.x, from.y, to.x, to.y);
            }
            from = to;
        }

    }

    public ArrayList<Point> getPath() {
        return path;
    }

    public void setPath(ArrayList<Point> path) {
        this.path = path;
    }

    public void addPoint(Point point) {
        this.path.add(point);
    }

}
