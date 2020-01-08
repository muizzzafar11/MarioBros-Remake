import greenfoot.*;
public class DK extends Actor
{
    private long lastTime;
    public DK(){
        GreenfootImage dkImage = getImage();
        dkImage.scale(dkImage.getWidth()-80, dkImage.getHeight()-80);
        setImage(dkImage);
    }
    public void act() 
    {
        if(isTouching(Mario.class))
        {
            Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 2500)
        {
            lastTime = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
        }
    }    
}
