import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class BackGround1 extends World
{
    // TODO: set all of the standards according to the height of the screen
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    // setting the height and width of screen
    public static int width = (int)(screenSize.getWidth()/1.5); 
    public static int height = (int)(screenSize.getHeight()/1.25);

    //private static int floorDist = 75;
    private Scroller scroller;
    public static Actor scrollActor;
    private int worldLength = 5000;
    private int score = 0; 
    int mod = 1;
    //private int backHeight, backWidth;
    public BackGround1() {    // Scales the size of the screen
        super(width, height-50, 1, false);
        // setting the image and initializing other stuff
        GreenfootImage backImage = new GreenfootImage("back.png");
        scroller = new Scroller(this, backImage, worldLength, height);
        
        // adding enemies, flag and mario
        
        addObject(new DK(), 4950  , (height-250));
        addObject(new Goomba(), 450 , (height-54));
        addObject(new Turtle(), 3250 , (height-54));
        scrollActor = new Run("mario/run_right/smw_",0,3,"right", 1, 0);
        addObject(scrollActor, 20, (height-60));
        //addObject(new Run("mario/run_right/smw_",0,1,"right", 1, 0), 500, 400);
        // for(int i = 0; i < worldLength; i += 1000)// This is for the secondary floor, change after += to change the distance. 
        // addObject(new Floor(), i, height-20);
        int j = height-110;
        for(int i = 400; i < worldLength; i+=750){
            // Adding mountains 
            if(mod % 3 == 0){
                addObject(new Mountains2(),i+150,j-40);
                addObject(new Mountains(), i , j-20);
                addObject(new Mountains(), i+300,j-20);
            }
            // randomly adding item box, mod 5 decreases the number of item boxes
            if(mod%5 == 0){
                addObject(new itembox("images/itembox/item_", 0, 4), Greenfoot.getRandomNumber(worldLength-50)
                , Greenfoot.getRandomNumber(height-80));
            }
            addObject(new Floor(), i, height-50); 
            // randomly adding coins
            addObject(new Coins(),Greenfoot.getRandomNumber(worldLength-50) 
            , Greenfoot.getRandomNumber(height-80));
            mod ++;
        }
    }
    static Run mover = new Run();
        public void act() {
        scroll();  
        showText("Score: "+new Coins().textDisp(), 40, 20);
        showText("Lives:"+mover.Lives, 40, 40);
    }
    // the scroller class
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
