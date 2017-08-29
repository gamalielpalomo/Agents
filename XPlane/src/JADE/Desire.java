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
import Globals.Globals;

public class Desire
{
    
    float desiredPosX;           //Desired X position in OGL coordinates.
    float desiredPosY;           //Desired Y position in OGL coordinates.
    float desiredPosZ;           //Desired Z position in OGL coordinates.
    float desiredLC = Globals.lc;
    float desiredFC = Globals.fc;
    float desiredVC = Globals.vc;
    Perception actualPerception;
    
    public Desire(){}
    
    public void updateDesires(Perception perception)
    {
        this.actualPerception = perception;
        updateDesiredPossition(actualPerception.plane1_x, actualPerception.plane1_y, actualPerception.plane1_z, actualPerception.plane1_psi);
    }
    
    void updateDesiredPossition(Float leaderPosX, Float leaderPosY, Float leaderPosZ, Float leaderHeading)
    { 
        
        Double rad_leaderHeading = Math.toRadians(leaderHeading);
	float fc = Globals.fc;
	float lc = Globals.lc;
	//System.out.println("FC->"+fc);
	//System.out.println("LC->"+lc);
	float deg_leaderHeading = leaderHeading;
	float fc2 = (float)Math.pow(fc, 2);
	//System.out.println("FC2->"+fc2);
        float hyp = (float)Math.sqrt(Math.pow(fc, 2)+Math.pow(lc,2));
	//System.out.println("hyp->"+hyp);
	float hypotenuse = (float)Math.sqrt(Math.pow(fc, 2)+Math.pow(lc,2));
	//float alpha=(float)Math.toDegrees(Math.asin(0.7071));
	float normalized = Globals.fc/hypotenuse;
	//System.out.println("HYPOTENUSE->"+hypotenuse);
	//System.out.println("NORMALIZED->"+normalized);
	float alpha;
	if(Globals.lc>=0){
	    if(Globals.fc<0)
		alpha = 90-(float)Math.toDegrees(Math.asin(normalized));
	    else{
		//float theta = (float) Math.toDegrees(Math.asin(normalized));
		//System.out.println("THETA->"+theta);
	    	alpha = (float)Math.toDegrees(Math.abs(Math.asin(normalized)))+90;
	    }	
	}
	else{
	    if(Globals.fc<0)
		alpha = (float)Math.toDegrees(Math.asin(normalized))+270;
	    else
		alpha = (float)Math.toDegrees(Math.abs(Math.asin(normalized)))+180;
	}
        //System.out.println("ALPHA->"+alpha);
        //desiredPosX = ((float)Math.cos(rad_leaderHeading))*hypotenuse;
	desiredPosX = ((float)Math.sin(Math.toRadians(deg_leaderHeading+alpha)))*hypotenuse;
        desiredPosX = desiredPosX + leaderPosX;
	desiredPosY = leaderPosY; 
        //desiredPosZ = ((float)Math.sin(rad_leaderHeading))*hypotenuse;   
	//Multiplicado por -1 ya que las coordenadas en Z decrementan hacia arriba e incrementan hacia abajo
	desiredPosZ = ((float)Math.cos(Math.toRadians(deg_leaderHeading+alpha)))*hypotenuse*-1;
        desiredPosZ = desiredPosZ + leaderPosZ;
        //desiredPosZ
        System.out.println("[Desire]: Desired possition in X -> "+desiredPosX);
	System.out.println("[Desire]: Desired possition in Y -> "+desiredPosY);
	System.out.println("[Desire]: Desired possition in Z -> "+desiredPosZ);
        
        /*
        System.out.println("Hypotenuse: "+hypotenuse);
        System.out.println("SIN(theta): "+Math.sin(rad_leaderHeading));
        System.out.println("COS(theta): "+Math.cos(rad_leaderHeading));
        System.out.println("Desired X: "+desiredPosX);
        System.out.println("Desired Y: "+desiredPosY);
        */   
    }
    
    public Float getDesiredX(){return this.desiredPosX;}
    public Float getDesiredY(){return this.desiredPosY;}
    public Float getDesiredZ(){return this.desiredPosZ;}
    
}
