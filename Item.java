public abstract class Item {

    protected String description;
    protected String name;
    protected int cost;
    protected Strign itemType;

    public void setType(String itemType) {
        this.itemType = itemType;
    }

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

    public String getItemType(){
        return this.itemType;
    }
    
}