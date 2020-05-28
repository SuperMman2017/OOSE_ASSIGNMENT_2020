public abstract class Item {

    protected String description;
    protected String name;
    protected int cost;

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    
}