import java.util.LinkedList;

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
    public static final int DOUBLE_DAMAGE_CHANCE = 25;
    public static final int RECOVER_HEALTH_CHANCE = 10;
    public static final String DRAGON_SPECIAL_1 = "Attack power is double on its next attack";
    public static final String DRAGON_SPECIAL_2 = " Recovers 10% of their health this turn";
    private int health_special;
    public Dragon() {
        super(DRAGON, DRAGON_MAX_HEALTH);
        setAttack(DRAGON_MIN_DAMAGE);
        randomiseDefense(DRAGON_MIN_DEFENSE, DRAGON_MAX_DEFENSE);
    }

    @Override public Enemy clone() {
        Dragon dragon = new Dragon();
        dragon.setAttack(getAttack());
        dragon.setDefense(getDefense());
        health_special = 0;
        return dragon;
    }

    @Override public int attack(LinkedList<String> log) {
        specialAbility();
        //Do dragon ability attack
        int damageDealt = 0;
        Probability attackChance = new Probability();
        String move = "";
        damageDealt = attackChance.getRandomNumberBetween(DRAGON_MIN_DAMAGE, DRAGON_MAX_DAMAGE);
        if(health_special == 1) {
            health_special = 0;
            move += new String (getName() + " uses their special ability." + DRAGON_SPECIAL_2);
        }
        if(specialActive){ 
           
            /*Dragon does it's special move, it will deal twice the damage */
            setSpecial(false);
            damageDealt *= 2;
            move += "\n"+new String (getName() + " uses their special ability." + DRAGON_SPECIAL_1) ;
        }
        log.add( move + "\n"+ new String(getName() + " attacks with " + damageDealt + " power"));
        return damageDealt;
    }

    @Override public void specialAbility() {
        //Do effect
        Probability probSpecial = new Probability();
        if(probSpecial.getChance(SPECIAL_ATTACK_CHANCE)) {
            /*10 percent chance to recover health*/ 
            if(probSpecial.getChance(RECOVER_HEALTH_CHANCE)) {
                /*Dragon heals for 10%*/
                health_special = 1;
                setHealth(Math.min(DRAGON_MAX_HEALTH, (int)(getCurrentHealth()+getMaxHealth()*0.1)));
            }
            /*25 percent chance to deal double damage */
            else if(probSpecial.getChance(DOUBLE_DAMAGE_CHANCE)) {
                /*When the Dragon attacks, it will deal twice the damage */
                setSpecial(true);
            }
        }
    }

}