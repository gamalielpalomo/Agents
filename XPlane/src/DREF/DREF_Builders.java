/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DREF;
import Tools.ByteArrayTool;
/**
 *
 * @author gamaa
 */
public class DREF_Builders
{
    public static byte[] createDREF(String Dataref, float NewValue)
    {
	int DataSize = 505;
	char[] TextMessageX_Plane = new char[DataSize];
	int StringPosition = 0;
	//Dataref = Dataref + "[0]";
	char[] DataReference = Dataref.toCharArray();
	
	for (int x = 0; x <= DataReference.length - 1; x++)
	{
	    TextMessageX_Plane[StringPosition] = DataReference[StringPosition];
	    StringPosition = StringPosition + 1;
	}
	
	for (int i = StringPosition; i < (DataSize - 1); i = i + 1) 
	    TextMessageX_Plane[i] = (char)(32);
        char EndNull = (char)(0);
	
	byte[] Message = new byte[509];
	Message[0] = 68;
	Message[1] = 82;
	Message[2] = 69;
	Message[3] = 70;
	Message[4] = 48;
	
	byte []tmpValue = ByteArrayTool.float2ByteArray(NewValue);
	Message[5] = tmpValue[0];
	Message[6] = tmpValue[1];
	Message[7] = tmpValue[2];
	Message[8] = tmpValue[3];
	
	for (int i = 9; i < TextMessageX_Plane.length + 3; i++)
	    Message[i] = (byte)TextMessageX_Plane[i - 9];
	
	Message[508] = (byte)EndNull;
        return Message;
    }
    public static byte[] createDREF(String Dataref, float []values)
    {
	int DataSize = 505;
	char[] TextMessageX_Plane = new char[DataSize];
	int StringPosition = 0;
	Dataref = Dataref + "[0]";
	System.out.println(Dataref);
	char[] DataReference = Dataref.toCharArray();
	
	for (int x = 0; x <= DataReference.length - 1; x++)
	{
	    TextMessageX_Plane[StringPosition] = DataReference[StringPosition];
	    StringPosition = StringPosition + 1;
	}
	
	for (int i = StringPosition; i < (DataSize - 1); i = i + 1) 
	    TextMessageX_Plane[i] = (char)(32);
        char EndNull = (char)(0);
	
	byte[] Message = new byte[509];
	Message[0] = 68;
	Message[1] = 82;
	Message[2] = 69;
	Message[3] = 70;
	Message[4] = 48;
	
	int Messagectr = 5;
	for(int i=0;i<=values.length-1;i++)
	{
	    byte []tmpValue = ByteArrayTool.float2ByteArray(values[i]);
	    System.arraycopy(tmpValue, 0, Message, Messagectr, 4);
	    Messagectr+=4;
	}
	
	//System.arraycopy(TextMessageX_Plane, 0, Message, 5+(values.length*4), TextMessageX_Plane.length);
	for (int i = Messagectr; i < Message.length-1; i++)
	    Message[i] = (byte)TextMessageX_Plane[i - Messagectr];
	
	Message[508] = (byte)EndNull;
        return Message;
    }
}
