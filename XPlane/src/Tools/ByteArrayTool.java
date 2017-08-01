package Tools;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamaa
 */
public class ByteArrayTool
{
    public static byte [] float2ByteArray (float value)
    {  
	return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(value).array();
        
    }
    public static float byteArray2Float (byte[] values){
        return ByteBuffer.wrap(values).order(ByteOrder.LITTLE_ENDIAN).getFloat();
    }
    public static byte [] double2ByteArray (double value)
    {
	return ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(value).array();
    }
    public static byte [] int2ByteArray(int value){
	return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(value).array();
    }
    public static int byteArray2Int(byte [] values)
    {
	return ByteBuffer.wrap(values).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }
    
    public static byte [] string2ByteArray(String string)
    {
	char [] ch = string.toCharArray();
	byte [] ba_string = new byte[ch.length];
	for(int i = 0; i<ch.length; i++)
	    ba_string[i] = (byte)ch[i];
	return ba_string;
    }
    public static byte [] getVEHNData(int craft, byte[] values){
	byte [] data = new byte[1024];
	byte [] header = {86, 69, 72, 78, 17};
	System.arraycopy(header, 0, data, 0, 5);
	byte [] B_craft = int2ByteArray(craft);
	System.arraycopy(B_craft, 0, data, 5, 4);
	System.arraycopy(values, 0, data, 9, values.length);
	return data;
    }
    public static byte [] getVEH1Data(int craft){
	byte [] lat = double2ByteArray(20.748623);
	byte [] lon = double2ByteArray(-103.47661);
	byte [] ele = double2ByteArray(5378.6177);
	byte [] lat_lon_ele = new byte[24];
	System.arraycopy(lat, 0, lat_lon_ele, 0, 8);
	System.arraycopy(lon, 0, lat_lon_ele, 8, 8);
	System.arraycopy(ele, 0, lat_lon_ele, 15, 8);
	
	byte [] psi_the_phi = {0, 0, 0, 0, 
				0, 0, 0, 0,
				 0, 0, 0, 0};
	
	byte [] gear_flap_vect = {0, 0, 0, 0, 
				    0, 0, 0, 0,
				     0, 0, 0, 0,
					0, 0, 0, 0};
	
	byte [] header = { 86, 69, 72, 49, 0};
	byte [] B_craft = int2ByteArray(craft);
	byte [] data = new byte[61];
	
	System.arraycopy(header, 0, data, 0, 5);
	System.arraycopy(B_craft, 0, data, 5, 4);
	System.arraycopy(lat_lon_ele, 0, data, 9, 24);
	System.arraycopy(psi_the_phi, 0, data, 33, 12);
	System.arraycopy(gear_flap_vect, 0, data, 45, 16);
	
	return data;
    }
    public static byte [] getXPData(String index, byte[] values){
	byte [] data = { 68, 65, 84, 65, 0, 
			    11, 0, 0, 0, 
			    0, (byte)192, 121, (byte)196, 
			    0, (byte)192, 121, (byte)196, 
			    0, (byte)192, 121, (byte)196, 
			    0, (byte)192, 121, (byte)196, 
			    0, 0, 0, 0, 
			    0, 0, 0, 0, 
			    0, 0, 0, 0, 
			    0, 0, 0, 0 };	
	switch(index){
	    case "pitch":
		//System.out.println("Setting elevators");
		System.arraycopy(values, 0, data, 9, 4);
		break;
	    case "roll":
		//System.out.println("Setting ailerons");
		System.arraycopy(values, 0, data, 13, 4);
		break;
	    case "yaw":
		//System.out.println("Setting rudder");
		System.arraycopy(values, 0, data, 17, 4);
		break;
	}
	return data;
    }
    public static void printArray(byte [] array){
	System.out.println("----------------------------------");
	for(byte element:array){
	    System.out.print(element+" ");
	}
	System.out.println("\n----------------------------------");
    }
}
