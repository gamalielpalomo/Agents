/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JADE;

/**
 *
 * @author gamaa
 */
public class Intention
{
    Desire desires;
    Belief beliefs;
    FuzzyLogicAnalizer fuzzy;
    
    public Intention(){}
    public void createActionPlan(Desire desires, Belief beliefs)
    {
	this.desires = desires;
	this.beliefs = beliefs;
	System.out.println("[Intention]: Forward_error -> "+beliefs.fce);
	System.out.println("[Intention]: Lateral_error -> "+beliefs.lce);
	System.out.println("[Intention]: Vertical_error -> "+beliefs.vce);
	System.out.println("[Intention]: Velocidad_forward -> "+beliefs.perceptions.plane0_speed);
	System.out.println("[Intention]: Velocidad_lateral -> "+beliefs.perceptions.plane0_XSpeed);
	System.out.println("[Intention]: Velocidad_vertical -> "+beliefs.perceptions.plane0_YSpeed);
	this.fuzzy = new FuzzyLogicAnalizer();
	this.fuzzy.setValues("Forward_error", beliefs.fce, "Lateral_error", beliefs.lce, "Vertical_error", beliefs.vce, "Velocidad_forward",beliefs.perceptions.plane0_speed , "Velocidad_lateral", beliefs.perceptions.plane0_XSpeed, "Velocidad_vertical", -1*beliefs.perceptions.plane0_YSpeed);
	//Fix vertical clearance error
	fuzzy.getVerticalValue();
	fuzzy.getLateralValue();
	//System.out.println("[Intention]: Elevator -> "+fixingValueElevator);
	//Fix lateral clearance error
	
	
	
    }
}
