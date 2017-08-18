/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 *
 * @author gamaa_000
 */
public class TalkingAgent extends jade.core.Agent
{
    
    @Override
    protected void setup()
    {
        
        Knowledge knowledge = new Knowledge();
        Beliefs belief = new Beliefs();
        
        addBehaviour( new CyclicBehaviour(this){
            @Override
            public void action()
            {
                ACLMessage inputMsg = receive();
                if ( inputMsg != null && inputMsg.getPerformative() == ACLMessage.REQUEST )
                {
                    System.out.format("\nI'm agent %s and i received request information from %s: %s\n",this.getAgent().getName(),inputMsg.getSender().getName(),inputMsg.getContent());
                    ACLMessage reply = inputMsg.createReply();
                    String name = inputMsg.getContent();
                    String kldge = knowledge.getKnoledge( name );
                    String think;
                    if(!kldge.equals( "" ))
                    {
                        think = belief.getBelief( kldge );
                        reply.setContent(inputMsg.getContent()+" is a "+kldge+" and i think is "+think);
                    }
                    else
                    {
                        reply.setContent("I dont have opinion about "+inputMsg.getContent());
                    }
                    send(reply);
                }
                else if( inputMsg != null && inputMsg.getPerformative() == ACLMessage.INFORM ){
                    String line = inputMsg.getContent();
                    StringTokenizer st = new StringTokenizer(line);
                    ArrayList list = new ArrayList();
                    while(st.hasMoreTokens())
                    {
                        String token = st.nextToken();
                        if( !token.equals( "is") && !token.equals( "a"))
                            list.add(token);
                    }
                    knowledge.putKnowledge( (String)list.get( 0 ), (String)list.get( 1 ) );
                }
            }
        });
    }
    
}
