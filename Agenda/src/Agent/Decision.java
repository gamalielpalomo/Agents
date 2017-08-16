/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;
import Agenda.Event;
import java.util.ArrayList;

/**
 *
 * @author gamaa_000
 */
public class Decision
{
    public static Event decideEvent(Event event1, Event event2)
    {
        //Aqu? decide cual evento es prioritario
        ArrayList preferences = Belief.schedulingPreferences;
        if(preferences.indexOf( event1.getDescription() ) < preferences.indexOf( event2.getDescription() ))
            return event1;
        else return event2;
    }
}
