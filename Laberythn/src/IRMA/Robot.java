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
import jade.lang.acl.ACLMessage;
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
        Beliefs beliefs = new Beliefs(5, goal);
        Desire desire = new Desire( goal );
        Globals.Printer.printMatrix(Globals.Globals.GlobalMap,start,goal);
        beliefs.printBeliefMatrix();
        
        addBehaviour( new CyclicBehaviour (this){
            @Override
            public void action()
            {
                ACLMessage inputMsg = receive();
                if( inputMsg!= null && inputMsg.getPerformative() == ACLMessage.REQUEST){
                    beliefs.updateScenarioBelief();
                    beliefs.printBeliefMatrix();
                    Intention intention = new Intention(goal, start, beliefs.getScenario());
                    intention.generateWeights();
                }
            }
        });
        
    }
}
