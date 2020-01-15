import greenfoot.*;

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    public Floor() {
        GreenfootImage floorImage = getImage();
        floorImage.scale(floorImage.getWidth(), floorImage.getHeight()-20);
        setImage(floorImage);
    }
    
    public void act() 
    {
        // Add your action code here.
        
    }    
}
