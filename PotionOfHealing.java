public class PotionOfHealing extends Potion {

    public static final String HEAL_POTION = "Potion of Healing";
    public static final String HEAL_DESCRIPTION = "Use once, recovers a certain amount of health.";

    public PotionOfHealing(int effect) {
        super(HEAL_POTION, effect);
        setDescription(HEAL_DESCRIPTION);
    }

    @Override
    public void doEffect(Actor player) {
        player.setHealth(player.getCurrentHealth() + getEffect());
    }

    @Override
    public String toString() {
        return getName() + "\nHealing Effect: " + getEffect();
    }
}   