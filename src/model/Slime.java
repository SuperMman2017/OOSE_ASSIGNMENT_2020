package model;
import model.*;
import java.util.LinkedList;
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
    public static final String SLIME_SPECIAL = " Slime hits for 0 damage next turn";
    //Default consructor
    public Slime() {
        super(SLIME, SLIME_HEALTH);
        setAttack(SLIME_MIN_DAMAGE);
        setGoldDrop(SLIME_GOLD_DROP);
    }

    @Override public Enemy clone() {
        Slime slime = new Slime();
        slime.setDefense(getDefense());
        slime.setAttack(getAttack());
        slime.setHealth(getCurrentHealth());

        return slime;
    }

    @Override public int attack(LinkedList<String> log) {
        specialAbility();
        Probability probAttack = new Probability();
        int damageDealt = probAttack.getRandomNumberBetween(SLIME_MIN_DAMAGE, SLIME_MAX_DAMAGE);
        String move = "";
        
        if(specialActive) {
            setSpecial(false);
            damageDealt = 0;
            move = new String(this.getName() + " activated its special ability. " + SLIME_SPECIAL);
        }
        else {
            move = this.getName() + " attacks with " + damageDealt +" power.";
        }
        log.add(move);
        return damageDealt;
    }

    @Override public void specialAbility() {
        //Do effect
        Probability probSpecial = new Probability();
        if(probSpecial.getChance(SPECIAL_ATTACK_CHANCE)) {
            setSpecial(true);
        }
    }
}
