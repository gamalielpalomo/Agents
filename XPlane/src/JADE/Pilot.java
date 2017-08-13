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
		byte[] inputData = new byte[509];
		byte[] XPData;
		int quantity = 27;
		try
		{
		    DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
		    DatagramPacket receivePacket = new DatagramPacket(inputData, inputData.length);
		    serverSocket.receive(receivePacket);
		    XPData = receivePacket.getData();
		    Float []values = dataFilter(XPData,quantity);
		    serverSocket.close();
		}
		catch ( IOException ioe ){}
	    }

	});
    }
    
    private void update(Float []values)
    {
        Desire.updateDP(values[24], values[25], values[26]);
    }
    
    private Float[] dataFilter(byte[] data, int q){
	Float [] values = new Float[q];
	try{
	    FileWriter dataFile = new FileWriter("data.log",true);
	    
	    if(data[0]=='D'&&data[1]=='R'&&data[2]=='E'&&data[3]=='F')
	    {
		String buffer = "";
		int counter = 0;
		for(int i = 6; i < data.length && counter < q ; i++)
		{
		    if(data[i]!=44)
			buffer = buffer + (char)data[i];
		    else
		    {
			if(!"".equals(buffer)){
			    values[counter] = new Float(buffer);
			    //dataFile.write("\t"+values[counter]);
			    //dataFile.flush();
			    System.out.print("\t"+values[counter]);
			    buffer = "";
			    counter++;
			}
			else break;
		    }
		}
		//dataFile.write("\n");
		dataFile.close();
	    }
	}
	catch(IOException e ){}
	
	System.out.println("\n");
	return values;
    }
}
