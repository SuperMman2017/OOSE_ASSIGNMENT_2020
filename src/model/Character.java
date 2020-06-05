public abstract class Character implements Actor {

    private String name;
    private int health;
    private int maxHealth;

    private int defense;
    private int attack;

    
    /** Default constructor method for Character class
     *  health parameter is assumed as current and max health
     */
    public Character(String name,int health) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
    }

    /**constructor method for Character class */
    public Character(String name, int health, int maxHealth) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public abstract Character clone();
    
    @Override public void setHealth(int health) {
        this.health = health;
    }

    @Override public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    @Override public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override public void setDefense(int defense) {
        this.defense = defense;
    }
    
    @Override public void setName(String name) {
        this.name = name;
    }
    @Override public int getMaxHealth() {
        return maxHealth;
    }

    @Override public int getCurrentHealth() {
        return health;
    }

    @Override public int getDefense() {
        return defense;
    }

    @Override public int getAttack() {
        return attack;
    }

    @Override public String getName() {
        return name;
    }


    @Override public boolean isAlive() {
        return health != 0;
    }
    /*public void loseHealth(int damage) {
        setHealth(getCurrentHealth() - Math.max(0,damage - this.getDefense()) ) ;
    }*/
}
