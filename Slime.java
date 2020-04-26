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
        super(SLIME, SLIME_HEALTH,SLIME_HEALTH);
        rngDefense(SLIME_MIN_DEFENSE, SLIME_MAX_DEFENSE);
        setAttack(SLIME_MIN_DAMAGE);
        setGold(SLIME_GOLD_DROP);
    }

    @Override
    public Actor clone() {
        Actor slime = new Slime();
        slime.setDefense(getDefense());
        slime.setAttack(getDamage());
        slime.setHealth(getCurrentHealth());

        return slime;
    }

    @Override
    public void attack() {
        
    }
    
    @Override
    public void specialAbility() {
        Probability prob = new Probability();
        if( prob.getChance(SPECIAL_ATTACK_CHANCE) ) {
            setAttack(DAMAGE_ON_SPECIAL);
            attack();

            setAttack(getDamage() - DAMAGE_ON_SPECIAL);
        }
    }


    public String toString() {
        return SLIME;
    }
}
