public abstract class Item {

    private String description;
    private String name;
    private int cost;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
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

    public int getCost() {
        return cost;
    }

}