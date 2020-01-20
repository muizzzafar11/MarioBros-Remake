import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class BackGround1 extends World
{
    // TODO: set all of the standards according to the height of the screen
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-200); 
    public static int height = (int)(screenSize.getHeight()/1.4);

    //private static int floorDist = 75;
    private Scroller scroller;
    private Actor scrollActor;
    private int worldLength = 5000;
    private int score = 0; 
    //private int backHeight, backWidth;
    public BackGround1() {    // Scales the size of the screen
        super(width, height, 1, false);
        GreenfootImage backImage = new GreenfootImage("back.png");
        scroller = new Scroller(this, backImage, worldLength, height);
        scrollActor = new Mario();
        
        
        // Adding actor
        addObject(scrollActor, 20, (height-60));
        addObject(new DK(), 4500 , (height-100));
        addObject(new Goomba(), 450 , (height-54));
        addObject(new Turtle(), 3250 , (height-54));
        addObject(new itembox("images/itembox/item_", 0, 4), 500 , (height-200));
        for(int i = 0; i <= worldLength; i += 200){// This is for the secondary floor, change after += to change the distance. 
            addObject(new Floor(), i, height-50);            
            addObject(new Coins(),Greenfoot.getRandomNumber(worldLength-50) 
            , Greenfoot.getRandomNumber(height-80));
        }
    }

    public void act() {
        scroll();    
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
