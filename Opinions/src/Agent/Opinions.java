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
            }
        });
    }
    
}
