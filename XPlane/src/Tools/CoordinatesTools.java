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
	//System.out.println("Beta->"+beta);
	//System.out.println("Theta->"+theta);
	
	if(deltaX>0)
	{
	    if(deltaZ>0)
		r = beta+90-theta;
	    
	    else
	    	r = 90-theta+beta;
	    
    	}
	else
	{
	    if(deltaZ>0)
		r = 270-theta-beta;
	    
	    else
		r = 270 - theta -beta;
	    
	}
	//System.out.println("r->"+r);
	//System.out.println("real Angle->"+(360-(theta+r)+90));
	//System.out.println("after rotation real angle->"+(360-(theta+r)+90+theta));
	float realAngleAfterRotation = 360-(theta+r)+90+theta;
	
	newPosX = h*(float)Math.cos(Math.toRadians(realAngleAfterRotation));
	newPosZ = -h*(float)Math.sin(Math.toRadians(realAngleAfterRotation));
	result = new Coordinate(newPosX,newPosZ);
	//System.out.println("[rotateOverCircle]: newPosX->"+newPosX);
	//System.out.println("[rotateOverCircle]: newPosZ->"+newPosZ);
	
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
