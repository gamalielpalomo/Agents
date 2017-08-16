/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Agenda.Event;
import java.util.Iterator;
import Agenda.Agenda;
import static Agenda.Agenda.registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author gamaa
 */ 
public class EventArray {
    public static Event checkSplice(Event newEvent)
    {
        SerializableArrayList localRegistry = registry;
        Event result = null;
        for (Iterator it = localRegistry.iterator(); it.hasNext();)
        {
            Object element = it.next();
            Event event = (Event) element;
            int compResult = event.getStartDate().compareTo(newEvent.getStartDate());
            if( compResult == 0 ) 
            {
                //Inician en la misma fecha, hay empalme
                return event;
            }
            else if ( compResult < 0 ) 
            {
                //event comienza antes que newEvent
                int finishDateComp = event.getFinishDate().compareTo(newEvent.getStartDate());
                if(finishDateComp > 0)
                {
                    //event termina despues que newEvent comience, hay empalme
                    return event;
                }
            } 
            else
            {
                //event comienza despues que newEvent
                int finishDateComp = event.getStartDate().compareTo(newEvent.getFinishDate());
                if(finishDateComp < 0)
                    //event comienza antes de que newEvent termine, hay empalme
                    return event;
            }
            
        }
        return result;
    }
    public static ArrayList checkSplices(Event newEvent)
    {
        SerializableArrayList localRegistry = registry;
        ArrayList result = new ArrayList<Event>();
        for (Iterator it = localRegistry.iterator(); it.hasNext();)
        {
            Object element = it.next();
            Event event = (Event) element;
            int compResult = event.getStartDate().compareTo(newEvent.getStartDate());
            if( compResult == 0 ) 
            {
                //Inician en la misma fecha, hay empalme
                result.add( event );
            }
            else if ( compResult < 0 ) 
            {
                //event comienza antes que newEvent
                int finishDateComp = event.getFinishDate().compareTo(newEvent.getStartDate());
                if(finishDateComp > 0)
                {
                    //event termina despues que newEvent comience, hay empalme
                    result.add( event );
                }
            } 
            else
            {
                //event comienza despues que newEvent
                int finishDateComp = event.getStartDate().compareTo(newEvent.getFinishDate());
                if(finishDateComp < 0)
                    //event comienza antes de que newEvent termine, hay empalme
                    result.add( event );
            }
            
        }
        return result;
    }
    public static void sortEvents()
    {
        Comparator comparator = (Comparator<Event>) (Event event1, Event event2) -> event1.getStartDate().compareTo(event2.getStartDate());
        Collections.sort(registry,comparator);
    }
    
}
