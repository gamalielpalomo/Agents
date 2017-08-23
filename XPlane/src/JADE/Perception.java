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
    
    //Variables needed for environment sensing
    int length = Globals.DREF_LENGTH;
    byte[] inputData = new byte[length];
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
    
    
    public Perception(){ }
    
    public void executePerception()
    {
        Float []values = Sense();
        if(values != null)
        {
            
            this.local_x    =   values[15];
            this.local_y    =   values[16];
            this.local_z    =   values[17];
            this.local_theta=   values[8];	    
            this.local_phi  =   values[9];	    
            this.local_psi  =   values[10];	    
            this.plane1_x   =   values[24];
            this.plane1_y   =   values[25];
            this.plane1_z   =   values[26];
            this.plane1_theta=  values[27];	    
            this.plane1_phi =   values[28];	    
            this.plane1_psi =   values[29];	    
            
        }
    }
    
    Float[] Sense(){
        Float [] result = null;
	try
	{
	    DatagramSocket serverSocket = new DatagramSocket(Globals.RECEIVE_PORT);
	    DatagramPacket receivePacket = new DatagramPacket(inputData, inputData.length);
	    serverSocket.receive(receivePacket);
	    XPData = receivePacket.getData();
	    result = dataFilter(XPData,quantity);
	    serverSocket.close();
	}
	catch ( IOException ioe ){return null;}
        return null;
    }
    
    Float[] dataFilter(byte[] data, int q){
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