
public class PotionOfHealing extends ItemDecorator {
    protected Potion potion;
    public static final String POTION_HEALING_DESCRIPTION = "Heals User by a certain amount";
    public PotionOfHealing(Potion potion) {
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
        return new String(""+potion.getPotionType());
    }

}