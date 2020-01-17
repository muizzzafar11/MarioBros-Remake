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
    double terminalVel = 3;
    
    public Jump(String folder, int firstFile, int lastFile, String key, double vx, double vy){
        super(key, vx, vy);
        img = new GreenfootImage[(lastFile-firstFile)+1];
        for(int i = 0; i < img.length; i++){
            img[i] = new GreenfootImage(folder + (firstFile+i) + ext);
        }
        setImage(img[0]);
       
    }
    
    public void act() 
    {
        
        //Animation frame
            
            if(!Greenfoot.isKeyDown(key)){
               accx = 0;
               
               frame= 0;
               
               if(originalvx > 0 && vx < 0){
                decx = 0;
                vx = 0.001;
                } else if(originalvx < 0 && vx > 0){
                decx = 0;
                vx = 0.001;
                } else{
                  decx = originaldecx;
                  stopAccelerating();
                }
           } else {
                if(Math.abs(vx) > Math.abs(terminalvx)){
                   accx = 0;
               } else {
               accx = originalaccx;
                
               }
               startAccelerating();
               
               
           }
           updatePos();
           if(isTouching(Floor.class)){
           
               if(otherKeyPressed()){
                   getWorld().removeObject(this);
               } else {
                  if(originalvx > 0.0){
                    getWorld().addObject(new Run("mario/run_right/smw_", 0, 1, "right", 1, 0), (int)getX(), (int)getY());
                  } else{
                      getWorld().addObject(new Run("mario/run_left/smw_",3, 4, "left", -1, 0), (int)getX(), (int)getY());
  
                  }
                  getWorld().removeObject(this);
               }
           }
        if(isTouching(Floor.class)){
               Actor obj = floorHitDetection();
               if(obj != null){
                   vy = 0;
                   double diff = 0;
                   diff = ObjectYOffset(obj);
                   setLocation(getX(), getY()-diff);
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
        super.px = getX();
        super.py = getY();
        for(int i = 0; i < img.length; i++){
            img[i].scale(getWorld().getHeight()/15, getWorld().getHeight()/15);

        }
        setLocation(getX(), getY() - 5);
    }
      
}
