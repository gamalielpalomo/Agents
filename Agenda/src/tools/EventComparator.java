/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Agenda.Event;
import java.util.Iterator;
import Agenda.Agenda;
/**
 *
 * @author gamaa
 */
public class EventComparator {
    public static boolean checkSplice(Event newEvent)
    {
        SerializableArrayList localRegistry = Agenda.registry;
        boolean result = false;
        for (Iterator it = localRegistry.iterator(); it.hasNext();)
        {
            Object element = it.next();
            Event event = (Event) element;            
            System.out.println("[EventComparator]: Comparing with "+event.getDescription());
            int compResult = event.getStartDate().compareTo(newEvent.getStartDate());
            System.out.println("[EventComparator]: Resulting "+compResult);
            if( compResult == 0 ) //Inician en la misma fecha
            {
                result = true;
            }
            
        }
        return result;
    }
}
