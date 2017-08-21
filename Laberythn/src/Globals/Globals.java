/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 *
 * @author gamaa
 */
public class Globals {
    // Global configuration variables
    public static String InputFileName = "inputLab";
    
    //Internal variables
    public static enum CellStatus { BLOCKED, CLEAR, UNKNOWN }
    public static CellStatus [][] GlobalMap;
    
    //Functions
    public static void readMapFromFile()
    {
        
        try
        {
            System.out.println("[Globals]: Loading GlobalMap from file");
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(InputFileName)));
            int size = Integer.parseInt(scanner.nextLine());
            CellStatus [][]result = new CellStatus[size][size];
            for(int row=0; row<size ; row++)
            {
                for(int column=0; column<size; column++)
                {
                    switch(scanner.nextInt()){
                        case 0:
                            result[row][column] = CellStatus.BLOCKED;
                            break;
                        case 1:
                            result[row][column] = CellStatus.CLEAR;
                            break;
                        case 2: 
                            result[row][column] = CellStatus.UNKNOWN;
                    }
                    
                }
            }
            System.out.println("[Globals]: GlobalMap ready");
            GlobalMap = result;
        }
        catch(FileNotFoundException fnfe){GlobalMap = null;}        
    }
    
}


