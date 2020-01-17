import greenfoot.*;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Mario extends Actor
{
    private int speed;
    private String Marioimage = "mariopixelCopy.png";
    private long lastTime;
    private int Lives = 1000;
    private GreenfootImage marioImage;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    
    public Mario() {
        marioImage = getImage();
        marioImage.scale(marioImage.getWidth()-20, marioImage.getHeight()-20);
        setImage(marioImage);
    }

    public void act() 
    {   
        speed = speed + 1;
        setLocation( getX(), getY() + speed);
        getWorld().showText("Lives : "+ Lives +"",1450, 50);
        
        if(isTouching(Rocks.class)){
            setLocation(2, height - 54);
            Lives = Lives - 1;
        }
        
        if(isTouching(Sun.class)){
            setLocation(2, height - 54);
            Lives = Lives - 1;
        }
        
        if(isTouching(Goomba.class))
        {   
            setLocation(2, height - 54);
          
            Lives = Lives - 1;
        }

        if(isTouching(Turtle.class))
        {  
            Lives = Lives - 1;
        }

        if(isTouching(Barrel.class))
        {   
            setLocation(2, height - 54);
            removeTouching(Barrel.class);
            Lives = Lives - 1;
        }

        if(Lives == 0)
        {
            getWorld().showText("GAME OVER", 750, 600);
            Greenfoot.stop();
        }
        if(speed > 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() - 1);
                if(Greenfoot.isKeyDown("up"))
                {
                    speed = - 27;
                }
            }
        }
        if(speed <= 0)
        {
            while(isTouching(Floor.class))
            {
                speed = 0;
                setLocation(getX(), getY() + 1);
            }
        }    
        if(Greenfoot.isKeyDown("left"))
        {
            move(-5);
            /*if(System.currentTimeMillis() - lastTime > 500 && Marioimage.equals("mariopixelCopy.png"))
            {
            Marioimage = "marioleft.png";
            setImage("marioleft.png");
            lastTime = System.currentTimeMillis();
            } else {
            if(System.currentTimeMillis() - lastTime > 500)
            {
            Marioimage = "mariopixelCopy.png";
            setImage("mariopixelCopy.png");
            lastTime = System.currentTimeMillis();
            }
            } */

            setImage(marioImage);
            while(isTouching(Floor.class))
            {
                move(1);
            } 
        } else {
            if(Greenfoot.isKeyDown("right"))
            {
                move(5);
                setImage(marioImage);
                while(isTouching(Floor.class))
                {
                    move(-1);
                }
            } else{
                setImage(marioImage);
            }
        }
        if(Greenfoot.isKeyDown("down"))
        {
            //speed = 50;
        }

    }
    
}
