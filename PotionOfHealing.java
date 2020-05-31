
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
        player.setHealth(Math.min(player.getMaxHealth(), Math.max(player.getCurrentHealth(),player.getCurrentHealth() + potion.getEffect())) );
    }
    
}