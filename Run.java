import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Run here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Run extends PreciseMario
{
    /**
     * Act - do whatever the Run wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] img;
    int frameCounter = 0, frame =0; //manages sprites and animation speed 
    int animationSpeed = 6;
    String ext = ".png";
    int bigMariosizx = 13, bigMariosizy = 8;
    int smallMariosizx = 13, smallMariosizy = 12;
    
    public Run(String folder, int firstFile, int lastFile, String key,double vx,double vy){
        
        super(key, vx, vy);
        BackGround1.scrollActor = this;
        img = new GreenfootImage[(lastFile-firstFile)+1];
        if(isMarioBig()){
            System.out.println("b");
            super.extrafileletter = "b";
        }
        ///ScrollActor = this;
        setupSprites(img, folder, firstFile);
        setImage(img[0]);
        
    }
    
    public void act() 
    {
        
            //Animation frame
            frameCounter++;
            if(frameCounter % animationSpeed == 0){ //increments frame drawn
                frameCounter = 0;
                frame++;
                if(frame > img.length-1){  //resets frame drawn to first one
                    frame = 0;
                }
            }
            
            
        
        //CHECK
            //Floor hitdetect
            
            /*
             * if(floorHitDetection() != null){ 
                Actor obj = super.floorHitDetection();
               // System.out.println(getY() + " + " + getImage().getHeight()/2 + "-" + obj.getY() + "-" + obj.getImage().getHeight()/2);
                double difference = ObjectYOffset(obj);
                //System.out.println(difference);
                py -= difference; 
                py -= vy;
            }
            */
           //if(Math.abs(vx) > 4){
           //    accx = 0;
           // }
           //System.out.println(Greenfoot.isKeyDown(key) + " " + key);
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
                
                
                //System.out.println(vx);
               //ax = 0.8;
           } else {
               //vx = originalvx;
               if(Math.abs(vx) >= Math.abs(terminalvx)){
                   accx = 0;
                   System.out.println("termvx reached");
               } else {
               accx = originalaccx;
                
               }
               startAccelerating();
               
            }
                      updatePos();

           
           
           if(isTouching(Floor.class)){
               Actor obj = floorHitDetection();
               if(obj != null){
                   vy = 0;
                   double diff = 0;
                   diff = ObjectYOffset(obj);
                   setLocation(getX(), getY()-diff);
               }
           }
           
           draw(frame);
           
           if(otherKeyPressed()){
               getWorld().removeObject(this);
           }
           /*
            if(isTouching(Floor.class)){
                
                System.out.println(getY());
            //super.gravity = 0;
                //setLocation(getX(), getY()-(vy));
                Actor obj = floorHitDetection();
                double diff = 0;
                if(obj != null){
                    diff = ObjectYOffset(obj);
                }
                                setLocation(getX(), getY()-diff);

                //System.out.println("new " +getY());
            } else{
                           //setLocation(getX() + vx, getY() +vy); 

            }
        //DRAW
            //draws sprites
            if(otherKeyPressed()){ 
                getWorld().removeObject(this);
            } else if(Greenfoot.isKeyDown(key)){
                draw(frame);
                changeVel(originalvx, originalvy);
            } else {
                draw(0);
                
                changeVel(0, 0);
                
                frame = 0;
            }  
            //System.out.println(getExactX() + " " + getExactY());
            //setLocation(px, py);
            
            //System.out.println(getExactX() + " " + getExactY());
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
    }
 
}
