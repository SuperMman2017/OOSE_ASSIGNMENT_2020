public class PotionOfDamage extends Potion {

    public static final String POTION_OF_DAMAGE = "Potion of Damage";
    public static final String POTION_DESCRIPTION = "Use once, deals a certain amount of damage to an enemy.";

    public PotionOfDamage(int effect) {
        super(POTION_OF_DAMAGE, effect);
        setDescription(POTION_DESCRIPTION);
    }

    @Override
    public void doEffect(Actor enemy) {
        enemy.setHealth(enemy.getCurrentHealth() - getEffect());
    }

    @Override
    public String toString() {
        return getName() + "\nDamage effect:  " + getEffect(); 
    }
}