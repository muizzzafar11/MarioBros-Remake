

import greenfoot.*;
public class Mario extends Actor
{
    int speed;
    //String Marioimage = "mario/running_right/mario_00.png";
    long lastTime;
    int Lives = 3;
    int px, py, vx, vy;
    int height, width;
    String key = "";
    String[] possibleKeys = {"left", "right", "up"};
    
    
    public Mario(String key){
       this.key = key;
    }
  
    protected void addedToWorld(World world){
       height = getWorld().getHeight();
       width = getWorld().getWidth();
    }
    
    public Actor floorHitDetection(){
        Actor object  = getOneObjectAtOffset(getImage().getWidth()/2, getImage().getHeight()/2, Floor.class);
        /*
        if(object != null){
            return true;
        }
        */
        return object;
    }
    
    public boolean otherKeyPressed(int px, int py){
       
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
                    getWorld().addObject(new Run("mario/run_left/mario_",3, 6, "left", -1), px, py);
                    break;
                case 1:
                    getWorld().addObject(new Run("mario/run_right/mario_", 0, 3, "right", 1), px, py);
                    break;
                case 2: 
                
                    break;
                case 3: 
                
                    break;
                
            }
            if(index != -1){
                return true;
            }
            
        
        return false;
    }
    
}
