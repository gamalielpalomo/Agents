/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;
import tools.SerializableArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
/**
 *
 * @author gamaa
 */
public class Agenda {
    
    public static SerializableArrayList registry = new SerializableArrayList();
    
    public static void initRegistry()
    {
        File obj = new File("src/Agenda/registry.obj");
        if(obj.exists())
        {
            System.out.println("[Agenda/initRegistry]: registry already exists, reading...");
            readRegistryFromFile();
            showRegistry();
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
    public static void removeEvent(Event event)
    {
        registry.remove( event );
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
            tools.EventArray.sortEvents();
        }
        catch(IOException|ClassNotFoundException ioe)
        {            System.out.println("[Agenda/readRegistryFromFile]: Exception"); ioe.printStackTrace();        }
    }
    
    public static void showRegistry()
    {
        for (Iterator it = registry.iterator(); it.hasNext();) {
            Object element = it.next();
            Event event = (Event) element;
            System.out.println("---------------------------------------------");
            System.out.println("Event:\t"+event.getDescription());
            System.out.println("Start:\t"+event.getStartDate().getTime().toString());
            System.out.println("Finish:\t"+event.getFinishDate().getTime().toString());
        }
    }
    
}

