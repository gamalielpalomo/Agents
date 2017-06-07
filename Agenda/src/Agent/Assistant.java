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
public class Assistant extends Agent
{
    protected void setup()
    {
        
        addBehaviour(new CyclicBehaviour(this){
        
            public void action()
            {
                ACLMessage inputMsg = receive();
                if(inputMsg!=null && inputMsg.getPerformative() == ACLMessage.INFORM)
                {
                    
                }
            }
        
        });
        
    }
}
