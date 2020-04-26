
public abstract class Potion extends Item {

    private int effect;

    public Potion(String name,int cost) {
        super(name, cost);
    }
    
    public abstract void doEffect(Actor p);

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public int getEffect() {
        return effect;
    }

}