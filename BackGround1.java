import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;
/**
 * Write a description of class BackGround1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackGround1 extends World
{
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets resolution of current display
    public static int width = (int)screenSize.getWidth(); 
    public static int height = (int)screenSize.getHeight();
    /**
     * Constructor for objects of class BackGround1.
     * 
     */
    public BackGround1()
    {    
        super((int)(screenSize.getWidth()/2.5), (int)(screenSize.getHeight()/1.25), 1); //scales the size of the screen       
        addObject(new DK(), 200, 150);
        addObject(new Floor(), 125, 219);
        addObject(new Floor(), 375, 219);
        addObject(new Floor(), 625, 219);
        addObject(new Floor(), 875, 219);
        addObject(new Floor2(), 625, 500);
        addObject(new Floor2(), 875, 500);
        addObject(new Floor2(), 1125, 500);
        addObject(new Floor2(), 1375, 500);
        addObject(new Floor(), 125, 781);
        addObject(new Floor(), 375, 781);
        addObject(new Floor(), 625, 781);
        addObject(new Floor(), 875, 781);
        addObject(new Floor2(), 125, 1000);
        addObject(new Floor2(), 375, 1000);
        addObject(new Floor2(), 625, 1000);
        addObject(new Floor2(), 875, 1000);
        addObject(new Floor2(), 1125, 1000);
        addObject(new Floor2(), 1375, 1000);
        addObject(new Mario(), 125, 940);
    }
}
