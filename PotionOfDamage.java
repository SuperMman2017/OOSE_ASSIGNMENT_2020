
public class PotionOfDamage extends Potion{

    public static final String POTION_DAMAGE_DESCRIPTION = "Inflicts damage towards opponent";
    public PotionOfDamage(String name, int cost) {
        super(name, cost);
        setDescription(POTION_DAMAGE_DESCRIPTION);
    }

    @Override
    public void doEffect(Actor enemy) {
        enemy.loseHealth(getEffect() );
    }
}