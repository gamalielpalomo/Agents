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
    
    Float desiredPosX;           //Desired X position in OGL coordinates.
    Float desiredPosY;           //Desired Y position in OGL coordinates.
    Float desiredPosZ;           //Desired Z position in OGL coordinates.
    Float desiredLC = Globals.lc;
    Float desiredFC = Globals.fc;
    Float desiredVC = Globals.vc;
    Perception actualPerception;
    
    public Desire(){}
    
    public void updateDesires(Perception perception)
    {
        this.actualPerception = perception;
        updateDesiredPossition(actualPerception.plane1_x, actualPerception.plane1_y, actualPerception.plane1_z, actualPerception.plane1_theta);
    }
    
    void updateDesiredPossition(Float leaderPosX, Float leaderPosY, Float leaderPosZ, Float leaderHeading)
    { 
        
        Double rad_leaderHeading = Math.toRadians(leaderHeading);
        Float hypotenuse = (float)Math.sqrt(Math.pow((double)Globals.fc, 2)+Math.pow((double)Globals.lc,2));
        
        desiredPosX = ((float)Math.cos(rad_leaderHeading))*hypotenuse;
        desiredPosX = desiredPosX + leaderPosX;
        desiredPosY = ((float)Math.sin(rad_leaderHeading))*hypotenuse;   
        desiredPosY = desiredPosY + leaderPosY;
        //desiredPosZ
        
        
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
    
}
