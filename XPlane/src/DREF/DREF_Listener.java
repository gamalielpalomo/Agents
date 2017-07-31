/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DREF;

import Globals.Globals;
import Tools.ByteArrayTool;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Adrian Gonzalez
 */
public class DREF_Listener
{
    public static void executeService(){
	try{
	    DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
	    byte[] inputData = new byte[509];
	    byte[] XPData;

	    while (true)
	    {
		DatagramPacket receivePacket = new DatagramPacket(inputData, inputData.length);
		serverSocket.receive(receivePacket);
		XPData = receivePacket.getData();
		dataFilter(XPData);
	    }
	}
	catch(IOException ioe){
	    System.err.println(ioe);
	}
    }
    
    static void dataFilter(byte[] data){
	if(data[0]=='D'&&data[1]=='R'&&data[2]=='E'&&data[3]=='F')
	{
	    
	    //for(int i=5; i<=data.length-1; i++){
		byte[] tmp = new byte[4];
		System.arraycopy(data, 5, tmp, 0, 4);
		float value = ByteArrayTool.byteArray2Float(tmp);
		System.out.print("\t"+value);
	    //}
	    System.out.println("\n");
	}
    }
}
