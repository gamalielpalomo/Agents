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
    float plane0_x;
    float plane0_y;
    float plane0_z;
    float plane0_theta;	    //LOCAL PITCH
    float plane0_phi;	    //LOCAL ROLL
    float plane0_psi;	    //LOCAL HEADING
    float plane0_speed;	    //LOCAL SPEED
    float plane0_XSpeed;
    float plane0_YSpeed;
    float plane0_ZSpeed;
    float plane1_x;
    float plane1_y;
    float plane1_z;
    float plane1_theta;	    //REMOTE PITCH
    float plane1_phi;	    //REMOTE ROLL
    float plane1_psi;	    //REMOTE HEADING
    float plane1_speed;	    //PLANE 1 SPEED
    
    
    
    
    public Perception(){ }
    
    public boolean executePerception()
    {
	boolean done = false;
        float []values = Sense();
        if(values != null)
        {
            
            this.plane0_x    =   values[15];
            this.plane0_y    =   values[16];
            this.plane0_z    =   values[17];
            this.plane0_theta=   values[8];	    
            this.plane0_phi  =   values[9];	    
            this.plane0_psi  =   values[10]%360;
	    this.plane0_speed = values[30]*2.23694f;
	    this.plane0_XSpeed = values[31]*2.23694f;
	    this.plane0_YSpeed = values[32]*2.23694f;
	    this.plane0_ZSpeed = values[33]*2.23694f;	    
            this.plane1_x   =   values[24];
            this.plane1_y   =   values[25];
            this.plane1_z   =   values[26];
            this.plane1_theta=  values[27];	    
            this.plane1_phi =   values[28];	    
            this.plane1_psi =   values[29]%360;	  
	    
	    
         
	    System.out.println("\n[Perception]: plane0_x -> "+plane0_x);
	    System.out.println("[Perception]: plane0_y -> "+plane0_y);
	    System.out.println("[Perception]: plane0_z -> "+plane0_z);
	    System.out.println("[Perception]: plane0_GroundSpeed -> "+plane0_speed);
	    System.out.println("[Perception]: plane0_XVelocity -> "+plane0_XSpeed);
	    System.out.println("[Perception]: plane0_YVelocity -> "+plane0_YSpeed);
	    System.out.println("[Perception]: plane0_ZVelocity -> "+plane0_ZSpeed);
	    System.out.println("[Perception]: plane1_x -> "+plane1_x);
	    System.out.println("[Perception]: plane1_y -> "+plane1_y);
	    System.out.println("[Perception]: plane1_z -> "+plane1_z);
	    System.out.println("[Perception]: plane1_psi -> "+plane1_psi);
	    
	    done = true;
        }
	return done;
    }
    
    float[] Sense(){
        float [] result = null;
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
    
    float[] dataFilter(byte[] data, int q){
	float [] values = new float[q];
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