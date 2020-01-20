import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class PreciseMario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PreciseMario extends SmoothMover
{
    /**
     * Act - do whatever the PreciseMario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public double gravity = 2.0;
    protected double originalvx, originalvy, originalaccx, originaldecx;
    protected double vx, vy, terminalvx;
    protected double accx;
    protected double decx;
    protected int stage = 2;
    static int Lives = 3;
    //static int Lives = 3;
    int height, width;
    
    String key = "";
    String[] possibleKeys = {"left", "right", "up"};
    String ext = ".png";
    String extrafileletter = "";
    
    public PreciseMario(String key, double vx, double vy){
       this.key = key;
       originalvx = vx;
       originalvy = vy;
       this.vx = vx;
       this.vy = vy;
       if(originalvx < 0){ //if mario is facing left
           decx = 0.5;
           accx = -0.1;
       }else if(originalvx > 0) { //if  mario is facing right
           decx = -0.5;
           accx = 0.1;
       }
       originalaccx = accx;
       originaldecx = decx;
       terminalvx = 10; //fastest mario can travel
      
    }
    
    public PreciseMario() {
    
    }
    //puts sprites in to array
    public void setupSprites(GreenfootImage[] img, String folder, int firstFile){
        for(int i = 0; i < img.length; i++){
            img[i] = new GreenfootImage(folder + (firstFile+i) +extrafileletter + ext);
        }
    }
    
    //scales sprites in array to sizes given
    public void scaleSprites(GreenfootImage[] img, int sizeX, int sizeY){
        for(int i = 0; i < img.length; i++){
            img[i].scale(getWorld().getHeight()/sizeX, getWorld().getHeight()/sizeY);

        }
    }
    
    public boolean isMarioBig(){
        if(stage == 2){
            return true;
        } else {
            return false;
        }
    }
    
    public void updatePos(){
       
        setLocation(getX()+vx, getY()+vy);
        vy = vy + gravity;
        
    }
    
    public void startAccelerating(){
        vx += accx;
        //System.out.println(vx + " " + accx + " " +decx );
    }
    
    public void stopAccelerating(){
        vx += decx;
                //System.out.println(originalvx + " " + vx + " " + accx + " " +decx );

    }
    
    protected void addedToWorld(World world){
       height = getWorld().getHeight();
       width = getWorld().getWidth();
       
    }
    
    //finds if mario is on top or bottom 
    public double ObjectYOffset(Actor obj){
        double topYdiff = (getY()+getImage().getHeight()/2) - (obj.getY() - obj.getImage().getHeight()/2);
        double bottomYdiff = (getY()-getImage().getHeight()/2) - (obj.getY() + obj.getImage().getHeight()/2);
        
        if(Math.abs(topYdiff) < Math.abs(bottomYdiff)){
            return topYdiff;
        } else {
            return bottomYdiff;
        }
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
    
    //returns obkect if mario is touching it 
    public Actor floorHitDetection(){
        Actor object  = getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2, Floor.class);
       return object;
    }
    
    
    public boolean otherKeyPressed(){ //adds mario object if new key is pressed
       
            int index = -1;
            for(int i = 0; i < possibleKeys.length; i++){
                if(Greenfoot.isKeyDown(possibleKeys[i]) && possibleKeys[i] != key){
                    if(!(Greenfoot.isKeyDown("left") && Greenfoot.isKeyDown("right"))){ //stops mario from moving right then left constantly
                        index = i;
                        break;
                    }
                }
            }
            switch(index){
            
                case 0:
                    if(Greenfoot.isKeyDown("up")){
                        getWorld().addObject(new Jump("mario/jump_left/smw_",0, 1, "up", -3, -30, -1), (int)getX(), (int)getY());

                    } else {
                    getWorld().addObject(new Run("mario/run_left/smw_",0, 3, "left", -1, 0), (int)getX(), (int)getY());
                    
                    }
                    break;
                case 1:
                    if(Greenfoot.isKeyDown("up")){
                        getWorld().addObject(new Jump("mario/jump_right/smw_",0, 1, "up", 3, -30, 1), (int)getX(), (int)getY());

                    } else {
                    getWorld().addObject(new Run("mario/run_right/smw_", 0, 3, "right", 1, 0), (int)getX(), (int)getY());
                    
                    }
                    break;
                case 2: 
                    if(originalvx > 0){
                        double newVx;
                        if(Greenfoot.isKeyDown("right")){ //jumps up then forward
                            newVx = vx;
                        }else{//just jumps up
                            newVx = 0.0;
                        }
                        getWorld().addObject(new Jump("mario/jump_right/smw_",0, 1, "up", newVx, -30, 1), (int)getX(), (int)getY());
                        
                    } else {
                        double newVx;
                        if(Greenfoot.isKeyDown("left")){ //jumps up then backward
                            newVx = vx;
                        }else{ //just jumps up
                            newVx = 0.0;
                        }
                        getWorld().addObject(new Jump("mario/jump_left/smw_",0, 1, "up", newVx, -30, -1), (int)getX(), (int)getY());
                        
                    }
                
                    break;
                case 3: 
                    
                
                    break;
                
            }
            if(index != -1){
                return true;
            }
        return false;
    }
    
    public void act() {
        // if(isTouching(Turtle.class)) {
            // Lives--;
        // }
        // if(isTouching(Barrel.class)) {
            // Lives--;
        // }   
        // if(isTouching(Goomba.class)) {
            // Lives--;
        // }
    }
    
}
