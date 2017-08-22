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
    Desire desire;
    Beliefs beliefs;
    @Override
    protected void setup()
    {
        Globals.Globals.readMapFromFile();
        Coordinate goal = new Coordinate(2,0,CellStatus.CLEAR);
        Coordinate start = new Coordinate(0,19,CellStatus.CLEAR);
        Coordinate actual = start;
        beliefs = new Beliefs(20, actual, goal);
        desire = new Desire( goal );
        LabGUI gui = new LabGUI(20,goal);
        
        //Globals.Printer.printMatrix(Globals.Globals.GlobalMap,actual,goal);
        //beliefs.printBeliefMatrix();
        
        addBehaviour( new TickerBehaviour (this,700){

            @Override
            protected void onTick() {
                goal.setRow(gui.getGoal().getRow());
                goal.setColumn(gui.getGoal().getColumn());
                desire.updateDesire(goal);
                beliefs.updateGoal(goal);
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
                gui.updateGridRoute( beliefs.getScenario(), intention.getPath().getPath());
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
