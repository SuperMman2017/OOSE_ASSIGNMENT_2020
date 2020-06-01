import java.util.LinkedList;

/*Ogre subclass of Enemy class*/
public class Ogre extends Enemy {

    public static final String OGRE = "Ogre";
    public static final int OGRE_MAX_HEALTH = 40;
    
    public static final int OGRE_MIN_DEF = 6;
    public static final int OGRE_MAX_DEF = 12;
 
    public static final int OGRE_MIN_DAMAGE = 5;
    public static final int OGRE_MAX_DAMAGE = 10;
    
    public static final int OGRE_SPECIAL_CHANCE = 20;

    public static final int OGRE_GOLD_DROP = 40;
    public static final String OGRE_SPECIAL_ABILITY = "Ogre attacks twice this turn";
    public Ogre() {
        super(OGRE, OGRE_MAX_HEALTH);
        setAttack(OGRE_MIN_DAMAGE);
        randomiseDefense(OGRE_MIN_DEF, OGRE_MAX_DEF);
    }

    /*  When special ability is activated, recurse once to attack twice returns 
        the net damage of both attacks. If special ability is not active it will
        only attack once returning damage dealt of one turn instead of two*/
    @Override public int attack(LinkedList<String> log) {
        specialAbility();
        Probability damageProb = new Probability();
        int damageDealt = damageProb.getRandomNumberBetween(OGRE_MIN_DAMAGE, OGRE_MAX_DAMAGE);
        int secondAttack = 0;
        if(specialActive) {
            log.add(new String(getName() +  " uses their special ability. " + OGRE_SPECIAL_ABILITY) );
            log.add(new String(getName() + " attacks with " + damageDealt + " power."));
            secondAttack = damageProb.getRandomNumberBetween(OGRE_MIN_DAMAGE, OGRE_MAX_DAMAGE);
            damageDealt+=secondAttack;
            setSpecial(false);
        }
        log.add(new String(getName() + " attacks with " + (damageDealt-secondAttack) + " power.") );
        return damageDealt;
    }

    /*Returns a Character of this object*/
    @Override public Character clone() {
        Enemy ogre = new Ogre();
        ogre.setDefense(getDefense());
        ogre.setAttack(getAttack());
        ogre.setHealth(getCurrentHealth());

        return ogre;
    }

    /*  Ogre's special ability will have a 20 percent chance to activate, 
        this method will set the ogre's specialAbility to true, affecting its attack() method*/
    @Override public void specialAbility() {
        
        Probability probSpecial = new Probability();
        if(probSpecial.getChance(OGRE_SPECIAL_CHANCE)) {
            setSpecial(true);
        }
    }

}