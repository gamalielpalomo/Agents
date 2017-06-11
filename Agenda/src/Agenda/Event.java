/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.util.Calendar;
import java.io.Serializable;

/**
 *
 * @author gamaa_000
 */
public class Event implements Serializable
{

    Calendar start, finish;
    String description;
    String companion;
    
    public Event(){}
    
    public Event(String description)
    {
        this.description = description;
    }
    public Event( int hInitial, int dInitial, String description, String companion )
    {
        start = Calendar.getInstance();
        finish = Calendar.getInstance();
        start.set( Calendar.HOUR, hInitial );
        start.set( Calendar.DATE, dInitial );
        finish.set( Calendar.HOUR, hInitial+1 );
        finish.set( Calendar.DATE, dInitial );
        this.description = description;
        this.companion = companion;
    }
    public Event( int hInitial, int dInitial, String description )
    {
        start = Calendar.getInstance();
        finish = Calendar.getInstance();
        start.set( Calendar.HOUR_OF_DAY, hInitial );
        start.set( Calendar.DATE, dInitial );
        finish.set( Calendar.HOUR, hInitial+1 );
        finish.set( Calendar.DATE, dInitial );
        this.description = description;
        this.companion = "";
    }
    public String getDescription()
    {
        return this.description;
    }
    public Calendar getStartDate()
    {
        return start;
    }
    public Calendar getFinishDate()
    {
        return finish;
    }
}
