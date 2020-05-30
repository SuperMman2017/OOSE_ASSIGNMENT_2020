
public abstract class Enemy extends Character implements SpecialAbility {

    private int goldDrop;
    protected boolean specialActive;
    public Enemy(String name, int health) {
        super(name, health);
        specialActive = false;
    }
    
    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    /*  Sets the defense of the enemy character to a certain value number 
        between minDef and maxDef*/
    public void randomiseDefense(int minDef, int maxDef) {
        Probability prob = new Probability();
        setDefense(prob.getRandomNumberBetween(minDef, maxDef));
    }

    protected void setSpecial(boolean active) {
        specialActive = active;
    }

    @Override public String toString() {
        return new String("Enemy: "+getName()+"\nHealth: "+getCurrentHealth() +
                          "/" +getMaxHealth()+"\nDefense: "+getDefense());
    }
}