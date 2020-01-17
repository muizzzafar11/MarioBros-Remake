import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sun extends Actor
{   private int frames = 1;
    private int animationCounter = 0;
    private GreenfootImage Sun [] = {new GreenfootImage("SunEnemie1.png"),
            new GreenfootImage("SunEnemie2.png")};
    public void act() 
    {
        animationCounter++;
        setLocation(getX() - 5, getY());
        if(animationCounter % 4 == 0){
            Animation(); 
        }
        if(getX() < -100){
            setLocation(BackGround1.width + 200, (Greenfoot.getRandomNumber(BackGround1.height)));
        }
    }

    public void Animation(){
        if(frames == 1){
            setImage(Sun[0]);   
        }

        if(frames == 2){           
            frames = 1;
            setImage(Sun[1]);
            return;
        }

        frames++;
    }
}
