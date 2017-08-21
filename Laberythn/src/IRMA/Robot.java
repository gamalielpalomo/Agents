/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IRMA;
import Environment.Coordinate;
import Globals.Globals.*;
import jade.core.Agent;
import jade.core.behaviours.*;
import IRMA.Action.MOVE;
import GUI.LabGUI;
/**
 *
 * @author gamaa
 */
public class Robot extends Agent{
    @Override
    protected void setup()
    {
        Globals.Globals.readMapFromFile();
        Coordinate goal = new Coordinate(4,2,CellStatus.CLEAR);
        Coordinate start = new Coordinate(0,0,CellStatus.CLEAR);
        Coordinate actual = start;
        Beliefs beliefs = new Beliefs(5, goal);
        Desire desire = new Desire( goal );
        LabGUI gui = new LabGUI(5);
        //Globals.Printer.printMatrix(Globals.Globals.GlobalMap,actual,goal);
        //beliefs.printBeliefMatrix();
        
        addBehaviour( new TickerBehaviour (this,2000){

            @Override
            protected void onTick() {
                beliefs.updateScenarioBelief(actual);
                gui.updateGrid(beliefs.getScenario(),actual,start,goal);
                beliefs.printBeliefMatrix();
                Intention intention = new Intention(goal, actual, beliefs.getScenario());
                intention.generateWeights();
                Action a = new Action(goal);
                System.out.println("[Robot]: Route: ");
                Globals.Printer.printCoordList(intention.getPath().getPath());
                MOVE action = a.getAction(intention.getPath());
                System.out.println("[Robot]: Action->"+action);
                switch(action){
                    case UP:
                        actual.setRow(actual.getRow()-1);break;
                    case RIGHT:
                        actual.setColumn(actual.getColumn()+1);break;
                    case DOWN:
                        actual.setRow(actual.getRow()+1);break;
                    case LEFT:
                        actual.setColumn(actual.getColumn()-1);break;
                        
                }
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
    }
}
