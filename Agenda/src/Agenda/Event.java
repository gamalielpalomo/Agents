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
    private static final long serialVersionUID = -6728290567613313860L;
    Calendar start, finish;
    String description;
    String companion;
    
    public Event(){}
    
    public Event(String description)
    {
        this.description = description;
    }
    public Event( int hInitial, int hFinal, int dInitial, int dFinal,  String description, String companion )
    {
        start = Calendar.getInstance();
        finish = Calendar.getInstance();
        start.set( Calendar.HOUR_OF_DAY, hInitial );
        start.set( Calendar.MINUTE, 0 );
        start.set( Calendar.SECOND, 0 );
        start.set( Calendar.MILLISECOND, 0 );
        start.set( Calendar.DATE, dInitial );
        finish.set( Calendar.HOUR_OF_DAY, hFinal );
        finish.set( Calendar.MINUTE, 0 );
        finish.set( Calendar.SECOND, 0 );
        finish.set( Calendar.MILLISECOND, 0 );
        finish.set( Calendar.DATE, dFinal );
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
