
public abstract class Enemy extends Actor {

    private int goldDrop;

    public abstract void specialAbility();
    
    /** Default constructor method for Enemy class
     *  health parameter is assumed as current and max health
     */
    public Enemy(String name,int health) {
        super(name,health,health);
        goldDrop = 0;
    }

    /**constructor method for Enemy class */
    public Enemy(String name, int health, int maxHealth) {
        super(name,health,maxHealth);
        goldDrop = 0;
    }

    @Override
    public Actor clone() {
        return null;

    }

    public void setGold(int goldDrop) {
        this.goldDrop = goldDrop;
    }


    public int getGoldDrop() {
        return goldDrop;
    }

    protected void rngDefense(int minDef,int maxDef) {
        Probability prob = new Probability();
        setDefense(prob.getRandomNumberBetween(minDef, maxDef));
    }
}