import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(new BackGround1().width-100, new BackGround1().width-300, 1);
        prepare();
    }

    private void prepare(){
        showText("Press Enter to start", this.getWidth()/2+25, this.getHeight()/2+50); 
    }

    public void act(){
        if(Greenfoot.isKeyDown("enter")){
        Greenfoot.setWorld(new BackGround1());
        }

    }   
}
