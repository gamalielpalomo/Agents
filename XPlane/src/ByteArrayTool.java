
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
		System.out.println("Setting pitch");
		System.arraycopy(values, 0, data, 9, 4);
		break;
	    case "roll":
		System.out.println("Setting roll");
		System.arraycopy(values, 0, data, 13, 4);
		break;
	    case "yaw":
		System.out.println("Setting yaw");
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
