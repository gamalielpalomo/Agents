/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Environment.Coordinate;
import java.awt.*;
import java.applet.Applet;
/**
 *
 * @author gamaa
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Globals.Globals.CellStatus;
import Globals.Globals.*;
import javax.swing.SwingUtilities;

public class LabGUI extends JPanel {

    JFrame frame = new JFrame("Labyrinth");
    int gridSize;
    public LabGUI(int size) { // constructor
        this.gridSize = size;
        frame.setContentPane(this);
        setLayout(new GridLayout(this.gridSize, this.gridSize));
        addButtons(this.gridSize);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public void updateGrid(Environment.Scenario scenario, Coordinate actual, Coordinate start, Coordinate goal){
        CellStatus [][]grid = scenario.getGrid();
        for(int row=0;row<gridSize;row++){
            for(int column=0;column<gridSize;column++){
                int index = column+(row*gridSize);
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(55, 55));
                switch (grid[row][column]) {
                    case CLEAR:
                        button.setBackground(Color.WHITE);
                        break;
                    case BLOCKED:
                        button.setBackground(Color.BLACK);
                        break;
                    default:
                        button.setBackground(Color.GRAY);
                        break;
                }
                if(start.getRow()==row&&start.getColumn()==column)
                    button.setBackground(Color.GREEN);
                if(goal.getRow()==row&&goal.getColumn()==column)
                    button.setBackground(Color.RED);
                if(actual.getRow()==row&&actual.getColumn()==column)
                    button.setBackground(Color.BLUE);
                remove(index);
                add(button, index);
            }
        }
        SwingUtilities.updateComponentTreeUI(frame);
    }
    private void addButtons(int size) {
        JButton grid;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                grid = new JButton(); // creates new button
                grid.setPreferredSize(new Dimension(55, 55));
                
                add(grid); // adds button to grid
            }
        }
    }
}
