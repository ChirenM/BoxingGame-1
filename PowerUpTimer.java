import greenfoot.*;

// the timer for the powerups to be used/ taken off screen
// @author(chiren)

public class PowerUpTimer extends Actor {
    final int FRAMES_DELAY = 200;
    int currentTimer = FRAMES_DELAY;
    //int frames = maxValue;

    HealthBar health;

    public void act() {
        currentTimer--;
        if(currentTimer <= 0) {
            //frames = maxValue;
            spawnPowerUpRandomly();
            currentTimer = FRAMES_DELAY;
        }
    }
    
    public void spawnPowerUpRandomly() {
        
        int xSize = getWorld().getWidth();
        int ySize = getWorld().getHeight();

        // generate random number between 0-2
        int randomChoice = Greenfoot.getRandomNumber(2);
        
        int xPos = Greenfoot.getRandomNumber(1000);
        int yPos = Greenfoot.getRandomNumber(800);

        if(randomChoice == 0) {
            //WaterBottle waterBottle = new WaterBottle(10, 10);
            PowerUps waterBottle = new PowerUps(10, 10, "protein");
            getWorld().addObject(waterBottle, xPos, yPos);
        }

        else if(randomChoice == 1) {
            //ProteinBar proteinBar = new ProteinBar(20,20);
            PowerUps proteinBar = new PowerUps(20,20,"protein");
            getWorld().addObject(proteinBar, xPos, yPos);
        }

        else if(randomChoice == 2) {
            //ChickenLeg chickenLeg = new ChickenLeg(30,30);
            PowerUps chickenLeg = new PowerUps(30,30,"protein");
            getWorld().addObject(chickenLeg, xPos, yPos);
        }

    }
}


