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

    protected void setup()
    {

        addBehaviour( new CyclicBehaviour( this )
        {

            public void action()
            {
                ACLMessage inputMsg = receive();
                if ( inputMsg != null && inputMsg.getPerformative() == ACLMessage.INFORM )
                {
                    Instruction instruction = Interpreter.generateInstruction( inputMsg.getContent() );
                    switch(instruction.command){
                        case SCHEDULE:
                            System.out.println("[Assistant]: Schedule request received");
                            System.out.println("[Assistant]: Instruction -> "+instruction.event.getDescription());
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
