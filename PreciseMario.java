import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class PreciseMario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PreciseMario extends SmoothMover
{
    /**
     * Act - do whatever the PreciseMario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public double gravity = 2.0;
    protected double originalvx, originalvy, originalaccx, originaldecx;
    protected double px, py, vx, vy, terminalvx;
    protected double accx;
    protected double decx;
    
    int Lives = 3;
    int height, width;
    
    String key = "";
    String[] possibleKeys = {"left", "right", "up"};
    
    
    public PreciseMario(String key, double vx, double vy){
       this.key = key;
       originalvx = vx;
       originalvy = vy;
       this.vx = vx;
       this.vy = vy;
       if(originalvx < 0){
           decx = 0.5;
           accx = -0.1;
       }else if(originalvx > 0) {
           decx = -0.5;
           accx = 0.1;
       }
       originalaccx = accx;
       originaldecx = decx;
       terminalvx = 5;
       
    }
    
    public void updatePos(){
       
        setLocation(getX()+vx, getY()+vy);
        
        //System.out.println(gravity);
        vy = vy + gravity;
        //System.out.println(vx);
        //System.out.println(vy);
        
    }
    
    public void startAccelerating(){
        vx += accx;
        //System.out.println(vx + " " + accx + " " +decx );
    }
    
    public void stopAccelerating(){
        vx += decx;
                //System.out.println(originalvx + " " + vx + " " + accx + " " +decx );

    }
    
    public void changeVel(double vx, double vy){
        this.vx = vx;
        this.vy = vy;
    }
  
    protected void addedToWorld(World world){
       height = getWorld().getHeight();
       width = getWorld().getWidth();
       
    }
    
    public double ObjectYOffset(Actor obj){
        double topYdiff = (getY()+getImage().getHeight()/2) - (obj.getY() - obj.getImage().getHeight()/2);
        double bottomYdiff = (getY()-getImage().getHeight()/2) - (obj.getY() + obj.getImage().getHeight()/2);
        
        if(Math.abs(topYdiff) < Math.abs(bottomYdiff)){
            return topYdiff;
        } else {
            return bottomYdiff;
        }
        
       
        
       //return topYdiff;
    }
    
    public double ObjectXOffset(Actor obj){
        double rightXdiff = (getX()+getImage().getWidth()/2) - (obj.getX() - obj.getImage().getWidth()/2);
        double leftXdiff = (getX()-getImage().getWidth()/2) - (obj.getX() + obj.getImage().getWidth()/2);
        
        if(Math.abs(rightXdiff) < Math.abs(leftXdiff)){
            return rightXdiff;
        } else {
            return leftXdiff;
        }
    }
    
    public Actor floorHitDetection(){
        Actor object  = getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2, Floor.class);
        /*
        int size = getImage().getHeight();
        int radius = (int)Math.abs(vy) + size;
        geto
        List<Floor> list = getObjectsInRange(radius, Floor.class);
        System.out.println(radius);
        double lowestDiff = 100000;
        Actor closestObj = null;
        for(Actor obj : list){
            double tempDiff = ObjectYOffset(obj);
            System.out.println(tempDiff);
            if(Math.abs(tempDiff) < Math.abs(lowestDiff)){
                closestObj = obj;
            }
        }
        if(lowestDiff > 0){
                        //closestObj.setImage("brick.jpg");
            System.out.println("hitdetect");
            return closestObj;
        }
        return null;
        */
       return object;
    }
    
    public boolean otherKeyPressed(){
       
            int index = -1;
            for(int i = 0; i < possibleKeys.length; i++){
                if(Greenfoot.isKeyDown(possibleKeys[i]) && possibleKeys[i] != key){
                    if(!(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right"))){
                        index = i;
                        break;
                    }
                }
            }
            switch(index){
            
                case 0:
                    if(Greenfoot.isKeyDown("up")){
                        getWorld().addObject(new Jump("mario/jump_left/smw_",10, 11, "up", -3, -30, -1), (int)getX(), (int)getY());

                    } else {
                    getWorld().addObject(new Run("mario/run_left/smw_",3, 4, "left", -1, 0), (int)getX(), (int)getY());
                    
                    }
                    break;
                case 1:
                    if(Greenfoot.isKeyDown("up")){
                        getWorld().addObject(new Jump("mario/jump_right/smw_",10, 11, "up", 3, -30, 1), (int)getX(), (int)getY());

                    } else {
                    getWorld().addObject(new Run("mario/run_right/smw_", 0, 1, "right", 1, 0), (int)getX(), (int)getY());
                    
                    }
                    break;
                case 2: 
                    if(originalvx > 0){
                        double newVx;
                        if(Greenfoot.isKeyDown("right")){
                            newVx = 3;
                        }else{
                            newVx = 0.0;
                        }
                        getWorld().addObject(new Jump("mario/jump_right/smw_",10, 11, "up", newVx, -30, 1), (int)getX(), (int)getY());
                        
                    } else {
                        double newVx;
                        if(Greenfoot.isKeyDown("left")){
                            newVx = -3;
                        }else{
                            newVx = 0.0;
                        }
                        getWorld().addObject(new Jump("mario/jump_left/smw_",10, 11, "up", newVx, -30, -1), (int)getX(), (int)getY());
                        
                    }
                
                    break;
                case 3: 
                    
                
                    break;
                
            }
            if(index != -1){
                return true;
            }
            /*
            if(key.equals("up")){
               if(originalvx < 0){
                        getWorld().addObject(new Run("mario/run_left/mario_",3, 6, "left", -1, 0), (int)px, (int)py);
                    } else {
                        getWorld().addObject(new Run("mario/run_right/mario_",0, 3, "right", 1, 0), (int)px, (int)py);
                    
                    } 
            }
            */
        return false;
    }
    
}
