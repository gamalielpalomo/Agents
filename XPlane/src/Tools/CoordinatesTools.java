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
	float newPosY;
	float deg_theta = theta;
	
	double hypotenuse = Math.pow(floatingPoint.x-fixedPoint.x, 2)+Math.pow(floatingPoint.y-fixedPoint.y, 2);
	hypotenuse = Math.sqrt(hypotenuse);
	
	newPosX = ((float)Math.cos(deg_theta))*(float)hypotenuse;
        newPosX = newPosX + fixedPoint.x;
	
	newPosY = ((float)Math.sin(deg_theta))*(float)hypotenuse;
        newPosX = newPosX + fixedPoint.x;
	//newPosY = leaderPosY; 
	
	return result;
    }
}
