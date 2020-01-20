//Taha M
//ICS4U1
//Summative

import greenfoot.*;  

public class itembox extends Actor
{

    GreenfootImage[] img; 
    int frameCounter = 0, frame =0; //manages sprites and animation speed 
    int animationSpeed = 6; //determines rate sprites change at
    String ext = ".png";
    boolean hit = false; //true if mario has jumped into the block
    
    public itembox(String folder, int firstFile, int lastFile){
        img = new GreenfootImage[(lastFile-firstFile)+1]; //intializes sprite array
        for(int i = 0; i < img.length; i++){ //adds sprites
            img[i] = new GreenfootImage(folder + (firstFile+i) + ext);
        }
        setImage(img[0]); //sets first image
        
    }
    
    public void act() 
    {
        if(isTouching(PreciseMario.class)) {
            new Coins().coins += 5;
        }
        if(!hit){
        frameCounter++;
            if(frameCounter % animationSpeed == 0){ //increments frame drawn
                frameCounter = 0;
                frame++;
                if(frame > img.length-2){  //resets frame drawn to first one
                    frame = 0;
                }
            }
            draw(frame);
       }else{
           draw(4); //draws image that shows block is hit
       }
       
       if(isTouching(PreciseMario.class)){
           hit = true;
           //getWorld().removeObject(this);
       }
    }
    
    public void draw(int frame){
        setImage(img[frame]);
    }
    
    protected void addedToWorld(World world){
        for(int i = 0; i < img.length; i++){ //scales images according to height
            img[i].scale(getWorld().getHeight()/15, getWorld().getHeight()/15);

        }
    }
    
}
