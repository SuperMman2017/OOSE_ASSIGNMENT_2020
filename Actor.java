/*  Class actor that can represent player/enemy 
    or possible NPC in the game*/
public abstract class Actor implements IAttackable
{
    public static final int MIN_HEALTH = 0;
    public static final int DEFAULT_HEALTH = 10;
    public static final int DEFAULT_DAMAGE = 2;

    private String name;
    private int damage; 
    private int maxHealth;
    private int currentHealth;
    private int defense;

    public Actor(String name) {
        this.name = name;
        currentHealth = DEFAULT_HEALTH;
        maxHealth = DEFAULT_HEALTH;
        damage = DEFAULT_DAMAGE;
    }

    public Actor(String name,int currentHealth,int maxHealth) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.maxHealth = maxHealth;
        this.damage = 0;
    }

    /*Clone method to return the clone copy of the current Actor object*/
    public abstract Actor clone();

    public Actor copy() {
        return this;
    }

    public void setAttack(int damage) {
        this.damage = damage;
    }

    public void setHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public boolean isKnockedOut() {
        return currentHealth <= MIN_HEALTH;
    }

    @Override
    public String toString()
    {
        String content = "Name" + ": " + name + "\n" +
                          "Health: " + currentHealth + 
                          " / " + maxHealth;
        return content;
    }
}
