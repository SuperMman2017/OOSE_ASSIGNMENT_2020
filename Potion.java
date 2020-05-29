
public class Potion extends Item {
    private char potionType;
    private int effect;
    public static final String HEAL_DESC = "Single use; User recovers health.";
    public Potion(String name,int cost, char potionType) {
        this.name = name;
        this.cost = cost;
        this.potionType = potionType;
    }
    
    public void setEffect(int effect) {
        this.effect = effect;
    }

    public int getEffect() {
        return effect;
    }

    public void setPotionType(char potionType) {
        this.potionType = potionType;
    }
    public char getPotionType() {
        return this.potionType;
    }

}