/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IRMA;
import Environment.Coordinate;
/**
 *
 * @author gamaa
 */
public class Action {
    Coordinate goal;
    public static enum MOVE{UP,RIGHT,DOWN,LEFT,NOTHING}
    public Action(Coordinate goal){this.goal=goal;}
    public MOVE getAction( Path path){
        
        Coordinate actual = (Coordinate)path.getPath().get(0);
        Coordinate nextStep = (Coordinate)path.getPath().get(1);
        
        System.out.format("[Action]: actual->[%d][%d]\n",actual.getRow(),actual.getColumn());
        System.out.format("[Action]: nextStep->[%d][%d]\n",nextStep.getRow(),nextStep.getColumn());
        
        if(actual.getColumn()==goal.getColumn()&&actual.getRow()==goal.getRow())
            return MOVE.NOTHING;
        else if(actual.getRow()==nextStep.getRow())
        {
            if(actual.getColumn()>nextStep.getColumn())
                return MOVE.LEFT;
            else if(actual.getColumn()<nextStep.getColumn())
                return MOVE.RIGHT;
        }
        else if(actual.getColumn()==nextStep.getColumn())
        {
            if(actual.getRow()>nextStep.getRow())
                return MOVE.UP;
            else if(actual.getRow()<nextStep.getRow())
                return MOVE.DOWN;
        }
        return MOVE.NOTHING;
    }
}
