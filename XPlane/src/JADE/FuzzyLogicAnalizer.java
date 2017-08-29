/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;

import java.util.ArrayList;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

/**
 *
 * @author Yolanda
 */
public class FuzzyLogicAnalizer {
    
    FIS fis;
    FunctionBlock functionBlock;
    
    public FuzzyLogicAnalizer(){
        String fileName = "src/JADE/Error_Analizer.fcl"; //fcl file path
        fis = FIS.load(fileName,true);
        
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        functionBlock = fis.getFunctionBlock(null);          
    }
    
    public void setValues(String Forward_error, float Forward_error_value, String Lateral_error, float Lateral_error_value, String Vertical_error, float Vertical_error_value, 
        String Velocidad_forward, float Velocidad_forward_value, String Velocidad_lateral, float Velocidad_lateral_value, String Velocidad_vertical, float Velocidad_vertical_value){
        functionBlock.setVariable(Forward_error, Forward_error_value);
        functionBlock.setVariable(Lateral_error, Lateral_error_value);
        functionBlock.setVariable(Vertical_error, Vertical_error_value);
        functionBlock.setVariable(Velocidad_forward, Velocidad_forward_value);
        functionBlock.setVariable(Velocidad_lateral, Velocidad_lateral_value);
        functionBlock.setVariable(Velocidad_vertical, Velocidad_vertical_value);
    }
    
    public ArrayList<Double> getForwardValues(){
        ArrayList<Double> values = new ArrayList<>();
        values.add(functionBlock.getVariable("Acelerador").getValue());
        values.add(functionBlock.getVariable("Freno").getValue());
        return values;
    }
    
    public Double getLateralValue(){
        return functionBlock.getVariable("Alerones").getValue();
    }
    
    public Double getVerticalValue(){
	System.out.println("[Intention]: Elevator -> "+functionBlock.getVariable("Elevadores").getValue());
        return functionBlock.getVariable("Elevadores").getValue();
    }
      
}
