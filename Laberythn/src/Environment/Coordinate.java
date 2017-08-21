/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Environment;
import Globals.Globals.CellStatus;
/**
 *
 * @author gamaa
 */
public class Coordinate {
    
    int row;
    int column;
    int weight;
    CellStatus status;
    
    public Coordinate(int inputRow, int inputColumn, CellStatus inputStatus)
    {
        this.row = inputRow;
        this.column = inputColumn;
        this.status = inputStatus;
    }
    public int getRow(){return this.row;}
    public int getColumn(){return this.column;}
    public int getWeight(){return this.weight;}
    public CellStatus getStatus(){return this.status;}
    public void setWeight(int w){this.weight = w;}
    
}
