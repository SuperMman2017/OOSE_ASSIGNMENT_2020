/*  Class actor that can represent player/enemy 
    or possible NPC in the game*/
public abstract class Actor implements IAttackable, IDefendable
{
    public static final int MIN_HEALTH = 0;
    private String name;

    private int damage; 

    private int maxHealth;
    private int currentHealth;
    
    private int maxDef;
    private int minDef;

    public Actor(String name,int currentHealth,int maxHealth)
    {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.damage = 0;
    }

    /*Clone method to return the clone copy of the current Actor object*/
    
    public abstract Actor clone();

    public Actor copy()
    {
        return this;
    }

    public void setAttack(int damage)
    {
        this.damage = damage;
    }

    public void setHealth(int currentHealth)
    {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public void setMinDefense(int minDef)
    {
        this.minDef = minDef;
    }
    
    public void setMaxDefense(int maxDef)
    {
        this.maxDef = maxDef;
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

    public int getMinDefense()
    {
        return minDef; 
    }

    public int getMaxDefense()
    {
        return maxDef;
    }


    public boolean isKnockedOut()
    {
        return currentHealth <= MIN_HEALTH;
    }
}
