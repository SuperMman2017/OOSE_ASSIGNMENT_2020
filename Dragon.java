public class Dragon extends Enemy
{
    public static final String DRAGON = "Dragon";
    public static final int DRAGON_MAX_HEALTH = 100;
    public static final int HEAL_DRAGON = 10;

    public static final int DRAGON_MIN_DAMAGE = 15;
    public static final int DRAGON_MAX_DAMAGE = 30;

    public static final int DRAGON_MIN_DEFENSE = 15;
    public static final int DRAGON_MAX_DEFENSE = 20;

    public static final int DRAGON_GOLD = 100;

    public static final int SPECIAL_ATTACK_CHANCE = 35;
    public static final int DOUBLE_DAMAGE_CHANCE = 75;
    public static final int RECOVER_HEALTH_CHANCE = 90;

    public Dragon() {
        super(DRAGON, DRAGON_MAX_HEALTH);
        setAttack(DRAGON_MIN_DAMAGE);
        randomiseDefense(DRAGON_MIN_DEFENSE, DRAGON_MAX_DEFENSE);
    }

    @Override public Character clone() {
        Dragon dragon = new Dragon();
        dragon.setAttack(getAttack());
        dragon.setDefense(getDefense());
        return dragon;
    }

    @Override public void attack() {
        //Do dragon ability attack
    }

    @Override public void specialAbility() {
        //Do effect
    }
}