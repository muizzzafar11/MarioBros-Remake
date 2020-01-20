//Taha M
//ICS4U1
//Summative
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jump here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jump extends PreciseMario
{
    GreenfootImage[] img;
    int frameCounter = 0, frame =0; //manages sprites and animation speed 
    int animationSpeed = 8;
    String ext = ".png";
    int direction = 0;
    int bigMariosizx = 12, bigMariosizy = 7; //scales sprite for big mario
    int smallMariosizx = 13, smallMariosizy = 10; //scales sprites for small mario
    
    public Jump(String folder, int firstFile, int lastFile, String key, double vx, double vy,int direction){
        super(key, vx, vy);
        BackGround1.scrollActor = this; //tells scroller to track this mario
        img = new GreenfootImage[(lastFile-firstFile)+1]; 
        if(isMarioBig()){
            extrafileletter = "b"; //changes sprite filenames to be put into array
        } 
        setupSprites(img, folder, firstFile); //puts sprites into array
        setImage(img[0]); //intial image
        this.direction = direction;
       
    }
    
    public void act() 
    {
        
        //Animation frame
            
           if(Math.abs(vx) > Math.abs(terminalvx)){ //stops accerlation after certain velocity
             accx = 0;
           } else {
             accx = originalaccx;
                
           }
           startAccelerating();
               
           updatePos();
           draw(frame);
           if(vy > 0){//changes frame if mario is falling
               frame = 1;
           }
           if(isTouching(Floor.class)){
               Actor obj = floorHitDetection();
               if(obj != null){ //resets position back up to ontop of ground
                   vy = 0;
                   double diff = 0;
                   diff = ObjectYOffset(obj); //difference that mario is clipped into the floor by
                   System.out.println("diff");
                   setLocation(getX(), getY()-diff); //offsets difference in y axis
               }
               
               if(otherKeyPressed()){ //removes mario 
                   getWorld().removeObject(this);
               } else {
                  if(direction > 0){ //creates new run idle animation when mario has hit the ground facing right
                    getWorld().addObject(new Run("mario/run_right/smw_", 0, 3, "right", 1, 0), (int)getX(), (int)getY());
                  } else{ //mario was jumping left so he should be facing left while on the ground 
                      System.out.println("ge");
                      getWorld().addObject(new Run("mario/run_left/smw_",0, 3, "left", -1, 0), (int)getX(), (int)getY());
  
                  }
                  getWorld().removeObject(this);
               }
           }
        
        
    }  
    
    public void draw(int frame){
        setImage(img[frame]);
    }
    
    protected void addedToWorld(World world){
        
        if(isMarioBig()){ //scales sprites based on if mario is big or small(stage 1 or stage 2)
            scaleSprites(img, bigMariosizx, bigMariosizy);
        } else {
            scaleSprites(img, smallMariosizx, smallMariosizy);
        }   
        
        //setLocation(getX(), getY() - 5);
    }
    
    
      
}
