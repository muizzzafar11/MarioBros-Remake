import greenfoot.*;
public class DK extends Actor
{
    private long lastTime;
    //Mario mario = new Mario();
    public DK(){
        // scaling the size of the image
        GreenfootImage dkImage = getImage();
        dkImage.scale(200, 300);
        setImage(dkImage);
    }
    public void act() 
    {
        if(isTouching(PreciseMario.class))
        {
            Greenfoot.setWorld(new Finish("You Won"));
            Greenfoot.stop();
        }
        if(System.currentTimeMillis() - lastTime > 2500) //adds barrels
        {
            lastTime = System.currentTimeMillis();
            getWorld().addObject(new Barrel(), getX(), getY());
        }
    }    
}
