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
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Globals.Globals.*;
import IRMA.Intention;
import com.sun.java.accessibility.util.AWTEventMonitor;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LabGUI extends JPanel {
    
    JFrame frame = new JFrame("Labyrinth");
    int gridSize;
    ActionListener al;
    Coordinate localGoal;
    public LabGUI(int size, Coordinate goal) { // constructor
        localGoal = new Coordinate(0,0,CellStatus.CLEAR);
        localGoal.setRow(goal.getRow());
        localGoal.setColumn(goal.getColumn());
        this.gridSize = size;
        frame.setContentPane(this);
        setLayout(new GridLayout(this.gridSize, this.gridSize));
        addButtons(this.gridSize);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 700);
        frame.setVisible(true);
        al = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                GButton button = (GButton)e.getSource();
                
                if(Globals.Globals.GlobalMap[button.getRow()][button.getColumn()]==CellStatus.BLOCKED)
                    JOptionPane.showMessageDialog(frame, "New goal is a wall", "Goal change", 1);
                else
                {
                    
                    localGoal.setRow(button.getRow());
                    localGoal.setColumn(button.getColumn());
                    JOptionPane.showMessageDialog(frame, "New goal: ["+button.getRow()+"]["+button.getColumn()+"]", "Button pressed", 1);
                    
                }
                    
                /*JButton tmpButton = (JButton)e.getSource();
                Border border = new LineBorder(Color.BLUE, 2);
                tmpButton.setBorder(border);
                int index = tmpButton.get
                int row = index/gridSize;
                int column = index%gridSize;
                JOptionPane.showMessageDialog(frame, index+" Goal changed: ["+column+"]["+row+"]", "New Objective", 1);*/
                
            }        
        };
        addActionListener(al);
        
    }
    public Coordinate getGoal(){
        return this.localGoal;
    }
    public void updateGridRoute(Environment.Scenario scenario, ArrayList path){
        CellStatus [][]grid = scenario.getGrid();
        for(Object element:path){
            Coordinate coord = (Coordinate)element;
            int index = coord.getColumn()+(coord.getRow()*gridSize);
            /*JButton button = new JButton();
            button.setPreferredSize(new Dimension(55, 55));
            switch (grid[coord.getRow()][coord.getColumn()]) {
                case CLEAR:
                    button.setBackground(Color.WHITE);
                    break;
                case BLOCKED:
                    button.setBackground(Color.BLACK);
                    break;
                default:
                    button.setBackground(Color.GRAY);
                    break;
            }*/
            Border border = new LineBorder(Color.RED, 2);
            GButton tmp = (GButton)getComponent( index );
            tmp.setBorder( border );
        }
    }
    public void updateGrid(Environment.Scenario scenario, Coordinate actual, Coordinate start, Coordinate goal){
        CellStatus [][]grid = scenario.getGrid();
        for(int row=0;row<gridSize;row++){
            for(int column=0;column<gridSize;column++){
                int index = column+(row*gridSize);
                GButton button = new GButton();
                button.setGrid(row,column);
                button.addActionListener(al);
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
class GButton extends JButton{
    int row;
    int column;
    public void setGrid(int r, int c){
        row = r;
        column = c;
    }
    public int getRow(){return this.row;}
    public int getColumn(){return this.column;}
}
