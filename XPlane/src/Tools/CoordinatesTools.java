/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

/**
 *
 * @author gamaa
 */
public class CoordinatesTools
{
    public static Coordinate rotateOverCircle(Coordinate floatingPoint, Coordinate fixedPoint, float theta)
    {
	Coordinate result = floatingPoint;
	float newPosX;
	float newPosZ;
	float deltaX;
	float deltaZ;
	
	//Coordinate fixed = new Coordinate(-2,2);
	//Coordinate floating = new Coordinate(-4,-3);
	//deltaX = floating.getX()-fixed.getX();
	//deltaZ = floating.getZ()-fixed.getZ();
	deltaX = floatingPoint.getX()-fixedPoint.getX();
	deltaZ = floatingPoint.getZ()-fixedPoint.getZ();
	float h = (float)Math.sqrt(Math.pow(deltaX, 2)+Math.pow(deltaZ,2));
	float beta = (float)Math.toDegrees(Math.asin(deltaZ/h));
	float r;
	System.out.println("Beta->"+beta);
	System.out.println("Theta->"+theta);
	
	if(deltaX>0)
	{
	    if(deltaZ>0){
		System.out.println("1");
		r = beta+90-theta;
	    }
	    else{
		System.out.println("2");
	    	r = 90-theta+beta;
	    }
    	}
	else
	{
	    if(deltaZ>0){
		System.out.println("3");
		r = 270-theta-beta;
	    }
	    else{
		System.out.println("4");
		r = 270 - theta -beta;
	    }
	}
	System.out.println("r->"+r);
	newPosX = h*(float)Math.cos(360+theta-r+90);
	newPosZ = -h*(float)Math.sin(360+theta-r+90);
	result = new Coordinate(newPosX,newPosZ);
	System.out.println("[rotateOverCircle]: newPosX->"+newPosX);
	System.out.println("[rotateOverCircle]: newPosZ->"+newPosZ);
	
	/*
	double hypotenuse = Math.pow(floatingPoint.x-fixedPoint.x, 2)+Math.pow(floatingPoint.z-fixedPoint.z, 2);
	hypotenuse = Math.sqrt(hypotenuse);
	
	newPosX = ((float)Math.cos(theta))*(float)hypotenuse;
        newPosX = newPosX + fixedPoint.x;
	
	newPosZ = ((float)Math.sin(theta))*(float)hypotenuse;
        newPosZ = newPosZ + fixedPoint.z;
	//newPosY = leaderPosY; 
	result.x=newPosX;
	result.z=newPosZ;
	*/
	
	return result;
    }
}
