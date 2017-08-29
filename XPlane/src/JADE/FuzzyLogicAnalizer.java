/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;

import java.text.DecimalFormat;
import java.util.ArrayList;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author Yolanda
 */
public class FuzzyLogicAnalizer {
    
    FIS fis;
    FunctionBlock functionBlock;
    
    public FuzzyLogicAnalizer(){
        String fileName = "C:/Users/Adrian Gonzalez/Desktop/Distribuidos II - Simulator/Agents/XPlane/src/JADE/Error_Analizer.fcl"; //fcl file path
        //String fileName = "C:/Users/Yolanda/Documents/3er Cuatrimestre/Sistemas Distribuidos II/Proyecto FINAL/Agents/XPlane/src/JADE/Error_Analizer.fcl";
        
        fis = FIS.load(fileName,true);
        
        if( fis == null ) { 
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        functionBlock = fis.getFunctionBlock(null);       
    }
    
    public void setValues(String Forward_error, float Forward_error_value, String Lateral_error, float Lateral_error_value, String Vertical_error, float Vertical_error_value, 
        String Velocidad_forward, float Velocidad_forward_value, String Velocidad_lateral, float Velocidad_lateral_value, String Velocidad_vertical, float Velocidad_vertical_value){
        functionBlock.setVariable(Forward_error, (double)Forward_error_value);
        functionBlock.setVariable(Lateral_error, (double)Lateral_error_value);
        functionBlock.setVariable(Vertical_error, (double)Vertical_error_value);
        functionBlock.setVariable(Velocidad_forward, (double)Velocidad_forward_value);
        functionBlock.setVariable(Velocidad_lateral, (double)Velocidad_lateral_value);
        functionBlock.setVariable(Velocidad_vertical, (double)Velocidad_vertical_value);
        functionBlock.evaluate();
    }
    
    public ArrayList<Float> getForwardValues(){
        ArrayList<Float> values = new ArrayList<>();        
        values.add(Float.parseFloat(new DecimalFormat("#.##").format(functionBlock.getVariable("Acelerador").getValue())));
        values.add(Float.parseFloat(new DecimalFormat("#.##").format(functionBlock.getVariable("Freno").getValue())));
        return values;
    }
    
    public float getLateralValue(){        
        System.out.println("[Intention]: Ailerons -> "+functionBlock.getVariable("Alerones").getValue()); 
        return Float.parseFloat(new DecimalFormat("#.##").format(functionBlock.getVariable("Alerones").getValue()));
    }
    

    public float getVerticalValue(){
	System.out.println("[Intention]: Elevator -> "+functionBlock.getVariable("Elevadores").getValue());        
        return Float.parseFloat(new DecimalFormat("#.##").format(functionBlock.getVariable("Elevadores").getValue()));

    }
      
}
