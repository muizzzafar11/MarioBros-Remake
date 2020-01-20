import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;
/**
 * Write a description of class Finish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Finish extends World
{

    /**
     * Constructor for objects of class Finish.
     * 
     */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-300); 
    public static int height = (int)(screenSize.getHeight()/1.25);

    public Finish()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, height, 1,false); 
        addObject(new Floor(), 125, 1000);
        addObject(new Floor(), 375, 1000);
        addObject(new Floor(), 625, 1000);
        addObject(new Floor(), 875, 1000);
        addObject(new Floor(), 1125, 1000);
        addObject(new Floor(), 1375, 1000);
        addObject(new Princess(), 145, 940);
        addObject(new Mario(), 85, 940);
        showText("YOU WIN", 750, 600);
    }
}
