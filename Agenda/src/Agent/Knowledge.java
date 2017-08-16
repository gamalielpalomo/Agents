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
    public static HashMap<String,String> nameToPersonType;
    public static HashMap<String,String> personTypeToDateType;
    
    public static void initKnowledge()
    {
        nameToPersonType = new HashMap<String,String>();
        personTypeToDateType = new HashMap<String,String>();
        nameToPersonType.put( "john", "doctor");
        nameToPersonType.put( "maria", "friend");
        nameToPersonType.put( "gamma", "workpartner");
        personTypeToDateType.put( "doctor", "medical");
        personTypeToDateType.put( "friend", "personal");
        personTypeToDateType.put( "workpartner", "work");
    }
    
}
