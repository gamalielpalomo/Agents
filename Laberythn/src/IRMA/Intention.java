/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IRMA;
import Environment.Coordinate;
import Environment.Scenario;
import Globals.Globals.CellStatus;
import java.util.ArrayList;

/**
 *
 * @author gamaa
 */
public class Intention {
    Coordinate goal;
    Coordinate actual;
    Scenario scenario;
    Coordinate [][]CoordGrid;
    Path path;
    boolean done = false;
    
    ArrayList mainList;
    Coordinate [][]weightedGrid;
    
    public Intention(Coordinate finalGoal, Coordinate actual, Scenario inputScenario)
    {
        this.goal = finalGoal;
        this.actual = actual;
        this.scenario = inputScenario;
    }
    
    void generateWeights()
    {
        CoordGrid = new Coordinate[scenario.getSize()][scenario.getSize()];
        for(int row = 0; row < scenario.getSize() ;  row++){
            for(int column=0; column<scenario.getSize() ; column++){
                CoordGrid[row][column] = new Coordinate(row,column,scenario.getCellStatus(row, column));
                CoordGrid[row][column].setWeight(-1);
            }
        }
        mainList = new ArrayList();
        CoordGrid[goal.getRow()][goal.getColumn()].setWeight(0);
        mainList.add(CoordGrid[goal.getRow()][goal.getColumn()]);
        algorithm();
        //System.out.println("[Intention]: Weighted List: ");
        //Globals.Printer.printCoordList(mainList);
        path = new Path(mainList, actual, goal);        
        path.buildPath();
        //System.out.println("[Intention]: Path: ");
        //Globals.Printer.printCoordList(path.getPath());
        /*algorithm();
        System.out.println("[Intention]: Actual weighted List: ");
        Globals.Printer.printCoordList(mainList);*/
    }
    public Path getPath(){return this.path;}
    void algorithm()
    {
        ArrayList copy = new ArrayList(mainList);
        if(!done){
            for(Object element: mainList){
                Coordinate tmpElement = (Coordinate)element;
                //System.out.format("[algorithm]: Neighbors of [%d][%d]\n",tmpElement.getRow(),tmpElement.getColumn());
                ArrayList eNeighbors = getNeighbors(tmpElement);
                int tmpWeight = tmpElement.getWeight();
                //Globals.Printer.printCoordList(eNeighbors);
                for(Object n: eNeighbors){ //Filtrar a los vecinos del elemento en an?lisis
                    Coordinate nCell = (Coordinate)n; 
                    int searchResult = contains(copy,nCell);
                    if(searchResult!=-1){//Buscar si ya se encuentra en la lista
                        //System.out.format("[Intention/Algorithm]: [%d][%d] is in the list\n",nCell.getRow(),nCell.getColumn());
                        Coordinate tmp = (Coordinate)copy.get(searchResult);
                        if(tmp.getWeight()>nCell.getWeight()){ //Comparar ambos pesos para ver si dejamos el que ya estaba
                            //System.out.format("[Intention/Algorithm]: Weights tmp->%d , nCell->%d\n",tmp.getWeight(),nCell.getWeight());
                            nCell.setWeight(tmpWeight+1);
                            copy.remove(copy.get(searchResult));
                            copy.add(nCell);
                        }
                    }
                    else{
                        nCell.setWeight(tmpWeight+1);
                        copy.add(nCell);
                    }
                        
                    if(nCell.getRow() == actual.getRow() && nCell.getColumn() == actual.getColumn()){
                        //System.out.println("[Intention]: Startcell reached");
                        done = true;
                    }
                        
                }
            }
            mainList = copy;
            algorithm();
        }
        
    }
    
    int contains(ArrayList list, Coordinate object){
        for(Object element: list ){
            Coordinate tmp = (Coordinate) element;
            if(object.getRow()==tmp.getRow() && object.getColumn()==tmp.getColumn())
                return list.indexOf(element);
        }
        return -1;
    }
    
    ArrayList getNeighbors(Coordinate central){
        
        ArrayList result = new ArrayList();
        
        int centralRow = central.getRow();
        int centralColumn = central.getColumn();
        //System.out.println("[getNeighbors]: centralX: "+centralX);
        //System.out.println("[getNeighbors]: centralY: "+centralY);
        //System.out.format("[getNeighbors]: Grid[%d][%d] = %s",centralX,centralY-1,scenario.getCellStatus(centralX,centralY-1));
        if(centralRow>0 && scenario.getCellStatus(centralRow-1,centralColumn)!=CellStatus.BLOCKED)
        {
            //System.out.println("[getNeighbors/option1]");
            //CoordGrid[centralRow-1][centralColumn].setWeight(central.getWeight()+1);
            result.add( CoordGrid[centralRow-1][centralColumn] );
        }    
        if(centralColumn<scenario.getSize()-1 && scenario.getCellStatus( centralRow, centralColumn+1 )!=CellStatus.BLOCKED)
        {
            //System.out.println("[getNeighbors/option2]");
            //CoordGrid[centralRow][centralColumn+1].setWeight(central.getWeight()+1);
            result.add( CoordGrid[centralRow][centralColumn+1] );
        }
        if(centralColumn>0 && scenario.getCellStatus( centralRow, centralColumn-1) != CellStatus.BLOCKED)
        {
            //System.out.println("[getNeighbors/option3]");
            //CoordGrid[centralRow][centralColumn-1].setWeight(central.getWeight()+1);
            result.add( CoordGrid[centralRow][centralColumn-1] );
        }
        if(centralRow<scenario.getSize()-1 && scenario.getCellStatus( centralRow+1, centralColumn)!=CellStatus.BLOCKED)
        {
            //System.out.println("[getNeighbors/option4]");
            //CoordGrid[centralRow][centralColumn+1].setWeight(central.getWeight()+1);
            result.add( CoordGrid[centralRow+1][centralColumn] );
        }
        return result;
    }
    
    
    
}

class Path
{
    ArrayList weightedList;
    ArrayList path;
    Coordinate start, goal;
    boolean done;
    
    public Path(ArrayList wList, Coordinate start, Coordinate goal)
    {
        this.weightedList = wList;
        this.path = new ArrayList();
        this.start = start;
        this.goal = goal;
        this.done = false;
    }
    public ArrayList getPath()
    {
        return this.path;
    }
    void buildPath()
    {
        path.add(start);
        algorithm();
        
    }
    void algorithm()
    {
        while(!done){
            Coordinate last = (Coordinate)path.get(path.size()-1);
            Coordinate next = getNextStep(last);
            //System.out.format("[Path]: NextStep->[%d][%d]\n",next.getRow(),next.getColumn());
            path.add(next);
            if(next.getColumn() == goal.getColumn() && next.getRow()==goal.getRow())
                done=true;
        }
    }
    Coordinate getNextStep(Coordinate cell)
    {
        ArrayList possible = new ArrayList();
        //System.out.println("[getNextStep]: weightedList.size()->"+weightedList.size());
        //Globals.Printer.printCoordList(weightedList);
        for(Object element:weightedList){
            Coordinate tmp = (Coordinate)element;
            if(tmp.getRow()==cell.getRow() && Math.abs(tmp.getColumn()-cell.getColumn())==1)
                possible.add(tmp);
            else if(tmp.getColumn()==cell.getColumn() && Math.abs(tmp.getRow()-cell.getRow())==1)
                possible.add(tmp);
        }
        //System.out.println("[getNextStep]: possible.size()->"+possible.size());
        Coordinate result = null;
        if(possible.size()>0){
            Coordinate min = (Coordinate)possible.get(0);
            for(Object element:possible){
                Coordinate tmp = (Coordinate)element;
                //System.out.format("[getNextStep]: possible->[%d][%d]\n",tmp.getRow(),tmp.getColumn());
                if(tmp.getWeight()<min.getWeight())
                    min = tmp;
            }
            result = min;
        }
        return result;
        
    }
    
}