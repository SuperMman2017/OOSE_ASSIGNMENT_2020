public class Armor extends Item {
    protected String material;
    protected int minDef;
    protected int maxDef;
    public Armor(String name, String material, int minDef, int maxDef, int cost) {
        this.material = material;
        this.minDef = minDef;
        this.maxDef = maxDef;
        this.name = name;
        setDescription("");
        setCost(cost);
    }

    public void setMinDef(int minDef) {
        this.minDef = minDef;
    }

    public void setMaxDef(int maxDef) {
        this.maxDef = maxDef;
    }

    public int getMaxDef() {
        return this.maxDef;
    }
    public int getMinDefense() {
        return this.minDef;
    }

    public int getDefense() {
        Probability prob = new Probability();
        return prob.getRandomNumberBetween(this.minDef, this.maxDef);
    }

    @Override public String toString() {
        return  getName() + ", "  + this.material + ", " +
                getDescription() + ", " + this.minDef + ", " +
                this.maxDef + ", " + getCost();
    }
}