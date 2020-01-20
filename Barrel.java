import greenfoot.*;

public class Barrel extends Actor

{   
    private int frames = 1;
    private int animationCounter = 0;
    //setting images for barrels
    private GreenfootImage Barrel1 = new GreenfootImage("BarrelAni1.png");
    private GreenfootImage Barrel2 = new GreenfootImage("BarrelAni2.png");
    private GreenfootImage Barrel3 = new GreenfootImage("BarrelAni3.png");
    private GreenfootImage Barrel4 = new GreenfootImage("BarrelAni4.png");
    private int barreltoBackWide = ((BackGround1.width)-100)/20;
    private int barreltoBackHigh = ((BackGround1.height)-100)/15;
    //Mario mario = new Mario();
     public Barrel () { //scaling images
        Barrel1.scale(barreltoBackWide, barreltoBackHigh);
        setImage(Barrel1);
        Barrel2.scale(barreltoBackWide, barreltoBackHigh);
        setImage(Barrel2);
        Barrel3.scale(barreltoBackWide, barreltoBackHigh);
        setImage(Barrel3);
        Barrel4.scale(barreltoBackWide, barreltoBackHigh);
        setImage(Barrel4);
    }
    public void act() 
    {   
        animationCounter++;
        if(getX() <= 0) //removes object when offscreen
        {
            getWorld().removeObject(this);
        } else{
          if(animationCounter%4 == 0){ //changes frames
            Animation();
        }
          setLocation(getX(), getY() + 3);
          while(isTouching(Floor.class)) //stops barrels from falling through
          {
            setLocation(getX() - 3, getY() - 3);
            
          }
          if(isTouching(Run.class)) {
            getWorld().removeObject(this);
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
    
 
