/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;
import java.io.File;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author gamaa
 */
public class Agenda {
    
    static SerializableArrayList registry = new SerializableArrayList();
    
    public static void initRegistry()
    {
        File obj = new File("src/Agenda/registry.obj");
        if(obj.exists())
        {
            System.out.println("[Agenda/initRegistry]: registry already exists, reading...");
            readRegistryFromFile();
        }
        else
        {
            System.out.println("[Agenda/initRegistry]: writting new registry");
            objectWritter();
        }
    }
    
    public static void registerEvent(Event event)
    {
        registry.add(event);
        objectWritter();
    }
    
    static void objectWritter()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("src/Agenda/registry.obj");
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(registry);
            }
            System.out.println("[Agenda/objectWritter]: Saved");
        }
        catch(IOException ioe)
        {            
            System.out.println("[Agenda/objectWritter]: Exception");
            ioe.printStackTrace();
        }
    }
    
    static void readRegistryFromFile()
    {
        try
        {
            FileInputStream fis = new FileInputStream("src/Agenda/registry.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            registry = (SerializableArrayList) ois.readObject();
        }
        catch(IOException|ClassNotFoundException ioe)
        {            System.out.println("[Agenda/readRegistryFromFile]: Exception");        }
    }
    
}

class SerializableArrayList extends ArrayList implements Serializable
{
    private static final long serializableUID = 1L;
}
