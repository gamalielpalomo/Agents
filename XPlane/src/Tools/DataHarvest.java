/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Globals.Globals;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.io.FileWriter;

/**
 *
 * @author gamaa
 */
public class DataHarvest
{
    
    public static Thread Harvest(){
	ArrayList<Float[]> data = new ArrayList();
	return new Thread(() ->
	{
	    try{
		DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
		byte[] inputData = new byte[509];
		byte[] XPData;
		int quantity = 21;
		
		while (true)
		{
		    DatagramPacket receivePacket = new DatagramPacket(inputData, inputData.length);
		    serverSocket.receive(receivePacket);
		    XPData = receivePacket.getData();
		    //data.add(dataFilter(XPData,1));
		    dataFilter(XPData,quantity);
		}
	    }
	    catch(IOException ioe){
		System.err.println(ioe);
	    }
	});
	
	
    }
    
    static Float[] dataFilter(byte[] data, int q){
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
			    dataFile.write("\t"+values[counter]);
			    dataFile.flush();
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
