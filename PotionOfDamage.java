
public class PotionOfDamage extends ItemDecorator{
    protected Potion potion;
    public static final String POTION_DAMAGE_DESCRIPTION = "Inflicts damage towards opponent";
    public PotionOfDamage(Potion potion) {
        this.potion = potion;
        setDescription(POTION_DAMAGE_DESCRIPTION + " for " + potion.getEffect());
    }

    /*  Decreases enemies' health by the potion effect,
        Player/Enemy health is clamped so its currentHealth 
        does not decrease below 0 */
    @Override public void doEffect(Character player) {
        player.setAttack(potion.getEffect());
    }

}