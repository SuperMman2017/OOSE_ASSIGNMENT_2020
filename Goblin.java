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
        rngDefense(GOBLIN_MIN_DEF, GOBLIN_MAX_DEF);
        setAttack(GOBLIN_MIN_ATTACK);
    }

    @Override
    public void attack() {

    }

    @Override
    public Actor clone() {
        Actor goblin = new Goblin();

        return goblin;
    }

    @Override
    public void specialAbility() {
        Probability prob = new Probability();
        if(prob.getChance(GOBLIN_SPECIAL_CHANCE))
        {
            setAttack(getDamage() + INCREASE_ATTACK);
            attack();
            setAttack(getDamage() - INCREASE_ATTACK);
        }
    }

    @Override
    public String toString() {
        return GOBLIN;
    }
}