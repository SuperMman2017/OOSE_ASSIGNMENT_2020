package model;
import model.*;
/*Super class for Armor, weapons and potions*/
public abstract class Item {

    protected String description;
    protected String name;
    protected int cost;
    protected char itemType;
    protected int minEffect;
    protected int maxEffect;

    public void setItem(String name, int cost, String description, int minEffect ,int maxEffect) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.minEffect = minEffect;
        this.maxEffect = maxEffect;
    }
    
    public void setEffect(int minEffect, int maxEffect)  {
        this.minEffect = minEffect;
        this.maxEffect = maxEffect;
    }

    public void setType(char itemType) {
        this.itemType = itemType;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*  Used to identify types of potion in potion decorator, 
        as for other objects inheriting item, it will be used 
        for normal description */
    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public char getItemType(){
        return this.itemType;
    }

    public int getEffect() {
        Probability prob = new Probability();
        return prob.getRandomNumberBetween(minEffect, maxEffect);
    }

    public int getMinEffect() {
        return minEffect;
    }

    public int getMaxEffect() {
        return maxEffect;
    }

    public abstract void doEffect(Character player);
}
