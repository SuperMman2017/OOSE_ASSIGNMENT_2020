public class Slime extends Enemy {

    public static final String SLIME = "Slime";

    public static final int SLIME_MIN_DAMAGE = 3;
    public static final int SLIME_MAX_DAMAGE = 5;
    public static final int DAMAGE_ON_SPECIAL = 0;

    public static final int SLIME_MAX_DEFENSE = 2;
    public static final int SLIME_MIN_DEFENSE = 0;

    public static final int SLIME_HEALTH = 10;

    public static final int SPECIAL_ATTACK_CHANCE = 20;

    public static final int SLIME_GOLD_DROP = 10;

    //Default consructor
    public Slime() {
        super(SLIME, SLIME_HEALTH);
        setAttack(SLIME_MIN_DAMAGE);
        setGoldDrop(SLIME_GOLD_DROP);
    }

    @Override public Character clone() {
        Slime slime = new Slime();
        slime.setDefense(getDefense());
        slime.setAttack(getAttack());
        slime.setHealth(getCurrentHealth());

        return slime;
    }

    @Override public void attack() {
        
    }

    @Override public void specialAbility() {
        //Do effect
    }
}
