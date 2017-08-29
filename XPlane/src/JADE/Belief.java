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
	
	//System.out.println("[Beliefs]: Forward Clearance Error -> "+this.fce);
	System.out.println("[Beliefs]: Lateral Clearance Error -> "+this.lce);
	
    }
    
    double getForwardError()
    {
	double theta = perceptions.plane1_phi;
	if(theta>=0&&theta<1)
	    return perceptions.plane1_z-perceptions.plane0_z;
	Double result = 0d;
	Float deltaX = goalPossitionX-actualPossitionX;
	Float deltaZ = goalPossitionZ-actualPossitionZ;
	return result;
    }
    
    float getLateralError()
    {
	float theta = perceptions.plane1_psi;
	//if(theta>=0&&theta<1)
	//    return perceptions.plane1_x-perceptions.plane0_x;
	//System.out.println("[getLateralError]: theta->"+theta);
	float result = 0;
	
	Coordinate floating1 = new Coordinate(perceptions.plane0_x,perceptions.plane0_z);
	Coordinate floating2 = new Coordinate(desires.getDesiredX(),desires.getDesiredZ());
	Coordinate fixed = new Coordinate(perceptions.plane1_x,perceptions.plane1_z);
	
	Coordinate rot_desired = CoordinatesTools.rotateOverCircle(floating2, fixed, theta);
	Coordinate rot_actual = CoordinatesTools.rotateOverCircle(floating1, fixed, theta);
	float deltaX = rot_actual.getX()-rot_desired.getX();
	float deltaZ = rot_actual.getZ()-rot_desired.getZ();
	result = deltaX;
	/*
	float L[] = {perceptions.plane1_x,perceptions.plane1_z};
	float W[] = {perceptions.plane0_x,perceptions.plane0_z};
	float LNorm = (float)Math.sqrt(Math.pow(L[0],2)+Math.pow(L[1],2)); 
	float D[] = {L[0]/LNorm,L[1]/LNorm};
	float W1[] = {W[0]-L[0],W[1]-L[1]};
	float DNorm = (float)Math.sqrt(Math.pow(D[0],2)+Math.pow(D[1],2));
	float error1 = W1[0]*D[0]+W1[1]*D[1];
	result = error1;
	*/
	
        /*double rad_leaderTheta = Math.toRadians(theta);
	System.out.println("[getLateralError]: theta->"+rad_leaderTheta);
        double rad_leaderAlpha = (Math.PI/2)-rad_leaderTheta;
	System.out.println("[getLateralError]: alpha->"+rad_leaderAlpha);
	System.out.println("[getLateralError]: tg(alpha)->"+Math.tan(rad_leaderAlpha));
        result = -(Math.tan(rad_leaderAlpha)*actualPossitionX)+actualPossitionZ+(Math.tan(rad_leaderAlpha)*goalPossitionX)-goalPossitionZ;
        result = result/Math.sqrt(Math.pow(Math.tan(rad_leaderAlpha),2)+1);
	//Float deltaX = goalPossitionX-actualPossitionX;
	//Float deltaZ = goalPossitionZ-actualPossitionZ;
	//result = ((Double)Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaZ, 2)));*/
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
