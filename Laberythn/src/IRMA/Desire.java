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
public class Desire {
    
    Coordinate goalCoordinate;
    public Desire(Coordinate goal)
    {
        this.goalCoordinate = goal;
    }
    public Coordinate getDesire()
    {
        return this.goalCoordinate;
    }
    public void updateDesire(Coordinate goal)
    {
        this.goalCoordinate = goal;
    }
    
}
