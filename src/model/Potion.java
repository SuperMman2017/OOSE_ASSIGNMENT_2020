package model;
import model.*;
public class Potion extends Item {
    public static final char POTION = 'P';
    /*potionType determines what type of potion it is e.g D = damage, H  = heal */
    public static final String HEAL_DESC = "Single use; User recovers health.";
    /*potion constructor requires a name, cost and character representing the type of potion it is */
    public Potion(String name,int cost) {
        this.name = name;
        this.cost = cost;
    }
    
    @Override public void doEffect(Character character) {

    }
}
