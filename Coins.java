import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coins extends Actor
{   
    private static int coins = 0;
    public void act() 
    {
        if(isTouching(Mario.class)) {
            getWorld().removeObject(this);
            coins++;
        }
    }    
}
