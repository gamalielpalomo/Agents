/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IRMA;
import Environment.*;
import Globals.Globals.CellStatus;
import java.util.ArrayList;
/**
 *
 * @author gamaa
 */
public class Beliefs {
    
    Scenario scenario;
    Coordinate actualPos;
    Coordinate goal;
    Perception perception;
    Desire desires;
    
    public Beliefs(int size, Coordinate actual, Coordinate goal)
    {
        actualPos = actual;
        scenario = new Scenario(size);
        scenario.updateCell(actualPos);
        perception = new Perception();
        this.goal = goal;
        desires = new Desire(goal);
    }
    
    void updateScenarioBelief(Coordinate actual)
    {
        ArrayList newDiscoveries = perception.discoverNeighborhood(actual, scenario.getSize());
        for(Object element: newDiscoveries)
        {
            Coordinate cell = (Coordinate)element;
            //System.out.format("Updating cell [%d][%d] = %s\n",cell.getColumn(),cell.getRow(),cell.getStatus());
            scenario.updateCell(cell);
        }
    }
    
    void printBeliefMatrix(){
        Globals.Printer.printMatrix(scenario.getGrid(),actualPos,goal);
    }
    public void updateGoal(Coordinate goal){this.goal = goal;}
    public Scenario getScenario(){return this.scenario;}
    
}

class Perception
{
    public Perception(){}
    
    ArrayList discoverNeighborhood(Coordinate central, int scenarioSize)
    {
        ArrayList discovery = new ArrayList();
        int ColInitial = central.getColumn()-1;
        int RowInitial = central.getRow()-1;
        
        for(int row = RowInitial ; row<=RowInitial+2; row++)
        {
            if( row>-1 && row<scenarioSize ) //Revisar l?mites de escenario
            {
                for(int column = ColInitial; column<=ColInitial+2; column++)
                {
                    if(column>-1 && column<scenarioSize)
                    {
                        //NOTA: Recordar que x,y en la clase Coordinate est?n en ese orden,
                        //mientras que en una matriz es y,x
                        //System.out.format("Neighbor cell [%d][%d] = %s\n",y,x,Globals.Globals.GlobalMap[y][x]);
                        Coordinate tmp = new Coordinate(row,column,Globals.Globals.GlobalMap[row][column]);
                        discovery.add(tmp);
                    }
                }
            }
        }
        
        return discovery;        
    }
}