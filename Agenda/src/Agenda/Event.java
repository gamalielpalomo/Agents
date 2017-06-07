/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import java.util.Calendar;

/**
 *
 * @author gamaa_000
 */
public class Event
{

    Calendar start, finish;
    String description;
    String[] companion;
    
    public Event(){}
    public Event( int hInitial, int hFinal )
    {
        start.set( Calendar.HOUR, hInitial );
        finish.set( Calendar.HOUR, hFinal );
        description = "Single event";
        companion = new String[0];
    }

    public Event( int hInitial )
    {
        start.set( Calendar.HOUR, hInitial );
        finish.set( Calendar.HOUR, hInitial + 1 );
        description = "Single event";
        companion = new String[0];
    }

    public Event( int hInitial, String[] companion )
    {
        start.set( Calendar.HOUR, hInitial );
        finish.set( Calendar.HOUR, hInitial + 1 );
        description = "Single event";
        this.companion = companion;
    }
    
    /*
    public Event( int hInitial, int hFinal, String description )
    {
        start.set( Calendar.HOUR, hInitial );
        finish.set( Calendar.HOUR, hFinal );
        this.description = description;
        companion = new String[0];
    }
    */
    
    public Event( int hInitial, int hFinal, String description, String[] companion )
    {
        start.set( Calendar.HOUR, hInitial );
        finish.set( Calendar.HOUR, hFinal );
        this.description = description;
        this.companion = companion;
    }

    public Event( int hInitial, int hFinal, int dInitial, int dFinal, String description, String[] companion )
    {
        start.set( Calendar.HOUR, hInitial );
        start.set( Calendar.DATE, dInitial );
        finish.set( Calendar.HOUR, hFinal );
        finish.set( Calendar.DATE, dFinal );
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
        this.companion = new String[0];
    }
}
