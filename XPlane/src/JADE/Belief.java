/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;

/**
 *
 * @author gamaa
 */
public class Belief {
    
    Perception perceptions;
    Desire desires;
    Float fce = 0f;	    //Forward clearance error between leader and wingman
    Float lce = 0f;	    //Lateral clearance error between leader and wingman
    Float vce = 0f;	    //Vertical clearance error between leader and wingman
    
    Float goalPossitionX;
    Float goalPossitionZ;
    Float actualPossitionX;
    Float actualPossitionZ;
    
    public Belief(){    }
    
    public void updateBeliefs(Perception perceptions, Desire desires)
    {
        this.perceptions = perceptions;
        this.desires = desires;
	this.goalPossitionX = desires.desiredPosX;
	this.goalPossitionZ = desires.desiredPosZ;
	this.actualPossitionX = perceptions.plane0_x;
	this.actualPossitionZ = perceptions.plane0_z;
	this.fce = getForwardError();
	this.lce = getLateralError();
	
	//System.out.println("[Beliefs]: Forward Clearance Error -> "+this.fce);
	//System.out.println("[Beliefs]: Lateral Clearance Error -> "+this.lce);
	
    }
    
    public Double getForwardError()
    {
	Double result = 0d;
	Float deltaX = goalPossitionX-actualPossitionX;
	Float deltaZ = goalPossitionZ-actualPossitionZ;
	return result;
    }
    
    Double getLateralError()
    {
	Double result = 0d;
	Float deltaX = goalPossitionX-actualPossitionX;
	Float deltaZ = goalPossitionZ-actualPossitionZ;
	
	result = ((Double)Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaZ, 2)));
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
