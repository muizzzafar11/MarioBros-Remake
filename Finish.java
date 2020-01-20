import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;
/**
 * Write a description of class Finish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Toolkit;
import java.awt.Dimension;
public class Finish extends World
{

    /**
     * Constructor for objects of class Finish.
     * 
     */
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = (int)screenSize.getWidth();
    public static int height = (int)screenSize.getHeight();
    public Finish()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super((int)(screenSize.getWidth()/2.5), (int)(screenSize.getHeight()/1.25), 1);  
        //addObject(new Floor2(), 125, 1000);
        //addObject(new Floor2(), 375, 1000);
        //addObject(new Floor2(), 625, 1000);
        //addObject(new Floor2(), 875, 1000);
        //addObject(new Floor2(), 1125, 1000);
        //addObject(new Floor2(), 1375, 1000);
        //addObject(new Princess(), 145, 940);
        //addObject(new Mario(), 85, 940);
        showText("YOU WIN", 750, 600);
    }
}
