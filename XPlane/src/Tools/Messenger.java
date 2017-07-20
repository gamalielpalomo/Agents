package Tools;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import Globals.Globals;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gamaa
 */
public class Messenger
{
    public static void sendMessage(byte[] MsgBArray){
	try {
	    String host = Globals.XPLANE_ADDR;
	    int port = Globals.PORT;

	    // Get the internet address of the specified host
	    InetAddress address = InetAddress.getByName(host);

	    // Initialize a datagram packet with data and address
	    DatagramPacket packet = new DatagramPacket(MsgBArray, MsgBArray.length, address, port);

	    // Create a datagram socket, send the packet through it, close it.
	    DatagramSocket dsocket = new DatagramSocket();
	    dsocket.send(packet);
	  } catch (IOException e) {
	    System.err.println(e);
	 }
    }
}