import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coins extends Actor
{   
    public static int coins = 0;
    public void act() 
    {
        if(isTouching(PreciseMario.class)) {
            getWorld().removeObject(this);
            coins++;
        }
    }    
    public int textDisp() {
       return coins; 
    }
}
