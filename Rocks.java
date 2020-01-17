import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Toolkit;
import java.awt.Dimension;

public class Rocks extends Actor
{
    private int movingDirection = -15;
    private int frames = 1;
    private GreenfootImage Rock [] = {new GreenfootImage("Rocks1.png"),
    new GreenfootImage("Rocks2.png"),new GreenfootImage("Rock3.png"),};
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    public void act() 
    {   Animation();
        setLocation(getX(), getY() - movingDirection);
        if(isTouching(Floor.class)){
            frames = 2;
            movingDirection = 3;
            
        }
        
        if(getY() <= (height-780)){
        movingDirection = -15;
        frames = 1;
        }
    }
    
    public void Animation(){
        if(frames == 1){
        setImage(Rock[2]);   
        }
        
        if(frames == 2){
        setImage(Rock[0]);    
        }
       
    }
}
