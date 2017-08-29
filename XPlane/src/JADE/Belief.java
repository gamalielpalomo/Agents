/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;

import Tools.Coordinate;
import Tools.CoordinatesTools;

/**
 *
 * @author gamaa
 */
public class Belief {
    
    Perception perceptions;
    Desire desires;
    float fce = 0;	    //Forward clearance error between leader and wingman
    float lce = 0;	    //Lateral clearance error between leader and wingman
    float vce = 0;	    //Vertical clearance error between leader and wingman
    
    float goalPossitionX;
    float goalPossitionZ;
    float actualPossitionX;
    float actualPossitionZ;
    
    public Belief(){    }
    
    public void updateBeliefs(Perception perceptions, Desire desires)
    {
        this.perceptions = perceptions;
        this.desires = desires;
	this.goalPossitionX = desires.desiredPosX;
	this.goalPossitionZ = desires.desiredPosZ;
	this.actualPossitionX = perceptions.plane0_x;
	this.actualPossitionZ = perceptions.plane0_z;
	
	this.fce = (float)getForwardError();
	this.lce = (float)getLateralError();
	
	System.out.println("[Beliefs]: Forward Clearance Error -> "+this.fce);
	System.out.println("[Beliefs]: Lateral Clearance Error -> "+this.lce);
	
    }
    
    double getForwardError()
    {
	float theta = perceptions.plane1_psi;
	float result = 0;
	
	Coordinate floating1 = new Coordinate(perceptions.plane0_x,perceptions.plane0_z);
	Coordinate fixed = new Coordinate(perceptions.plane1_x,perceptions.plane1_z);
	Coordinate rot_actual = CoordinatesTools.rotateOverCircle(floating1, fixed, theta);
	float deltaZ = rot_actual.getZ()-Globals.Globals.fc;
	result = deltaZ;
	return result;
    }
    
    float getLateralError()
    {
	float theta = perceptions.plane1_psi;
	float result = 0;
	
	Coordinate floating1 = new Coordinate(perceptions.plane0_x,perceptions.plane0_z);
	Coordinate fixed = new Coordinate(perceptions.plane1_x,perceptions.plane1_z);
	Coordinate rot_actual = CoordinatesTools.rotateOverCircle(floating1, fixed, theta);
	float deltaX = rot_actual.getX()-Globals.Globals.lc;
	float deltaZ = rot_actual.getZ()-Globals.Globals.fc;
	result = deltaX;
	return result;
    }
    
    /*
    public Float getVerticalError(Float actual)
    {
	vce = Desire.desiredPosZ - actual;
	return vce;
    }
    */

}
