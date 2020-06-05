package model;
import model.*;
public class PotionOfHealing extends ItemDecorator {
    public static final char POTION_OF_HEALING = 'H';
    protected Item potion;
    public static final String POTION_HEALING_DESCRIPTION = "Heals User by a certain amount";
    public PotionOfHealing(Item potion) {
        this.potion = potion;
        setDescription(POTION_HEALING_DESCRIPTION + " for " + potion.getEffect());
    }

    /*  Player health is increased by the potion effect (int)
        Player's health is clamped to the maxHealth so its currentHealth
        will not exceed the maxHealth*/
    @Override public void doEffect(Character player) {
                         /* Selects the minimum health between 
                            the player max health cap and its new health*/
        player.setHealth(Math.min(player.getMaxHealth(),
                        /*  Selects the max health between 
                            it's current and new health */ 
                         Math.max(player.getCurrentHealth(),player.getCurrentHealth() + potion.getEffect())) );
    }

    @Override public String getDescription() {
        return new String(""+POTION_OF_HEALING);
    }

    @Override public char getItemType() {
        return potion.getItemType();
    }

    @Override public void setType(char type) {
        potion.setType(type);
    }
}
