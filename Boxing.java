import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * World class
 * 
 * @author (elle)
 * @version (a version number or a date)
 */

public class Boxing extends World {

    private HealthManager healthManager = new HealthManager(this);
    private Gamer gamer = new Gamer();
    private EnemyStance enemy = new EnemyStance();
    private PowerUpTimer powerUpTimer = new PowerUpTimer();

    public Boxing() {
        super(1000, 800, 1);
        addObject(gamer, 303, 525);
        addObject(enemy, 773, 509);
        addObject(powerUpTimer, 0, 0); // initialise powerUpTimer into world
    }

    public HealthManager getHealthManager() {
        return healthManager;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public EnemyStance getEnemy() {
        return enemy;
    }
}
