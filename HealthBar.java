import greenfoot.*;

// the healthbar class
// @author(Chiren)

public class HealthBar extends Actor {
    
    private int health = 100;
    private int healthBarWidth = 100;
    private int healthBarHeight = 10;
    private int pixelsPerHealthPoint = (int) healthBarWidth / health;

    public void setHealth(int value) {
        health = value;
        updateHealthBar();
    }

    public HealthBar() {
        updateHealthBar();
    }

    private void updateHealthBar() {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health * pixelsPerHealthPoint, healthBarHeight);
    }
    
}
    

    
