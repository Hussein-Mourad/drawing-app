/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Shapes.Shape;
import java.util.ArrayList;

/**
 *
 * @author hussein
 */
public class State {

    private ArrayList<Shape> shapes = new ArrayList<>();

    public State() {
    }

    public State(ArrayList<Shape> shapes) {
        this.shapes = new ArrayList<Shape>(shapes);
        StateManager.updateState(this);
    }

    public ArrayList<Shape> getShapes() {
        return this.shapes;
    }

    public void setState(ArrayList<Integer> state) {
        this.shapes = shapes;
    }
}
