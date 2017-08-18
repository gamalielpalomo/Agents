/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import java.util.HashMap;

/**
 *
 * @author gamaa_000
 */
public class Knowledge
{
    HashMap whatPersonIs;
    public Knowledge()
    {
        this.whatPersonIs = new HashMap();
        this.whatPersonIs.put("A","student");
        this.whatPersonIs.put("B","student");
        this.whatPersonIs.put("C","professor");
    }
    void putKnowledge(String key, String value)
    {
        this.whatPersonIs.put( key, value );
    }
    String getKnoledge(String key)
    {
        String result;
        result = "";
        if(this.whatPersonIs.containsKey( key )) 
            return (String)this.whatPersonIs.get( key );
        return result;
    }
}