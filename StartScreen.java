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
        super(800, 600, 1);
        prepare();
    }

    private void prepare(){
        TitleWords titlewords = new TitleWords();
        TitleEnter titleEnter = new TitleEnter();
        addObject(titlewords, 400, 300);
        addObject(titleEnter, 400, 480);
    }

    public void act(){
        if(Greenfoot.isKeyDown("enter")){
        Greenfoot.setWorld(new BackGround1());
        }

    }   
}
