
public class PotionOfHealing extends Potion {

    public static final String POTION_HEALING_DESCRIPTION = "Heals User by a certain amount";
    public PotionOfHealing(String name, int cost) {
        super(name,cost);
        setDescription(POTION_HEALING_DESCRIPTION);
    }

    @Override
    public void doEffect(Character player) {
        player.setHealth(player.getCurrentHealth() + getEffect() ); 
    }
}