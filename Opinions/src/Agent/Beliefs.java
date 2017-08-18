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
public class Beliefs
{
    HashMap whatIThinkOf;
    public Beliefs()
    {
        this.whatIThinkOf = new HashMap();
        this.whatIThinkOf.put( "student", "not honorable" );
        this.whatIThinkOf.put( "professor", "honorable" );
    }
    void putBelief(String key, String value)
    {
        this.whatIThinkOf.put( key, value );
    }
    String getBelief(String key)
    {
        String result = "";
        if(this.whatIThinkOf.containsKey( key )) 
            return (String)this.whatIThinkOf.get( key );
        return result;
    }
}
