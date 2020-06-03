/*Super class for Armor, weapons and potions*/
public abstract class Item {

    protected String description;
    protected String name;
    protected int cost;
    protected char itemType;
    protected
    public void setType(char itemType) {
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

    public char getItemType(){
        return this.itemType;
    }
    
    public abstract void doEffect(Character player);
}