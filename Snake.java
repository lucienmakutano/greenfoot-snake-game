import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author tadomikikuto
 * @version v1
 */
public class Snake extends Actor
{
    /**
     * @object
     */
    Actor baby;
    
    /**
     * @object
     */
    World world;
    
    /**
     * @var
     */
    private int level = 0;
    
    /**
     * @var
     */
    private int levelTracker = 0;
    
    /**
     * @var
     */
    private int eatenBabies = 0;
    
    /**
     * @var
     */
    private int speedLevel = 2;
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        this.moveAndTurn();
        
        this.baby = getOneObjectAtOffset(0, 0, Baby.class);
        if (this.isBaby(this.baby)) {
            this.eat();
            Greenfoot.playSound("eating.wav");
        }
        
        
    }
    
    private void eat() {
        this.world = getWorld();
        this.world.removeObject(this.baby);
        
        this.increaseNumberOfEatenBaby();
    }
    
    private void increaseLevel(){
        this.levelTracker++;
    }
    
    private void increaseSpeedLevel() {this.speedLevel++;}
    
    public int getLevel(){return this.level;}
    
    private boolean isBaby(Actor baby){ return baby != null;}
    
    private void increaseNumberOfEatenBaby(){ eatenBabies++;}
    
    public int getEatenBabies(){ return this.eatenBabies; }
    
    private void moveAndTurn() {
        move(this.speedLevel);
        
        if (Greenfoot.isKeyDown("left")) {
            turn(1);
        }
        else if(Greenfoot.isKeyDown("right")) {
            turn(-3);
        }
        else if(Greenfoot.isKeyDown("up")) {
            turn(-3);
        }
        else if(Greenfoot.isKeyDown("down")) {
            turn(1);
        }
    }
}
