/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Globals;

import GUI.Controls;

/**
 *
 * @author gamaa
 */
public class Globals {
    
    //Controls static GUI
    public static Controls controls = new Controls();
    //X-PLANE connection variables
    public static String    XPLANE_ADDR     =   "localhost";
    public static int       PORT            =   49000; 
    public static int	    RECEIVE_PORT    =	49005;
    public static int	    DREF_VARS	    =	32;
    public static int       DREF_LENGTH     =   509;
    
    //Local variables
    
    //Agent based simulation variables
    public static float fc	= -1000;	//Predefined forward clearance between leader and wingman in OGL coordinate points.
    public static float lc	= 0;		//Predefined lateral clearance between leader and wingman in OGL coordinate points.
    public static Float vc	= 1000f;        //Predefined vertical clearance between leader and wingman in OGL coordinate points.
    
}
