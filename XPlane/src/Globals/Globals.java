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
    public static int	    DREF_VARS	    =	30;
    //Local variables
    public static int	    RECEIVE_PORT    =	49005;
    //Agent based simulation variables
    public static Float fc	= -100f;	//Predefined forward clearance between leader and wingman in meters.
    public static Float lc	= 100f;         //Predefined lateral clearance between leader and wingman in meters.
    public static Float vc	= 100f;         //Predefined vertical clearance between leader and wingman in meters.
    
}
