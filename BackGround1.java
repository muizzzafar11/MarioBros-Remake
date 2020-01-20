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
    private int random;
    private int score = 0; 
    
    //private int backHeight, backWidth;
    public BackGround1()
    {    // Scales the size of the screen
        super(width, height, 1, false);
        GreenfootImage backImage = new GreenfootImage("back.png");
        scroller = new Scroller(this, backImage, worldLength, height);
        scrollActor = new Mario();
        addObject(scrollActor, 20, (height-60));
        addObject(new DK(), 4500 , (height-60));
        addObject(new Goomba(), 450 , (height-54));
        addObject(new Turtle(), 3250 , (height-54));
        for(int i = 0; i < worldLength; i += 1000)// This is for the secondary floor, change after += to change the distance. 
            addObject(new Floor(), i, height-20);
        int j = height-110;
        for(int i = 400; i < worldLength; i+=900){
            addObject(new Mountains2(),i+70,j-15);
            addObject(new Mountains(), i , j);
            addObject(new Mountains(), i+120,j);
        }
    }

    public void act() {
        scroll();
        random = Greenfoot.getRandomNumber(200);
        if(random == 2) {
            addObject(new Coins(),scrollActor.getX() + 800 ,(height/2)-20);
        }  
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
