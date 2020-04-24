import java.util.Random;
public class Slime extends Actor implements SpecialAbility
{

    public static final String SLIME = "Slime";

    public static final int SLIME_DAMAGE_MIN = 3;
    public static final int SLIME_DAMAGE_MAX = 5;
    public static final int DAMAGE_ON_SPECIAL = 0;


    public static final int SLIME_MAX_DEFENSE = 2;
    public static final int SLIME_MIN_DEFENSE = 0;

    public static final int SLIME_HEALTH = 10;


    //Default consructor
    public Slime()
    {
        super(SLIME, SLIME_HEALTH,SLIME_HEALTH);
        setDefaultDefense();
    }

    public Slime(int attack)
    {
        super("Slime", SLIME_HEALTH,SLIME_HEALTH);
        setDefaultDefense();
        setAttack(attack);
    }

    @Override
    public Actor clone()
    {
        Slime slime = new Slime();
        return slime;
    }

    @Override
    public void attack()
    {
        /** Special ability attack is called
         *  On every attack**/
        specialAbility();
        //Slime casts an attack here
        
        //code

        //Set back to default 
        setAttack(SLIME_DAMAGE_MIN);
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

    /**On object creation a defense is randomly generated  **/
    private void setDefaultDefense()
    {
        Random rand = new Random();
        int defense = rand.nextInt(SLIME_MAX_DEFENSE - SLIME_DAMAGE_MIN + 1);
        setMinDefense(defense);
        setMaxDefense(defense);
    }

    public String toString()
    {
        return SLIME + ", MINDEF:" + getMinDefense() + ", MAXDEF" + getMaxDefense() + 
    }
}
