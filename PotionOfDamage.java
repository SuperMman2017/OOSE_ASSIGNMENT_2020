
public class PotionOfDamage extends ItemDecorator{
    protected Potion potion;
    public static final String POTION_DAMAGE_DESCRIPTION = "Inflicts damage towards opponent";
    public PotionOfDamage(Potion potion) {
        this.potion = potion;
        setDescription(POTION_DAMAGE_DESCRIPTION);
    }

    @Override public void doEffect(Character enemy) {
        enemy.setHealth(enemy.getCurrentHealth() - potion.getEffect());
    }
}