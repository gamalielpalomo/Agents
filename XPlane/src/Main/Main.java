/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import JADE.Desire;

/**
 *
 * @author gamaa
 */
public class Main
{
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {Globals.Globals.controls.setVisible(true);});
        Desire.updateDesiredPossition(0f,0f,0f);
    }
}
