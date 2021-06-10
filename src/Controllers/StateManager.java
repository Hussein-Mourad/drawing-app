/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.ArrayList;

/**
 *
 * @author hussein
 */
public class StateManager {

    private static ArrayList<State> states = new ArrayList<State>() {
        {
            add(new State());
        }
    };

    private static int currentStateIndex = 0;
    private static int threshold = 30;

    public static void updateState(State state) {
        states.add(currentStateIndex + 1, state);
        currentStateIndex++;
    }

    public static void undo() {
        if (currentStateIndex > 0) {
            currentStateIndex--;
        }

        handleThreshold();
        SharedData.shapes = new ArrayList(getCurrentState().getShapes());
        SharedData.panel.repaint();
    }

    public static void redo() {
        if (currentStateIndex < states.size()) {
            currentStateIndex++;
        }
        handleThreshold();
        SharedData.shapes = new ArrayList(getCurrentState().getShapes());
        SharedData.panel.repaint();
    }

    public static State getCurrentState() {
        return states.get(currentStateIndex);
    }

    private static void handleThreshold() {
        if (states.size() == threshold) {
            states.remove(0);
            currentStateIndex--;
        }
    }

}
