/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;
import Globals.Globals;
import jade.core.Agent;
import jade.core.behaviours.*;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 *
 * @author gamaa
 */
public class Pilot extends Agent
{
    @Override
    protected void setup()
    {
	
	addBehaviour( new CyclicBehaviour( this )
	{
	    
	    @Override
	    public void action()
	    {
		
	    }

	});
    }
    
    private void update(Float []values)
    {
        Desire.updateDesiredPossition(values[24], values[25], values[26]);
    }
    
    
}
