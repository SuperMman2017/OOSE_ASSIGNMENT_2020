public class PotionOfDamage extends ItemDecorator{
    public static final char POTION_OF_DAMAGE = 'D';
    protected Item potion;
    public static final String POTION_DAMAGE_DESCRIPTION = "Inflicts damage towards opponent";
    public PotionOfDamage(Item potion) {
        this.potion = potion;
        setDescription(POTION_DAMAGE_DESCRIPTION + " for " + potion.getEffect());
    }

    /*  Decreases enemies' health by the potion effect,
        Player/Enemy health is clamped so its currentHealth 
        does not decrease below 0 */
    @Override public void doEffect(Character player) {
        player.setAttack(potion.getEffect());
        System.out.println("player attacks with potion of damage");
    }

    @Override public String getDescription() {
        return new String(""+POTION_OF_DAMAGE);
    }

    @Override public char getItemType() {
        return potion.getItemType();
    }

    @Override public void setType(char type) {
        potion.setType(type);
    }
}
