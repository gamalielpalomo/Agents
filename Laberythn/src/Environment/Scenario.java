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
public class Scenario {
    
    int size;
    CellStatus [][]grid;
    
    public Scenario(int inputSize)
    {
        
        this.size = inputSize;
        grid = new CellStatus[inputSize][inputSize];
        
        for(int row=0; row<inputSize; row++)
        {
            for(int column=0; column<inputSize; column++)
            {
                grid[row][column] = CellStatus.UNKNOWN;
            }
        }
        
    }
    
    public int getSize(){return this.size;}
    public CellStatus getCellStatus(int row, int column){return grid[row][column];}
    public void updateCell(Coordinate cell){grid[cell.getRow()][cell.getColumn()] = cell.getStatus();}
    void updateSize(int inputSize){this.size = inputSize;}
    public CellStatus[][] getGrid(){return this.grid;}
    
}
