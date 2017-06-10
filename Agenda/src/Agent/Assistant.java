/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import parser.Interpreter;

/**
 *
 * @author gamaa_000
 */
public class Assistant extends Agent
{

    @Override
    protected void setup()
    {
        Agenda.Agenda.initRegistry();
        addBehaviour( new CyclicBehaviour( this )
        {

            @Override
            public void action()
            {
                ACLMessage inputMsg = receive();
                if ( inputMsg != null && inputMsg.getPerformative() == ACLMessage.INFORM )
                {
                    Instruction instruction = Interpreter.generateInstruction( inputMsg.getContent() );
                    switch(instruction.command){
                        case SCHEDULE:
                            System.out.println("[Assistant]: Schedule request received");
                            System.out.println("[Assistant]: Description -> "+instruction.event.getDescription());
                            System.out.println("[Assistant]: Instruction -> "+instruction.getCommandString());
                            Agenda.Agenda.registerEvent(instruction.event);
                            break;
                        case REMOVE:
                            System.out.println("[Assistant]: Remove request received");
                            System.out.println("[Assistant]: Description -> "+instruction.event.getDescription());
                            System.out.println("[Assistant]: Instruction -> "+instruction.getCommandString());
                            break;
                        case NOTHING:
                            System.out.println("[Assistant]: Nothing to do...");
                            break;
                        default:
                            System.out.println("[Assistant]: I dont understand the instruction");
                    }
                }
            }

        } );

    }
}
