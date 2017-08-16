/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import Agenda.Event;

/**
 *
 * @author gamaa_000
 */
public class Instruction
{

    public static enum Command
    {
        CREATE, SCHEDULE, REMOVE, CHANGE, MOVE, SHOW, NOTHING
    }
    Event event, event2;
    Command command;

    public Instruction(Command command)
    {
        this.command = command;
        this.event  = null;
        this.event2 = null; 
    }
    public Instruction( Command command, Event event )
    {
        this.command = command;
        this.event  = event;
        this.event2 = null;
    }
    public Instruction( Command command, Event event1, Event event2)
    {
        this.command = command;
        this.event  = event1;
        this.event2 = event2;
    }
    public String getCommandString()
    {
        return command.toString();
    }
}
