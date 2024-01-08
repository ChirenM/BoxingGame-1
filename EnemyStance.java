import greenfoot.*;

public class EnemyStance extends Actor {

    private static final int MOVE_SPEED = 4;
    int count;
    int health = 100;
    // time player has to move away from enemy before health reduces again
    private final int PUNCH_TIMEOUT = 50;
    public int punchTimer = 0;
    private Boxing myworld;
    private HealthManager healthManager;
    private Gamer gamer;
    
    private boolean isPunching = false;

    public boolean isPunching() {
        return isPunching;
    }

    public void act() {
        moveRandomly();
        handleRandomPunch();
        if (gamer.isPunching()) {
            hitbyGamer();
        }
    }

    @Override
    protected void addedToWorld(World world) {
        // get all the base stuff done first.
        super.addedToWorld(world);

        myworld = (Boxing) world;
        healthManager = myworld.getHealthManager();
        gamer = myworld.getGamer();
    }


     public void hitbyGamer() {

        // enemy is overlapping with gamer
        Actor enemy = getOneIntersectingObject(Gamer.class);
        if (enemy != null) {
            if (punchTimer == 0) {
                
                healthManager.decreaseEnemyhealth();

                punchTimer = PUNCH_TIMEOUT;
            } else {
                // decrease timer by 1
                punchTimer--;
            }
        } else {
            punchTimer = PUNCH_TIMEOUT;
        }
    }
    

    private void moveRandomly() {
        int randomDirection = Greenfoot.getRandomNumber(4); // 0: Left, 1: Right, 2: Up, 3: Down

        switch (randomDirection) {
            case 0:
                moveLeft();
                break;
            case 1:
                moveRight();
                break;
            case 2:
                moveUp();
                break;
            case 3:
                moveDown();
                break;
        }
    }

    private void moveLeft() {
        setLocation(getX() - MOVE_SPEED, getY());
    }

    private void moveRight() {
        setLocation(getX() + MOVE_SPEED, getY());
    }

    private void moveUp() {
        setLocation(getX(), getY() - MOVE_SPEED);
    }

    private void moveDown() {
        setLocation(getX(), getY() + MOVE_SPEED);
    }

     private void handleRandomPunch() {
        if (Greenfoot.getRandomNumber(100) < 10) {
            setImage("enemy punch.png"); // Punch with a 5% probability
            isPunching = true;
        } else {
            setImage("enemy stance.png");
            isPunching = false;
        }
    }

}
