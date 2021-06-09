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
        states.add(state);
        currentStateIndex++;
    }

    public static void undo() {
        keepThreshold();
        if (currentStateIndex != 0) {
            currentStateIndex--;
        }
        SharedData.panel.repaint();
    }

    public static void redo() {
        keepThreshold();
        if (currentStateIndex != states.size() - 1) {
            currentStateIndex++;
        }
        SharedData.panel.repaint();
    }

    public static State getCurrentState() {
        for (State state : states) {
            System.out.println(state.getShapes());
        }
        return states.get(currentStateIndex);
    }

    private static void keepThreshold() {
        if (states.size() == 30) {
            states.remove(0);
        }
    }

}
