
public class PotionOfHealing extends ItemDecorator {
    protected Potion potion;
    public static final String POTION_HEALING_DESCRIPTION = "Heals User by a certain amount";
    public PotionOfHealing(Potion potion) {
        this.potion = potion;
        setDescription(POTION_HEALING_DESCRIPTION);
    }

    @Override public void doEffect(Character player) {
        player.setHealth(player.getCurrentHealth() + potion.getEffect() ); 
    }
    
}