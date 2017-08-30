/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;
import DREF.DREF_Builders;
import Tools.ByteArrayTool;
import Tools.Messenger;
import java.util.ArrayList;
/**
 *
 * @author gamaa
 */
public class Intention
{
    Desire desires;
    Belief beliefs;
    FuzzyLogicAnalizer fuzzy;
    
    public Intention(){}
    public void createActionPlan(Desire desires, Belief beliefs)
    {
	this.desires = desires;
	this.beliefs = beliefs;
	System.out.println("[Intention]: Forward_error -> "+beliefs.fce);
	System.out.println("[Intention]: Lateral_error -> "+beliefs.lce);
	System.out.println("[Intention]: Vertical_error -> "+beliefs.vce);
	System.out.println("[Intention]: Velocidad_forward -> "+beliefs.perceptions.plane0_speed);
	System.out.println("[Intention]: Velocidad_lateral -> "+beliefs.perceptions.plane0_XSpeed);
	System.out.println("[Intention]: Velocidad_vertical -> "+beliefs.perceptions.plane0_YSpeed);
	this.fuzzy = new FuzzyLogicAnalizer();
	this.fuzzy.setValues("Forward_error", beliefs.fce, "Lateral_error", beliefs.lce, "Vertical_error", beliefs.vce, "Velocidad_forward",beliefs.perceptions.plane0_speed , "Velocidad_lateral", beliefs.perceptions.plane0_XSpeed, "Velocidad_vertical", beliefs.perceptions.plane0_YSpeed);
	//Fix vertical clearance error
	float elevators = fuzzy.getVerticalValue();
	float ailerons = fuzzy.getLateralValue();
	ArrayList forward = fuzzy.getForwardValues();
	float throttle = (float)forward.get(0);
	float flap = (float)forward.get(1);
	System.out.println("[Intention]: Elevators -> "+elevators); 
	System.out.println("[Intention]: Ailerons -> "+ailerons); 
	System.out.println("[Intention]: Throttle -> "+throttle); 
	System.out.println("[Intention]: Flaps -> "+flap); 
	//////////////////////////////////////////////////////////
	float sensor = elevators;
	Globals.Globals.controls.updateElevator(sensor);
        byte []values = ByteArrayTool.float2ByteArray(sensor);
        byte []XPData = ByteArrayTool.getXPData("pitch", values);
	Messenger.sendMessage(XPData);
	/////////////////////////////////////////////////////////
	sensor = ailerons;
	Globals.Globals.controls.updateAileron(sensor);
        XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/roll_ratio[0]", sensor);
        Messenger.sendMessage(XPData);
	/////////////////////////////////////////////////////////
	sensor = throttle;
	Globals.Globals.controls.updateThrottle(sensor);
        XPData = DREF_Builders.createDREF("sim/cockpit2/engine/actuators/throttle_ratio_all[0]", sensor);
        Messenger.sendMessage(XPData);
	/////////////////////////////////////////////////////////
	sensor = flap/5;
	Globals.Globals.controls.updateFlaps(sensor);
	XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/flap_handle_deploy_ratio[0]", sensor);
	Messenger.sendMessage(XPData);
	/////////////////////////////////////////////////////////
	/*if(beliefs.perceptions.plane0_rollAngle>=-2&&beliefs.perceptions.plane0_rollAngle<=2)
	    sensor = 0.0f;
	else if(beliefs.perceptions.plane0_rollAngle<-2)
	    sensor = 0.1f;
	else {
	    sensor = -0.1f;
	}*/
	
	if(beliefs.perceptions.plane0_rollAngle<-10)
	    sensor = 0.17f;
	else if(beliefs.perceptions.plane0_rollAngle>=-10&&beliefs.perceptions.plane0_rollAngle<-5)
	    sensor = 0.15f;
	else if(beliefs.perceptions.plane0_rollAngle>=-5&&beliefs.perceptions.plane0_rollAngle<-2)
	    sensor = 0.1f;
	else if(beliefs.perceptions.plane0_rollAngle>=-2&&beliefs.perceptions.plane0_rollAngle<2)
	    sensor = 0.0f;
	else if(beliefs.perceptions.plane0_rollAngle>=2&&beliefs.perceptions.plane0_rollAngle<5)
	    sensor = -0.1f;
	else if(beliefs.perceptions.plane0_rollAngle>=5&&beliefs.perceptions.plane0_rollAngle<10)
	    sensor = -0.15f;
	else {
	    sensor = -0.17f;
	}
	
	    
	    
	XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/heading_ratio[0]", sensor);
	Messenger.sendMessage(XPData);
	//System.out.println("[Intention]: Elevator -> "+fixingValueElevator);
	//Fix lateral clearance error
	
	
	
    }
}
