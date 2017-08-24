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
    Float plane0_x;
    Float plane0_y;
    Float plane0_z;
    Float plane0_theta;	    //LOCAL PITCH
    Float plane0_phi;	    //LOCAL ROLL
    Float plane0_psi;	    //LOCAL HEADING
    Float plane1_x;
    Float plane1_y;
    Float plane1_z;
    Float plane1_theta;	    //REMOTE PITCH
    Float plane1_phi;	    //REMOTE ROLL
    Float plane1_psi;	    //REMOTE HEADING
    
    
    public Perception(){ }
    
    public boolean executePerception()
    {
	boolean done = false;
        Float []values = Sense();
        if(values != null)
        {
            
            this.plane0_x    =   values[15];
            this.plane0_y    =   values[16];
            this.plane0_z    =   values[17];
            this.plane0_theta=   values[8];	    
            this.plane0_phi  =   values[9];	    
            this.plane0_psi  =   values[10];	    
            this.plane1_x   =   values[24];
            this.plane1_y   =   values[25];
            this.plane1_z   =   values[26];
            this.plane1_theta=  values[27];	    
            this.plane1_phi =   values[28];	    
            this.plane1_psi =   values[29];	    
         
	    System.out.println("\n[Perception]: plane0_x -> "+plane0_x);
	    System.out.println("[Perception]: plane0_y -> "+plane0_y);
	    System.out.println("[Perception]: plane0_z -> "+plane0_z);
	    System.out.println("[Perception]: plane1_x -> "+plane1_x);
	    System.out.println("[Perception]: plane1_y -> "+plane1_y);
	    System.out.println("[Perception]: plane1_z -> "+plane1_z);
	    System.out.println("[Perception]: plane1_psi -> "+plane1_psi);
	    done = true;
        }
	return done;
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
        return result;
    }
    
    Float[] dataFilter(byte[] data, int q){
	Float [] values = new Float[q];
	//Tools.ByteArrayTool.printArray(data);
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
			    //System.out.print("\t"+values[counter]);
			    buffer = "";
			    counter++;
			}
			else 
			    throw new IOException();
		    }
		}
		//dataFile.write("\n");
		dataFile.close();
	    }
	    else throw new IOException();
	}
	catch(IOException e ){return null;}
	
	//System.out.println("\n");
	return values;
    }
    
}