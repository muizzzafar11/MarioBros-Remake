import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class BackGround1 extends World
{
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-300); 
    public static int height = (int)(screenSize.getHeight()/1.25);

    //private static int floorDist = 75;
    private Scroller scroller;
    private Actor scrollActor;
    private int worldLength = 5000;
    private int random;
    //private int backHeight, backWidth;
    public BackGround1()
    {    // Scales the size of the screen
        super(width, height, 1, false);
        GreenfootImage backImage = new GreenfootImage("board.jpg");
        //backHeight = backImage.getHeight();
        //backWidth = backImage.getWidth();
        scroller = new Scroller(this, backImage, worldLength, height);
        scrollActor = new Mario();

        // Adding actor
        addObject(scrollActor, 20, (height-60));
        addObject(new DK(), 4500 , (height-60));
        addObject(new Goomba(), 450 , (height-54));
        addObject(new Turtle(), 3250 , (height-54));

        // for(int i = 0; i <= worldLength; i += 200)// This is for the basic floor 
            // addObject(new Floor2(), i, height-20);
        for(int i = 0; i <= worldLength; i += 200)// This is for the secondary floor, change after += to change the distance. 
            addObject(new Floor(), i, height-20);
        
        /*super(width, height, 1); 
        int mod = 2;
        addObject(new DK(), 100, (int)(height/9.75));

        for(int i = 100; i < height; i += floorDist) {
        if((mod % 2) == 0){
        for(int j = 0; j < width-100; j += 250) {
        addObject(new Floor(), j, i);
        }   
        }else{
        for(int k = width; k > 100; k -= 250) {
        addObject(new Floor2(), k, i);
        }
        }
        mod += 1;
        }
        // there is no floor between the distance of 75 then make a new floor otherwise bring the other floor down
        addObject(new Mario(), 125, (height-60));*/
    }

    public void act() {
        scroll();
        // to randomly generate the second floor
        // random = Greenfoot.getRandomNumber(500);
        // if(random == 0)
            // addObject(new Floor(),(scrollActor.getX() + 500) , height/2);
    }

    private void scroll () {
        if(scrollActor.getX() < 10) {
            scrollActor.setLocation(10, scrollActor.getY());
        }
        int dsx, dsy;
        dsx = scrollActor.getX()-500;
        dsy = 0;
        scroller.scroll(dsx, dsy);
    }
}
