/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

import java.util.ArrayList;
import Globals.Globals.CellStatus;
import Environment.Coordinate;
/**
 *
 * @author gamaa
 */
public class Printer {
    public static void printMatrix(CellStatus [][]matrix, Coordinate start, Coordinate goal){
        System.out.println("");
        for(int row =0 ;row<matrix.length;row++){
            for(int column=0; column<matrix.length;column++){
                if( row==start.getRow() && column==start.getColumn())
                    System.out.print("\tSTART");
                else if( row==goal.getRow() && column==goal.getColumn())
                    System.out.print("\tGOAL");
                else
                    System.out.print("\t"+matrix[row][column]);
            }
            System.out.println("\n");
        }
    }
    public static void printCoordList(ArrayList list){
        for(Object element:list){
            Coordinate tmp = (Coordinate)element;
            System.out.format("[%d][%d] -> %d\n", tmp.getRow(),tmp.getColumn(),tmp.getWeight());
        }
    }
}
