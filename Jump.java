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
    
    public Jump(String folder, int firstFile, int lastFile, String key, double vx, double vy,int direction){
        super(key, vx, vy);
        BackGround1.scrollActor = this;
        img = new GreenfootImage[(lastFile-firstFile)+1];
        if(isMarioBig()){
            extrafileletter = "b";
        } 
        setupSprites(img, folder, firstFile);
        setImage(img[0]);
        this.direction = direction;
       
    }
    
    public void act() 
    {
        
        //Animation frame
            
               if(Math.abs(vx) > Math.abs(terminalvx)){
                   accx = 0;
               } else {
                   accx = originalaccx;
                
               }
               startAccelerating();
               //System.out.println(vx + " " + accx);
               
               
           /* 
            if(!Greenfoot.isKeyDown(key)){
               accx = 0;
               
               frame= 0;
               
               
           } else {
                if(Math.abs(vx) > Math.abs(terminalvx)){
                   accx = 0;
               } else {
               accx = originalaccx;
                
               }
               startAccelerating();
               
               
           }
           */
           updatePos();
           draw(frame);
           if(vy > 0){
               frame = 1;
           }
           if(isTouching(Floor.class)){
               System.out.println("hit");
               Actor obj = floorHitDetection();
               if(obj != null){
                   vy = 0;
                   double diff = 0;
                   diff = ObjectYOffset(obj);
                   System.out.println("diff");
                   setLocation(getX(), getY()-diff);
               }
               //vy = 1;
               if(otherKeyPressed()){
                   getWorld().removeObject(this);
               } else {
                  if(direction > 0){
                    getWorld().addObject(new Run("mario/run_right/smw_", 0, 3, "right", 1, 0), (int)getX(), (int)getY());
                  } else{
                      System.out.println("ge");
                      getWorld().addObject(new Run("mario/run_left/smw_",0, 3, "left", -1, 0), (int)getX(), (int)getY());
  
                  }
                  getWorld().removeObject(this);
               }
           }
        
        
        
        
        
        
        
        
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
