/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DREF;

import Globals.Globals;
import Tools.ByteArrayTool;
import Tools.Messenger;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author gamaa
 */
public class DREF_Listener
{
    public static void sendRequests()
    {
	//sim/flightmodel2/engines/throttle_used_ratio
	byte [] request = DREF_Request_Builder.getRequest(1, 0, "sim/cockpit2/engine/actuators/throttle_ratio_all");
	Messenger.sendMessage(request);
    }
    
    
    public static void executeService(){
	try{
	    DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
	    byte[] inputData = new byte[509];
	    byte[] XPData;
	    int quantity = 2;

	    while (true)
	    {
		DatagramPacket receivePacket = new DatagramPacket(inputData, inputData.length);
		serverSocket.receive(receivePacket);
		XPData = receivePacket.getData();
		dataFilter(XPData,2);
	    }
	}
	catch(IOException ioe){
	    System.err.println(ioe);
	}
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
