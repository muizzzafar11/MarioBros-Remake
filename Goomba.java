import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Goomba extends Actor
{   private int movingDirection = -1;
    private int frames = 1;
    private int animationCounter = 0;
    
    private GreenfootImage Goomba [] = {new GreenfootImage("Enemies0.png"),
    new GreenfootImage("Enemies1.png"),new GreenfootImage("Enemies2.png"),
    new GreenfootImage("Enemies3.png")};

    public void act() 
    {   
        if(getX() <= 0)
        {
            getWorld().removeObject(this);
        }else {

            animationCounter++;
            if(movingDirection == -1 && animationCounter% 14 == 0){
                Animation();  
                //}
            }

            if(movingDirection == 1 && animationCounter% 14 == 0){
                Animation2();  
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
            setImage(Goomba[0]);
        }

        if(frames == 2){
            setImage(Goomba[1]);
            frames = 1;
            return;
        }

        frames ++;
    }

    public void Animation2(){        
        if(frames == 1){
            setImage(Goomba[2]);
        }

        if(frames == 2){
            setImage(Goomba[3]);
            frames = 1;
            return;
        }
        frames ++;
    }
}
