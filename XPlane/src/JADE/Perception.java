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
public class Perception
{
    
    static Float fce = 0f;	    //Forward clearance error between leader and wingman
    static Float lce = 0f;	    //Lateral clearance error between leader and wingman
    static Float vce = 0f;	    //Vertical clearance error between leader and wingman
    
    public static Float getForwardError(Float actual)
    {
	fce = Desire.fc - actual;
	return fce;
    }
    
    public static Float getLateralError(Float actual)
    {
	lce = Desire.lc - actual;
	return lce;
    }
    
    public static Float getVerticalError(Float actual)
    {
	vce = Desire.vc - actual;
	return vce;
    }
    
}
