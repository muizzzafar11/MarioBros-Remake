//Taha M
//ICS4U1
//Summative

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Run here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Run extends PreciseMario {
    /**
     * Act - do whatever the Run wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] img;
    int frameCounter = 0, frame = 0; // manages sprites and animation speed
    int animationSpeed = 6;
    String ext = ".png";
    int bigMariosizx = 13, bigMariosizy = 8; //sizes for big sprite mario
    int smallMariosizx = 13, smallMariosizy = 12; //sizes for scaling small sprite mario
    

    public Run(String folder, int firstFile, int lastFile, String key, double vx, double vy) {

        super(key, vx, vy);
        BackGround1.scrollActor = this; // scroller tracks this
        img = new GreenfootImage[(lastFile - firstFile) + 1];
        if (isMarioBig()) { //imports big sprites instead
            
            super.extrafileletter = "b"; //this changes the name of the files to be imported into the array
        }
        
        setupSprites(img, folder, firstFile);
        setImage(img[0]); //inital image
        

    }


    public void act() {

        // Animation frame
        frameCounter++;
        if (frameCounter % animationSpeed == 0) { // increments frame drawn
            frameCounter = 0;
            frame++;
            if (frame > img.length - 1) { // resets frame drawn to first one
                frame = 0;
            }
        }

        if (!Greenfoot.isKeyDown(key)) { // start accerlating if key is pushed
            accx = 0;

            frame = 0;

            if (originalvx > 0 && vx < 0) { // stops deceleration if vx is 0 and mario is facing right
                decx = 0;
                vx = 0.001;
            } else if (originalvx < 0 && vx > 0) { // stops deceleration if vx is 0 and mario is facing left
                decx = 0;
                vx = 0.001;
            } else { // start decelerating
                decx = originaldecx;
                stopAccelerating();
            }

        } else {
            // vx = originalvx;
            if (Math.abs(vx) >= Math.abs(terminalvx)) { // stop from running too fast
                accx = 0;
                System.out.println("termvx reached");
            } else {
                accx = originalaccx; //keep accelerating

            }
            startAccelerating();

        }
        updatePos();

        if (isTouching(Floor.class)) { // moves mario back up to floor
            Actor obj = floorHitDetection();
            if (obj != null) {
                vy = 0;
                double diff = 0;
                diff = ObjectYOffset(obj); //finds how much mario is clipped into the floor by
                setLocation(getX(), getY() - diff); //offsets that difference
            }
        }

        draw(frame);

        
        if (isTouching(Barrel.class)) {
            Lives--;
        } 
        if (isTouching(Goomba.class)) {
            Lives--;
        }
        if (isTouching(Turtle.class)) {
            Lives--;
        }
        if (Lives <= 0) {
            Greenfoot.setWorld(new Finish("You died"));
            Greenfoot.stop();
        }
        if (otherKeyPressed()) {
            getWorld().removeObject(this);
        }
    }

    public void draw(int frame) {
        setImage(img[frame]);
    }

    protected void addedToWorld(World world) { //scales sprites if it big or small mario 
        if (isMarioBig()) {
            scaleSprites(img, bigMariosizx, bigMariosizy);
        } else {
            scaleSprites(img, smallMariosizx, smallMariosizy);
        }
    }

}
