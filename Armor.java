public class Armor extends Item {
    protected String material;

    public Armor() {

    }

    public Armor(String name, String material, int minDef, int maxDef, int cost) {
        this.material = material;
        this.minEffect = minDef;
        this.maxEffect = maxDef;
        this.name = name;
        setDescription(material);
        setCost(cost);
    }

    public void setMinDef(int minDef) {
        this.minEffect = minDef;
    }

    public void setMaxDef(int maxDef) {
        this.maxEffect = maxDef;
    }

    public int getMaxDef() {
        return this.maxEffect;
    }
    public int getMinDefense() {
        return this.minEffect;
    }

    public int getDefense() {
        return getEffect();
    }

    @Override public String toString() {
        return  getName() + ", "  + this.material + ", " +
                getDescription() + ", " + this.minEffect + ", " +
                this.maxEffect + ", " + getCost();
    }

    @Override public void doEffect(Character player) {
        player.setDefense(this.getDefense());
    }

}