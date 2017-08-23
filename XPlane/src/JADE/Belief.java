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
    
    
    public Belief(){    }
    
    public void updateBeliefs(Perception perceptions, Desire desires)
    {
        this.perceptions = perceptions;
        this.desires = desires;
    }
    
    public Float getForwardError()
    {
	fce = desires.getDesiredX() - perceptions.local_x;
	return fce;
    }
    
    public Float getLateralError()
    {
	lce = desires.getDesiredY() - perceptions.local_y;
	return lce;
    }
    
    /*
    public Float getVerticalError(Float actual)
    {
	vce = Desire.desiredPosZ - actual;
	return vce;
    }
    */

}
