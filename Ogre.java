
public class Ogre extends Enemy implements SpecialAbility{

    public static final String OGRE = "Ogre";
    public static final int OGRE_MAX_HEALTH = 40;
    
    public static final int OGRE_MIN_DEF = 6;
    public static final int OGRE_MAX_DEF = 12;

    public static final int OGRE_MIN_DAMAGE = 5;
    public static final int OGRE_MAX_DAMAGE = 10;

    public Ogre()
    {
        super(OGRE, OGRE_MAX_HEALTH,OGRE_MAX_HEALTH);
        rngDefense(OGRE_MIN_DEF,OGRE_MAX_DEF);
        setAttack(OGRE_MIN_DAMAGE);
    }


    @Override
    public void attack()
    {

    }


    @Override
    public Actor clone()
    {
        Enemy ogre = new Ogre();
        ogre.setDefense(getDefense());
        ogre.setAttack(getDamage());
        ogre.setHealth(getCurrentHealth());

        return ogre;
    }


    @Override
    public void specialAbility()
    {

    }
}