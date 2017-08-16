/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import java.util.ArrayList;

/**
 *
 * @author gamaa
 */
public class Belief
{

    public static ArrayList schedulingPreferences;

    public static void initBeliefs()
    {
        //Aqu? se establecen las prioridades que el agente tiene al momento de tener que decidir
        //Se realiza la selecci?n de acuerdo al ?ndice de la situaci?n en el arraylist
        schedulingPreferences = new ArrayList<>();
        schedulingPreferences.add( new String("medical") );       //Prioridad 0
        schedulingPreferences.add( new String("work") );          //Prioridad 1
        schedulingPreferences.add( new String("personal") );      //Prioridad 2
    }

}
