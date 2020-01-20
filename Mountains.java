import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountains here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountains extends Actor
{
    public Mountains () {
        GreenfootImage mountImage = getImage();
        int mountWidth = mountImage.getWidth()+75;
        int mountHeight = mountImage.getHeight()+75;
        mountImage.scale(mountWidth,mountHeight);
        setImage(mountImage);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
