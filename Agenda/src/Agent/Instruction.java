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

    enum Command
    {
        CREATE, SCHEDULE, REMOVE, MOVE
    }
    Event event;
    Command command;

    public void Instruction( Command command, Event event )
    {
        this.command = command;
        this.event = event;
    }
}
