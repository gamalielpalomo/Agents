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
	//this.fce = getForwardError();
	this.lce = (float)getLateralError();
	
	//System.out.println("[Beliefs]: Forward Clearance Error -> "+this.fce);
	System.out.println("[Beliefs]: Lateral Clearance Error -> "+this.lce);
	
    }
    
    public Double getForwardError()
    {
	Double result = 0d;
	Float deltaX = goalPossitionX-actualPossitionX;
	Float deltaZ = goalPossitionZ-actualPossitionZ;
	return result;
    }
    
    double getLateralError()
    {
	double result = 0d;
        double degrees = perceptions.plane1_psi;
        double rad_leaderTheta = Math.toRadians(degrees);
	System.out.println("[getLateralError]: theta->"+rad_leaderTheta);
        double rad_leaderAlpha = (Math.PI/2)-rad_leaderTheta;
	System.out.println("[getLateralError]: alpha->"+rad_leaderAlpha);
	System.out.println("[getLateralError]: tg(alpha)->"+Math.tan(rad_leaderAlpha));
        result = -(Math.tan(rad_leaderAlpha)*actualPossitionX)+actualPossitionZ+(Math.tan(rad_leaderAlpha)*goalPossitionX)-goalPossitionZ;
        result = result/Math.sqrt(Math.pow(Math.tan(rad_leaderAlpha),2)+1);
	//Float deltaX = goalPossitionX-actualPossitionX;
	//Float deltaZ = goalPossitionZ-actualPossitionZ;
	//result = ((Double)Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaZ, 2)));
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
