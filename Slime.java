import java.util.Random;
public class Slime extends Actor implements SpecialAbility
{

    public static final String SLIME = "Slime";

    public static final int SLIME_DAMAGE_MIN = 3;
    public static final int SLIME_DAMAGE_MAX = 5;
    public static final int DAMAGE_ON_SPECIAL = 0;


    public static final String SLIME_MAX_DEFENSE = 2;
    public static final String SLIME_MIN_DEFENSE = 0;

    public static final int SLIME_HEALTH = 10;

    public Slime()
    {
        super(SLIME, SLIME_HEALTH,SLIME_HEALTH);
    }

    public Slime(int minDef,int maxDef)
    {
        super("Slime", SLIME_HEALTH,SLIME_HEALTH);
        setDefense(minDef,maxDef);
        setAttack(SLIME_DAMAGE_MIN);
    }

    @Override
    public Actor clone()
    {
        Slime slime = new Slime(getMinDefense(),getMaxDefense());
        return slime;
    }

    @Override
    public void attack()
    {
        specialAbility();

        setAttack();
    }

    @Override
    public void defend()
    {

    }

    @Override
    public void specialAbility()
    {
        Random rand = new Random();
        int chance = rand.nextInt(100);   
        if(chance <= 20)
        {
            setAttack(DAMAGE_ON_SPECIAL);
        }
    }


    private void setDefaultDefense()
    {
        Random rand = new Random();
        int defense = rand.nextInt(SLIME_MAX_DEFENSE - SLIME_DAMAGE_MIN + 1);
        setDefense(defense, defense);
    }

    
}
