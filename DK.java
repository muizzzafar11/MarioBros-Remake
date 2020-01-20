import greenfoot.*;
public class DK extends Actor
{
    private long lastTime;
    //Mario mario = new Mario();
    public DK(){
        GreenfootImage dkImage = getImage();
        dkImage.scale(100, 100);
        setImage(dkImage);
    }
    public void act() 
    {
        if(isTouching(PreciseMario.class))
        {
            //Greenfoot.setWorld(new Finish());

            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 2500)
        {
            lastTime = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
        }
    }    
}
