import greenfoot.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class BackGround1 extends World
{
    // Gets resolution of current display
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
    public static int width = (int)(screenSize.getWidth()-500); 
    public static int height = (int)(screenSize.getHeight()/1.25);
    
    private static int floorDist = 75;
    public BackGround1()
    {    
        // Scales the size of the screen
        super(width, height, 1); 
        int mod = 2;
        addObject(new DK(), 100, (int)(height/9.75));
        
        for(int i = 100; i < height; i += floorDist) {
            if((mod % 2) == 0){
                for(int j = 0; j < width-30; j += 250) {
                    addObject(new Floor(), j, i);
                }   
            }else{
                for(int k = width; k > 30; k -= 250) {
                    addObject(new Floor2(), k, i);
                }
            }
            mod += 1;
        }
        // Make a floor at the bottom of the screen upon which mario will be standing
        addObject(new Mario(), 125, (height-60));
    }
}
