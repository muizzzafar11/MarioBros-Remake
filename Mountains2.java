import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountains2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountains2 extends Mountains
{
    /**
     * Act - do whatever the Mountains2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Mountains2 () {
        GreenfootImage mountImage = getImage();
        int mountWidth = mountImage.getWidth()+95;
        int mountHeight = mountImage.getHeight()+95;
        mountImage.scale(mountWidth,mountHeight);
        setImage(mountImage);
    
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void hitdetect(int px, int py){
    
    }
    
}
