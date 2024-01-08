import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * What controls the health to increase and decrease.
 * 
 * @author (Elle)
 * @version (a version number or a date)
 */


public class HealthManager extends Actor {
    
    private World world;
    
    private HealthBar enemyHealthBar = new HealthBar();
    private HealthBar gamerHealthBar = new HealthBar();
    
    private int enemyHealth= 100;
    private int gamerHealth = 100;
    
    public int getEnemyHealth(){
        return enemyHealth;
    }
    public int getGamerHealth(){
        return gamerHealth;
    }
    
    public HealthManager(World world) {
        this.world = world;
        //
        initalize();
    }
    
    
    public void initalize() {
        world.addObject(enemyHealthBar, 925, 10);
        world.addObject(gamerHealthBar, 75, 10);
    }
    
    public void increaseGamerHealth() {
        gamerHealth+=3;
        gamerHealthBar.setHealth(gamerHealth);
    }
    
    public void decreaseEnemyhealth() {
        enemyHealth-=10;
        enemyHealthBar.setHealth(enemyHealth);
        
        if (enemyHealth <=0) {
            //You win!
            YouWin youwin = new YouWin();
            world.addObject(youwin, 501, 446);
            System.out.println("Knock out! Game over.");
            Greenfoot.stop();
        }
    }
    
    public void decreaseGamerHealth() {
        gamerHealth-=30; 
        gamerHealthBar.setHealth(gamerHealth);

        if (gamerHealth <=0) {
            //Game Over!
            YouLose youlose = new YouLose();
            world.addObject(youlose, 501,446);
            System.out.println("Knock out! Game over.");
            Greenfoot.stop();
        }
    }
}
