import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Turtle extends Actor
{   private long lastTime; 
    private int movingDirection = -1;
    private int frames = 1;
    private int animationCounter = 0;
    //setting required images
    private GreenfootImage Turtle1 = new GreenfootImage("Turtle2.png");
    private GreenfootImage Turtle2 = new GreenfootImage("Turtle3.png");
    private GreenfootImage Turtle3 = new GreenfootImage("Turtle4.png");
    private GreenfootImage Turtle4 = new GreenfootImage("Turtle5.png");
    public void act() 
    {   animationCounter++;
        if(getX() <= 0)//removed if offscreen
        {
            getWorld().removeObject(this);
        }
        else{
        if(movingDirection == -1 && animationCounter% 14 == 0){ //change frame if facing left
            Animation2();  

        }

        if(movingDirection == 1 && animationCounter% 14 == 0){//change frame if facing left
            Animation();  
        }


        if(getX() < 200)//change direction
        {
        movingDirection = 1;
        } 
        if(getX() > 600);//change direction
        {   
        movingDirection = -1;
        }
        setLocation(getX(), getY() + 1);
        while(isTouching(PreciseMario.class)==false && isTouching(Floor.class))
        { 
            setLocation(getX() + (movingDirection), getY() - 1);

        }

        while(isTouching(Floor.class)) //stops koopa from falling through
        {
            setLocation(getX() - (movingDirection), getY() - 1);

        }
        if(isTouching(PreciseMario.class))//removed if mario touches it
            getWorld().removeObject(this);
            
        }
    }

     
    public void Animation(){//set image based on frame
        if(frames == 1){
            setImage(Turtle1);
        }

        if(frames == 2){
            setImage(Turtle2);
            frames = 1;
            return;
        }

        frames ++;
    }

    public void Animation2(){
        if(frames == 1){
            setImage(Turtle3);
        }

        if(frames == 2){
            setImage(Turtle4);
            frames = 1;
            return;
        }

        frames ++;
    }

}

