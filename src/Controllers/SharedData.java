/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Shapes.FreeLine;
import Models.Shapes.Shape;
import Views.DrawingPanel;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author hussein
 */
class SharedData {

    static ArrayList<Shape> shapes = new ArrayList<>();
    static ArrayList<Shape> clearedShape = new ArrayList<>();
    static float stroke = 1;
    static Color color = Color.BLACK;
    static boolean fill = false;
    static DrawingPanel panel;
    static FreeLine tmpLine;
    static Shape tmpShape;
    static boolean dragMode = false;
    static Shape currentMovingShape;
    static Point currentMovingShapePrevPt;
}
