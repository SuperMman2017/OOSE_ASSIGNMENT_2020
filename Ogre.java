
public class Ogre extends Enemy {

    public static final String OGRE = "Ogre";
    public static final int OGRE_MAX_HEALTH = 40;
    
    public static final int OGRE_MIN_DEF = 6;
    public static final int OGRE_MAX_DEF = 12;

    public static final int OGRE_MIN_DAMAGE = 5;
    public static final int OGRE_MAX_DAMAGE = 10;
    
    public static final int OGRE_SPECIAL_CHANCE = 20;
    public Ogre() {
        super(OGRE, OGRE_MAX_HEALTH);
        setAttack(OGRE_MIN_DAMAGE);
        randomiseDefense(OGRE_MIN_DEF, OGRE_MAX_DEF);
    }


    @Override public int attack() {
        Probability damageProb = new Probability();
        int damageDealt = damageProb.getRandomNumberBetween(OGRE_MIN_DAMAGE, OGRE_MAX_DAMAGE);
        if(specialActive) {
            setSpecial(false);
            damageDealt+=attack();
        }
        return damageDealt;
        //Do damage
    }


    @Override public Character clone() {
        Enemy ogre = new Ogre();
        ogre.setDefense(getDefense());
        ogre.setAttack(getAttack());
        ogre.setHealth(getCurrentHealth());

        return ogre;
    }

    @Override public void specialAbility() {
        //Do effect
        Probability probSpecial = new Probability();
        if(probSpecial.getChance(OGRE_SPECIAL_CHANCE)) {
            setSpecial(true);
        }
    }

}