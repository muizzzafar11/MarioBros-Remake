import greenfoot.*;

/**
 * Write a description of class BackGround1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.Toolkit;
import java.awt.Dimension;
public class BackGround1 extends World
{
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int width = (int)screenSize.getWidth();
    public static int height = (int)screenSize.getHeight();
    /**
     * Constructor for objects of class BackGround1.
     * 
     */
    public BackGround1()
    {    
        super((int)(screenSize.getWidth()/2.5), (int)(screenSize.getHeight()/1.25), 1);         
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
        addObject(new Run("mario/run_right/mario_",0,3,"right", 1), 500, 400);
    }
    
   
}
