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
public class DREF_Request_Builder
{
    public static byte[] getRequest(int i_Freq, int i_DREF_ID, String s_DREF_Name)
    {
	
	byte [] request = new byte[509];
	request[0] = 68;
	request[1] = 82;
	request[2] = 69;
	request[3] = 70;
	request[4] = 48;
	
	byte [] ba_Freq		= ByteArrayTool.int2ByteArray(i_Freq);
	byte [] ba_DREF_ID	= ByteArrayTool.int2ByteArray(i_DREF_ID);
	byte [] ba_DREF_Name	= ByteArrayTool.string2ByteArray(s_DREF_Name);
	
	int ptr = 5;
	System.arraycopy(ba_Freq, 0, request, ptr, 4);
	ptr = ptr + 4;
	System.arraycopy(ba_DREF_ID, 0, request, ptr, 4);
	ptr = ptr + 4;
	System.arraycopy(ba_DREF_Name, 0, request, ptr, ba_DREF_Name.length);
	ptr = ptr + ba_DREF_Name.length;
	for(int i=ptr;i<request.length-1;i++)
	    request[i] = 32;
	request[508] = 48;
	
	return request;
	
    }
    
}
