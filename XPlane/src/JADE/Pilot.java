/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;
import Globals.Globals;
import jade.core.Agent;
import jade.core.behaviours.*;
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
		
		try{
		    DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
		    byte[] inputData = new byte[509];
		    byte[] XPData;
		    int quantity = 2;
		    float [] values;
		    
		    while (true)
		    {
			DatagramPacket receivePacket = new DatagramPacket(inputData, inputData.length);
			serverSocket.receive(receivePacket);
			XPData = receivePacket.getData();
			values = dataFilter(XPData,quantity);
			System.out.println(values[0]+","+values[1]);
		    }
		}
		catch(IOException ioe){
		    System.err.println(ioe);
		}
		
	    }
	});
    }
    
    static float[] dataFilter(byte[] data, int q){
	float [] values = new float[q];
	if(data[0]=='D'&&data[1]=='R'&&data[2]=='E'&&data[3]=='F')
	{
	    String buffer = "";
	    int counter = 0;
	    for(int i = 6; i < data.length; i++)
	    {
		if(data[i]!=44)
		    buffer = buffer + (char)data[i];
		else
		{
		    try{
			values[counter] = new Float(buffer);
		    }
		    catch(java.lang.NumberFormatException nfe){break;}
		    buffer = "";
		    //System.out.print("\t"+values[counter]);
		    counter++;
		}
	    }
	}
	//System.out.println("\n");
	return values;
    }
}
