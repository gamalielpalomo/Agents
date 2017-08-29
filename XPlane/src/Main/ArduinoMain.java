package Main;

import com.fazecast.jSerialComm.*;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import Tools.Messenger;
import Tools.ByteArrayTool;
import DREF.DREF_Builders;
import jade.Boot;

/**
 *
 * @author luise
 */
public class ArduinoMain extends Thread
{
    public SerialPort ArduinoPort;
    public String ReadedData = "";
    public String[] LaData;
    public boolean ToogleBrakes = false; 
    public boolean ToogleControl = false;
    
    public ArduinoMain()
    {
    }
    
    public SerialPort getArduinoPort()
    {
        return ArduinoPort;
    }
    
    public boolean OpenArduinoConnection()
    {
        ArduinoPort = SerialPort.getCommPorts()[1];
        ArduinoPort.setBaudRate(9600);
        ArduinoPort.setFlowControl(SerialPort.FLOW_CONTROL_DISABLED);
        ArduinoPort.openPort();
        System.out.println(ArduinoPort.isOpen());
        System.out.println("Arduino Open: " + ArduinoPort.getSystemPortName());
        return ArduinoPort.isOpen();
    }
    
    public void CloseArduino()
    {
        try 
        {
            ArduinoPort.closePort();
        } 
        catch (Exception ex) 
        {
            System.out.println("Error: " + ex);
        }
    }
    
    @Override
    public void run()
    {
        OpenArduinoConnection();
        InputStream in;
        String CharAux;
        while(true)
        {
            in = getArduinoPort().getInputStream();
            try
            {
                char cmd = (char) in.read();
                if(cmd == '\n')
                {
                    ReadedData = ReadedData.replace("\r", "");
                    System.out.println(ReadedData);
                    LaData = ReadedData.split(",");
                    ReadedData = "";
                    //Elevators
                    float sensor = new Float(LaData[0]) - new Float(1);
                    byte []values = ByteArrayTool.float2ByteArray(sensor);
                    byte []XPData = ByteArrayTool.getXPData("pitch", values);
                    if(!ToogleControl)
                        Messenger.sendMessage(XPData);
                    
                    //Aileron
                    sensor = new Float(LaData[1]) - new Float(1);
                    XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/roll_ratio[0]", sensor);
                    if(!ToogleControl)
                        Messenger.sendMessage(XPData);
                    
                    //Rudder
                    sensor = new Float(LaData[2]) - new Float(1);
                    XPData = DREF_Builders.createDREF("sim/flightmodel2/controls/heading_ratio[0]", sensor);
                    if(!ToogleControl)
                        Messenger.sendMessage(XPData);

                    //Throttle
                    sensor = new Float(LaData[3]) - new Float(1);
                    XPData = DREF_Builders.createDREF("sim/cockpit2/engine/actuators/throttle_ratio_all[0]", sensor);
                    if(!ToogleControl)
                        Messenger.sendMessage(XPData);
                    
                    //Activate and disable control
                    if(new Float(LaData[4]) == 1)
                    {
                        System.out.println("=== CONTROL DISABLED ===");
                        if(ToogleControl == false)
                            ToogleControl = true;
                        else
                            ToogleControl = false;
                    }

                    //Activate and disable brakes
                    String drefName = "sim/multiplayer/controls/parking_brake[0]";
                    if(new Float(LaData[5]) == 1)
                    {
                        System.out.println("=== BRAKING ===");
                        if(ToogleBrakes == false)
                            ToogleBrakes = true;
                        else
                            ToogleBrakes = false;
                    }
                    if(ToogleBrakes){
                        XPData = DREF_Builders.createDREF(drefName, 1f);
                    }
                    else
                        XPData = DREF_Builders.createDREF(drefName, 0f);

                    if(!ToogleControl)
                        Messenger.sendMessage(XPData);
                    
                }
                else
                {
                    CharAux = String.valueOf(cmd);
                    ReadedData = ReadedData + CharAux;
                }
            }
            catch(Exception e)
            {
                System.out.println("Reading error: " + e);
            }
            
        }
    }
}
