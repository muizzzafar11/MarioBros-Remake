import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{   //Size of the barrel
    public Barrel (){
        GreenfootImage myImage = getImage();
        myImage.scale(50,50);
    }
    public void act() 
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } else{
          //Speed of the barrel?
          setLocation(getX(), getY() + 4);
          while(isTouching(Floor2.class))
          {
            //Speed of the barrel on the floor2?  
            setLocation(getX() - 3, getY() - 3);
            turn(-8);
          }
          while(isTouching(Floor.class))
          { //Speed of the barrel on the floor?
            setLocation(getX() + 3, getY() - 3);
            turn(8);
          }
       }
    }
}
 