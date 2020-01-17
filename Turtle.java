import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Turtle extends Actor
{   private long lastTime; 
    private int movingDirection = -1;
    private int frames = 1;
    private int animationCounter = 0;
    
    private GreenfootImage Turtle [] = {new GreenfootImage("Turtle2.png"),
    new GreenfootImage("Turtle3.png"),new GreenfootImage("Turtle4.png"),
    new GreenfootImage("Turtle5.png")};
    
    public void act() 
    {   animationCounter++;
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
        }else{

            if(movingDirection == -1 && animationCounter% 14 == 0){
                Animation2();  

            }

            if(movingDirection == 1 && animationCounter% 14 == 0){
                Animation();  
            }

            if(getX() < 200)
            {
                movingDirection = 1;
            } 
            if(getX() > 600)
            {   
                movingDirection = -1;
            }
            setLocation(getX(), getY() + 1);
            while(isTouching(Floor2.class))
            { 
                setLocation(getX() + (movingDirection), getY() - 1);

            }
            while(isTouching(Floor.class))
            {
                setLocation(getX() - (movingDirection), getY() - 1);

            }

        }
    } 

    public void Animation(){
        if(frames == 1){
            setImage(Turtle[0]);
        }

        if(frames == 2){
            setImage(Turtle[1]);
            frames = 1;
            return;
        }

        frames ++;
    }

    public void Animation2(){
        if(frames == 1){
            setImage(Turtle[2]);
        }

        if(frames == 2){
            setImage(Turtle[3]);
            frames = 1;
            return;
        }

        frames ++;
    }

}

