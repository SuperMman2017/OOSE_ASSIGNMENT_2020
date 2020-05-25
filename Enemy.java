
public abstract class Enemy extends Character implements SpecialAbility {

    private int goldDrop;

    public Enemy(String name, int health) {
        super(name, health);
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
}