public class Goblin extends Enemy
{
    public static final String GOBLIN = "Goblin";
    public static final int GOBLIN_HEALTH = 30;
    
    public static final int GOBLIN_MIN_DEF = 4;
    public static final int GOBLIN_MAX_DEF = 8;
    
    public static final int GOBLIN_MIN_ATTACK = 3;
    public static final int GOBLIN_MAX_ATTACK = 8;
    public static final int GOBLIN_SPECIAL_CHANCE = 50;

    public static final int INCREASE_ATTACK = 3;

    public Goblin() {
        super(GOBLIN, GOBLIN_HEALTH);
        setAttack(GOBLIN_MIN_ATTACK);
    }

    @Override public void attack() {
        
    }

    @Override public Character clone() {
        Goblin goblin = new Goblin();
        goblin.setAttack(getAttack());
        goblin.setDefense(getDefense());
        goblin.setMaxHealth(getMaxHealth());
        goblin.setHealth(getMaxHealth());

        return goblin;
    }

    @Override public void specialAbility() {
        setAttack(getAttack()+3);
    }

}