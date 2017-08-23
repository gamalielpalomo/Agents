/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;
import jade.core.Agent;
import jade.core.behaviours.*;
/**
 *
 * @author gamaa
 */
public class Pilot extends Agent
{
    
    Perception perceptions;
    Desire desires;
    Belief beliefs;
    Intention intentions;
    
    
    @Override
    protected void setup()
    {
        
	perceptions = new Perception();
        desires = new Desire();
        intentions = new Intention();
        beliefs = new Belief();
        
	addBehaviour( new CyclicBehaviour( this )
	{
	    
	    @Override
	    public void action()
	    {
		perceptions.executePerception();
                desires.updateDesires(perceptions);
                beliefs.updateBeliefs(perceptions,desires);
                //intentions.updateIntentions(desires,beliefs);
                //intentions.executeActions();
	    }

	});
    }
    
    private void update(Float []values)
    {
        //Desire.updateDesiredPossition(values[24], values[25], values[26]);
    }
    
    
}
