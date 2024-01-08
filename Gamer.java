import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * How the gamer (main character) moves, punches and picks up power ups.
 * 
 * @author (Elle)
 * @version (a version number or a date)
 */

public class Gamer extends Actor {
    int count;
    int gamerhealth = 100; 
     
    // time player has to move away from enemy before health reduces again
    private final int PUNCH_TIMEOUT = 50;
    public int punchTimer = 0;
    private Boxing myworld;
    private HealthManager healthManager;    
    private EnemyStance enemy; 
    
    private boolean isPunching = false;
        
    public boolean isPunching() {
        return isPunching;
    }


    public Gamer() {
        setImage("gamer-removebg-preview (1).png");
    }

    public void act() {
        handleMovement();
        handlePunch();
        handlePowerUp();
        if (enemy.isPunching()) {
            hitbyEnemy();
        }
    }
    
    
    @Override
    protected void addedToWorld(World world) { 
        // get all the base stuff done first.
        super.addedToWorld(world);  
        myworld = (Boxing)world;

        healthManager = myworld.getHealthManager();
        enemy = myworld.getEnemy();
    }
    

    private void handleMovement() {
        if (Greenfoot.isKeyDown("left")) {
            move(-3);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(3);
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 3);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 3);
        }
    }

     private void handlePunch() {
        if (Greenfoot.isKeyDown("space")) {
            setImage("gamer2-removebg-preview (1).png");
            isPunching = true;
        } else {
            setImage("gamer-removebg-preview (1).png");
            isPunching = false;
        }
    }

    private void gamerPunch() {
        if (Greenfoot.isKeyDown("space")) {
            setImage("gamerPunch");
        } else {
            setImage("gamer.png");
        }
    }
    
    public void loseHealth()
    {
        gamerhealth--;
    }
    
    
    public void hitbyEnemy(){
        
        // enemy is overlapping with gamer
        Actor enemy = getOneIntersectingObject(EnemyStance.class);
        if (enemy != null) {
            if (punchTimer == 0) {
              
                healthManager.decreaseGamerHealth();           
                
                // reset timer
                punchTimer = PUNCH_TIMEOUT;
            } else {
                // decrease timer by 1
                punchTimer--;
            }
        } else {
            punchTimer = PUNCH_TIMEOUT;
        }
    }

    public void gainHealth()
    {
        gamerhealth++;
    }
    
    public void handlePowerUp() {
        PowerUps powerUp = (PowerUps) getOneIntersectingObject(PowerUps.class);
        if (powerUp != null) {
            if (powerUp.healthBoost > 0) {
                //get powerUp.healthBoost //and increase healthbar by the amount
                healthManager.increaseGamerHealth();
                
                // remove object after picked up
                getWorld().removeObject( powerUp ); 
            }
        }
        
    }
}
    
    
