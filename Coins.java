import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Coins extends Actor
{   
    public static int coins = 0;
    public void act() 
    {
        // Removing the coin object and adding it 1 to the coin variable 
        if(isTouching(PreciseMario.class)) {
            getWorld().removeObject(this);
            coins++;
        }
    }    
    // method for returning coins 
    public int textDisp() {
       return coins; 
    }
}
