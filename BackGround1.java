import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class BackGround1 extends World
{
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-300); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    
    private static int floorDist = 75;
    private Scroller scroller;
    private Actor scrollActor;
    private int backHeight, backWidth;
    public BackGround1()
    {    // Scales the size of the screen
        super(width, height, 1, false);
        GreenfootImage backImage = new GreenfootImage("board.jpg");
        backHeight = backImage.getHeight();
        backWidth = backImage.getWidth();
        scroller = new Scroller(this, backImage, backWidth+10000, backHeight);
        scrollActor = new Mario();
        // Adding actor
        addObject(scrollActor, 0, backHeight/2);
        for(int i = 0; i < 2000; i += 250)// this should be donkeykong. position
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
    }
    
    private void scroll () {
        if(scrollActor.getX() < 10) {
        scrollActor.setLocation(10, scrollActor.getY());
        }
        
        int dsx, dsy;
            dsx = scrollActor.getX() - 100;
            dsy = 0;
        scroller.scroll(dsx, dsy);
        
        /*int loX = -50;
        int hiX = backWidth-100;
        int loY = 50;
        int hiY = backHeight-50;
        // determine offsets and scroll
        int dsx = 0, dsy = 0;
        if (scrollActor.getX() < loX) dsx = scrollActor.getX();
        if (scrollActor.getX() > hiX) dsx = scrollActor.getX();
        if (scrollActor.getY() < loY) dsy = scrollActor.getY()-loY;
        if (scrollActor.getY() > hiY) dsy = scrollActor.getY()-hiY;
        scroller.scroll(dsx, dsy);*/
    }
}
