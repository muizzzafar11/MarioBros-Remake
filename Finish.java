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
    public Finish(String text)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width-500, height-500,1);  
        showText("" + text, (width-500)/2, (height-500)/2);
    }
}
