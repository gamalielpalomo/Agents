/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
/**
 *
 * @author gamaa_000
 */
public class Opinions extends Agent
{

    @Override
    protected void setup()
    {
        addBehaviour( new CyclicBehaviour(this){
            @Override
            public void action()
            {
                ACLMessage inputMsg = receive();
                if ( inputMsg != null && inputMsg.getPerformative() == ACLMessage.REQUEST )
                {
                    
                    System.out.format("\nI'm agent %s and i received request information from %s: %s",this.getAgent().getName(),inputMsg.getSender().getName(),inputMsg.getContent());
                    ACLMessage reply = inputMsg.createReply();
                    reply.setContent(inputMsg.getContent()+" is a student");
                    send(reply);
                }
                else if(inputMsg != null){
                    System.out.format("\nI'm agent %s and i received a message of type %d from %s: %s",this.getAgent().getName(),inputMsg.getPerformative(),inputMsg.getSender().getName(),inputMsg.getContent());
                }
            }
        });
    }
    
}
