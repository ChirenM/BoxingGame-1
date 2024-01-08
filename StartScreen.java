import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The welcome screen
 * 
 * @author (Elizabeth and Chiren) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Title title = new Title();
        addObject(title,506, 598);
        
        Welcome welcome = new Welcome();
        addObject(welcome,507,337);
    }

    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        Greenfoot.setWorld(new Boxing());
    }
}
