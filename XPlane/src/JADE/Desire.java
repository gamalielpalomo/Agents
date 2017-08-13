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
public class Desire
{
    
    static Float fc	= -100f;	//Predefined forward clearance between leader and wingman in meters.
    static Float lc	= 100f;         //Predefined lateral clearance between leader and wingman in meters.
    static Float vc	= 100f;         //Predefined vertical clearance between leader and wingman in meters.
    static Float desiredPosX;           //Desired X position in OGL coordinates.
    static Float desiredPosY;           //Desired Y position in OGL coordinates.
    static Float desiredPosZ;           //Desired Z position in OGL coordinates.
    
    public static void updateDP(Float leaderPosX, Float leaderPosY, Float leaderHeading)
    { 
        
        Double rad_leaderHeading = Math.toRadians(leaderHeading);
        Float hypotenuse = (float)Math.sqrt(Math.pow((double)fc, 2)+Math.pow((double)lc,2));
        
        desiredPosX = ((float)Math.cos(rad_leaderHeading))*hypotenuse;
        desiredPosX = desiredPosX + leaderPosX;
        desiredPosY = ((float)Math.sin(rad_leaderHeading))*hypotenuse;   
        desiredPosY = desiredPosY + leaderPosY;
        
        /*
        System.out.println("Hypotenuse: "+hypotenuse);
        System.out.println("SIN(theta): "+Math.sin(rad_leaderHeading));
        System.out.println("COS(theta): "+Math.cos(rad_leaderHeading));
        System.out.println("Desired X: "+desiredPosX);
        System.out.println("Desired Y: "+desiredPosY);
        */
        
    }
}
