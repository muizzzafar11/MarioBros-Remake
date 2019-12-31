
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Run here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Run extends Mario
{
    /**
     * Act - do whatever the Run wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] img;
    int frameCounter = 0, frame =0; //manages sprites and animation speed 
    int animationSpeed = 8;
    String key = "";
    int px, py, vx, vy; 
    String ext = ".png";
    int speed;
    
    public Run(String folder, int firstFile, int lastFile, String key, int movementSpeed){
        super(key);
        img = new GreenfootImage[(lastFile-firstFile)+1];
        for(int i = 0; i < img.length; i++){
            img[i] = new GreenfootImage(folder + (firstFile+i) + ext);
        }
        setImage(img[0]);
        this.speed  = movementSpeed;
        vx = 0; 
        vy = 5;
    }
    
    public void act() 
    {
        //UPDATE
            //Player position
            px += vx;
            py += vy;
            //Animation frame
            frameCounter++;
            if(frameCounter % animationSpeed == 0){ 
                frameCounter = 0;
                frame++;
                if(frame > img.length-1){ 
                    frame = 0;
                }
            }
            
        
        
        //CHECK
            //Floor hitdetect
            if(super.floorHitDetection() != null){ 
                Actor obj = super.floorHitDetection();
               // System.out.println(getY() + " + " + getImage().getHeight()/2 + "-" + obj.getY() + "-" + obj.getImage().getHeight()/2);
                int difference = (getY()+getImage().getHeight()/2) - (obj.getY() - obj.getImage().getHeight()/2);
                System.out.println((getX() + getImage().getWidth()/2) + " " + (obj.getX() - obj.getImage().getWidth()/2) );
                py -= difference;
                py -= vy;
            }
            //System.out.println(getImage().getHeight());
            
        //DRAW
            //draws sprites
            if(super.otherKeyPressed(px, py)){ 
                getWorld().removeObject(this);
            } else if(Greenfoot.isKeyDown(super.key)){
                draw(frame);
                vx = speed;
            } else {
                draw(0);
                vx = 0;
                frame = 0;
            }  
            setLocation(px, py);
           // System.out.println(getY());
        
    }  
    
    public void draw(int frame){
        setImage(img[frame]);
    }
    
    
    protected void addedToWorld(World world){
        this.px = getX(); 
        this.py = getY();
        for(int i = 0; i < img.length; i++){
            img[i].scale(getWorld().getHeight()/10, getWorld().getHeight()/10);

        }
    }
}
