/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputDataTools;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import Globals.Globals;
import Tools.ByteArrayTool;
/**
 *
 * @author gamaa
 */
public class Service
{
    public static void executeService(){
	try{
	    DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
	    byte[] inputData = new byte[1024];
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
	/*switch(data[5]){
	    case 20:
		System.out.println("Dataset 20");
		break;
	}*/
	ByteArrayTool.printArray(data);
	for(int i=9; i<=data.length; i+=4){
	    byte[] tmp = new byte[4];
	    System.arraycopy(data, i, tmp, 0, 3);
	    float value = ByteArrayTool.byteArray2Float(tmp);
	    System.out.print(" "+value);
	}
	
    }
    
    
}
