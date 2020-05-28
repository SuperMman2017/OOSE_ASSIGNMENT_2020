
public class Potion extends Item {

    private int effect;
    public static final String HEAL_DESC = "Single use; User recovers health.";
    public Potion(String name,int cost) {
        this.name = name;
        this.cost = cost;
    }
    
    public void setEffect(int effect) {
        this.effect = effect;
    }

    public int getEffect() {
        return effect;
    }
}