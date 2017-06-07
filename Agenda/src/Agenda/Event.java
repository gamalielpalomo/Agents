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
    public Event(int hInitial, int hFinal)
    {
        start = Calendar.getInstance();
        start.set( Calendar.HOUR, hInitial);
        finish.set( Calendar.HOUR, hFinal);
    }
}
