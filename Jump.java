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
    int bigMariosizx = 12, bigMariosizy = 7; 
    int smallMariosizx = 13, smallMariosizy = 10;
    static Run run = new Run();
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
           if(vy > 0){
               frame = 1;
           }
           if(isTouching(Floor.class)){
               Actor obj = floorHitDetection();
               if(obj != null){ //resets position back up to ontop of ground
                   vy = 0;
                   double diff = 0;
                   diff = ObjectYOffset(obj);
                   System.out.println("diff");
                   setLocation(getX(), getY()-diff);
               }
               
               if(otherKeyPressed()){ //removes mario 
                   getWorld().removeObject(this);
               } else {
                  if(direction > 0){ //creates new run idle animation so mario isn't jumping on the ground
                    getWorld().addObject(new Run("mario/run_right/smw_", 0, 3, "right", 1, 0), (int)getX(), (int)getY());
                  } else{
                      System.out.println("ge");
                      getWorld().addObject(new Run("mario/run_left/smw_",0, 3, "left", -1, 0), (int)getX(), (int)getY());
  
                  }
                  getWorld().removeObject(this);
               }
           }
        
        
        
        
        // if (isTouching(Barrel.class)) {
            // run.Lives--;
        // } 
        // if (isTouching(Goomba.class)) {
            // run.Lives--;
        // }
        // if (isTouching(Turtle.class)) {
            // run.Lives--;
        // }
        // if (run.Lives <= 0) {
            // Greenfoot.setWorld(new Finish("You died"));
            // Greenfoot.stop();
        // }
        
        
        
        /*
        //if(vy < terminalVel){
          //  vy -= gravity;
        //}
        updatePos();
        
        if(floorHitDetection() != null){ 
                Actor obj = floorHitDetection();
                double difference = ObjectYOffset(obj);
                py -= difference;
                //py -= gravity;
                System.out.println(difference);
        } 
        
        //System.out.println(px + " " + py + " " + getX() + " " + getY());
        if(isTouching(Floor.class)){
                draw(1);
                Greenfoot.delay(5);
                changeVel(0,0);
                //getWorld().addObject(, _x_, _y_)
                otherKeyPressed();
                //System.out.println("hi");
                getWorld().removeObject(this);
            } else {
                draw(0);
                
            }
            setLocation(px, py);
            */
    }  
    
    public void draw(int frame){
        setImage(img[frame]);
    }
    
    protected void addedToWorld(World world){
        
        if(isMarioBig()){
            scaleSprites(img, bigMariosizx, bigMariosizy);
        } else {
            scaleSprites(img, smallMariosizx, smallMariosizy);
        }   
        
        //setLocation(getX(), getY() - 5);
    }
    
    
      
}
