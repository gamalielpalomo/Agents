/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;

import Globals.Globals;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author gamaa
 */
public class Perception
{
    
    Float fce = 0f;	    //Forward clearance error between leader and wingman
    Float lce = 0f;	    //Lateral clearance error between leader and wingman
    Float vce = 0f;	    //Vertical clearance error between leader and wingman
    
    //Variables needed for environment sensing
    byte[] inputData = new byte[509];
    byte[] XPData;
    int quantity = Globals.DREF_VARS;
    
    //Environment variables
    Float local_x;
    Float local_y;
    Float local_z;
    Float local_theta;	    //LOCAL PITCH
    Float local_phi;	    //LOCAL ROLL
    Float local_psi;	    //LOCAL HEADING
    Float plane1_x;
    Float plane1_y;
    Float plane1_z;
    Float plane1_theta;	    //REMOTE PITCH
    Float plane1_phi;	    //REMOTE ROLL
    Float plane1_psi;	    //REMOTE HEADING
    
    
    
    public Perception(Float[] values)
    {
	
    }
    
    Float[] Sense(){
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
    
    public Float getForwardError(Float actual)
    {
	fce = Desire.desiredPosX - actual;
	return fce;
    }
    
    public Float getLateralError(Float actual)
    {
	lce = Desire.desiredPosY - actual;
	return lce;
    }
    
    public Float getVerticalError(Float actual)
    {
	vce = Desire.desiredPosZ - actual;
	return vce;
    }
    
}
