/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DREF;

/**
 *
 * @author Adrian Gonzalez
 */
public class COMMAND_Builders
{
    public static byte[] createCOMMAND(String commandX)
    {
	int DataSize = 505;
	char[] TextMessageX_Plane = new char[DataSize];
	char[] DataCommand = commandX.toCharArray();
	char EndNull = (char)(0);
	byte[] mensaje = new byte[commandX.length() + 6];
	
	mensaje[0] = 67;
	mensaje[1] = 77;
	mensaje[2] = 78;
	mensaje[3] = 68;
	mensaje[4] = 48;
	
	for (int i = 5; i < commandX.length() + 5; i++)
	{
	    mensaje[i] = (byte)DataCommand[i - 5];
	}
	mensaje[commandX.length() + 5] = (byte)EndNull;
	return mensaje;
    } 
}
