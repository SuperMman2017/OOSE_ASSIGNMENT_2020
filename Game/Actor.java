/*  Class actor that can represent player/enemy 
    or possible NPC in the game*/
public abstract class Actor
{
    private String name;
    private int maxHealth;
    private int currentHealth;
    

    public Actor(String name,int currentHealth,int maxHealth)
    {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
    }

    /*Clone method to return the clone copy of the current Actor object*/
    
    public abstract Actor clone();

    public Actor copy()
    {
        return this;
    }

    public void setHealth(int currentHealth)
    {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }


    public String getName()
    {
        return name;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public int getCurrentHealth()
    {
        return currentHealth;
    }
}
