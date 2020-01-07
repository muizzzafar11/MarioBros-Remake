import greenfoot.*;

/**
 * Write a description of class Barrel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{   
    private int frames = 1;
    private int animationCounter = 0;
    private GreenfootImage Barrel1 = new GreenfootImage("BarrelAni1.png");
    private GreenfootImage Barrel2 = new GreenfootImage("BarrelAni2.png");
    private GreenfootImage Barrel3 = new GreenfootImage("BarrelAni3.png");
    private GreenfootImage Barrel4 = new GreenfootImage("BarrelAni4.png");
    
    public void act() 
    {   animationCounter++;
        
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        } else{
          if(animationCounter%4 == 0){
            Animation();
        }
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor2.class))
          {
            setLocation(getX() - 3, getY() - 3);
            
          }
          while(isTouching(Floor.class))
          {
            setLocation(getX() + 3, getY() - 3);
            
          }
       }
    }
    public void Animation(){
        if(frames == 1){
            setImage(Barrel1);
        }
        
        if(frames == 2){
            setImage(Barrel2);
        }
        
        if(frames == 3){
            setImage(Barrel3);
        }
        
        if(frames == 4){
            setImage(Barrel4);
            frames = 1;
            return;
        }
        
        frames ++;
    }
}
    
 