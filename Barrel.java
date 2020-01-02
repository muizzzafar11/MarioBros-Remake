import greenfoot.*;

public class Barrel extends Actor
{
    
    public Barrel () {
        GreenfootImage barrelImage = getImage();
        barrelImage.scale(barrelImage.getWidth()-20, barrelImage.getHeight()-20);
        setImage(barrelImage);
    }
    public void act() 
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } else{
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor2.class))
          {
            setLocation(getX() - 3, getY() - 3);
            turn(-8);
          }
          while(isTouching(Floor.class))
          {
            setLocation(getX() + 3, getY() - 3);
            turn(8);
          }
       }
    }
}
 