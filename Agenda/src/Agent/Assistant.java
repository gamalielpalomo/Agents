/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools Templates
 * and open the template in the editor.
 */
package Agent;

import Agenda.Event;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.Iterator;
import parser.Interpreter;
import tools.EventArray;

/**
 *
 * @author gamaa_000
 */
public class Assistant extends Agent
{

    @Override
    protected void setup()
    {
        Belief.initBeliefs();
        Knowledge.initKnowledge();
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
                    switch ( instruction.command )
                    {
                        case SCHEDULE:
                            /*System.out.println("[Assistant]: Schedule request received");
                            System.out.println("[Assistant]: Description -> "+instruction.event.getDescription());
                            System.out.println("[Assistant]: Instruction -> "+instruction.getCommandString());*/
                            Agenda.Agenda.registerEvent( instruction.event );
                            System.out.println( "[Assistant]: These are your scheduled events: \n" );
                            EventArray.sortEvents();
                            Agenda.Agenda.showRegistry();
                            break;
                        case REMOVE:
                            System.out.println( "[Assistant]: Remove request received" );
                            Agenda.Agenda.removeEvent( instruction.event );
                            EventArray.sortEvents();
                            Agenda.Agenda.showRegistry();
                            break;
                        case FREE:
                            System.out.println( "[Assistant]: FREE request received" );
                            for(Iterator it = instruction.events.iterator(); it.hasNext();)
                            {
                                Object element = it.next();
                                Event event = (Event) element;
                                Agenda.Agenda.removeEvent( event );                                
                            }
                            EventArray.sortEvents();
                            Agenda.Agenda.showRegistry();
                            break;
                        case CHANGE:
                            System.out.println( "[Assistant]: Change request received" );
                            Agenda.Agenda.removeEvent( instruction.event );
                            Agenda.Agenda.registerEvent( instruction.event2 );
                            EventArray.sortEvents();
                            Agenda.Agenda.showRegistry();
                            break;
                        case SHOW:
                            System.out.println( "\n[Assistant]: These are your scheduled events:" );
                            EventArray.sortEvents();
                            Agenda.Agenda.showRegistry();
                            break;
                        case NOTHING:
                            System.out.println( "[Assistant]: Nothing to do..." );
                            Agenda.Agenda.showRegistry();
                            break;
                        default:
                            System.out.println( "[Assistant]: I dont understand the instruction" );
                    }
                }
            }

        } );

    }
}
