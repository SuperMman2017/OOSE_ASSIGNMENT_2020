
public abstract class Enemy extends Character {

    private int goldDrop;

    public Enemy(String name, int health) {
        super(name, health);
    }
    
    public void setGoldrDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    public int getGoldDrop() {
        return goldDrop;
    }
}