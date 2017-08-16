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
public class Instruction
{

    public static enum Command
    {
        CREATE, SCHEDULE, REMOVE, CHANGE, FREE, SHOW, NOTHING, TELL
    }
    Event event, event2;
    ArrayList events;
    Command command;
    String name;

    public Instruction(Command command)
    {
        //Instrucci?n para comandos sin par?metros
        this.command = command;
        this.event  = null;
        this.event2 = null; 
    }
    public Instruction(Command command, String name)
    {
        this.command = command;
        this.name = name;
    }
    public Instruction( Command command, Event event )
    {
        //Instrucci?n para comandos con un par?metro
        this.command = command;
        this.event  = event;
        this.event2 = null;
    }
    public Instruction( Command command, Event event1, Event event2)
    {
        //Instrucci?n utilizada para realizar event swap
        this.command = command;
        this.event  = event1;
        this.event2 = event2;
    }
    public Instruction(Command command, ArrayList events)
    {
        this.command = command;
        this.events = events;
    }
    public String getCommandString()
    {
        return command.toString();
    }
}
