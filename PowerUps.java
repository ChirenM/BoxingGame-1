import greenfoot.*;

/**
 * Write a description of class PowerUps here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUps extends Actor 
{
    //int lineScaleDown;
    //int acrossScaleDown;
    //int PowerUpTimer;
    final int POWERUP_DURATION = 300; // time the powerup stays on screen
    int currentTimer = POWERUP_DURATION;
    String type;
    int healthBoost;
    
    int xSize, ySize;

    public PowerUps(int xSize, int ySize, String type) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.type = type;
        
        if (type == "water") {
            //TODO: setImage for water image
            
            //TODO: you could refactor these healthBoost values into constants (final) on the class 
            this.healthBoost = 5; 
        } else if (type == "protein") {
            setImage("proteinBar.png");
            getImage().scale(xSize, ySize);
            this.healthBoost = 10;
        } else if (type == "chicken") {
            //TODO: setImage for chicken image
            
            this.healthBoost = 20;
        }
        
    }
    
    public void act() {
        currentTimer--;
        if(currentTimer <= 0) {
            getWorld().removeObject( this );
            currentTimer = POWERUP_DURATION;
        }
    }
  
    //public void scaleDownImage(int x, int y)
    //{
        
        //lineScaleDown = x;
        //acrossScaleDown = y;
    
        //Scaling the image down so its small
        // the getWidth and height methods are used to scale down the image eg dividing height and width
        //setImage(getImage().scale(getImage().getWidth()/lineScaleDown, getImage().getHeight()/acrossScaleDown));
    //}

}
