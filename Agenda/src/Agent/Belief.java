/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import java.util.ArrayList;

/**
 *
 * @author gamaa
 */
public class Belief {
    
    ArrayList schedulingPreferences;
    public void Belief()
    {
        schedulingPreferences = new ArrayList<>();
        schedulingPreferences.add("MEDICAL");
        schedulingPreferences.add("WORK");      
        schedulingPreferences.add("PERSONAL");
    }
    
}
