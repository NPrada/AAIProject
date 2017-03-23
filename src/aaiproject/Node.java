/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aaiproject;

/**
 *
 * @author Nico
 */
public class Node {
    //private double id;

    public double weight;
    public double delta;
    public double Ui;
    public double updatedweight;

    public Node(double startWeigt, double startUi) {
        weight = startWeigt;
        Ui = startUi;
    }

    public void setWeight(double newValue) {
        weight = newValue;
    }

    public void setDelta(double newValue) {
        delta = newValue;
    }

    public void setUi(double newValue) {
        Ui = newValue;
    }

    public void setNewWeight(double newWeight) {
        weight = newWeight;
    }
}
