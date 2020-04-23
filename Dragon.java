import java.util.Random;

public class Dragon extends Actor implements SpecialAbility
{
    public static final String DRAON = "Dragon";
    public static final int DRAGON_MAX_HEALTH = 100;
    public static final int HEAL_DRAGON = 10;

    public static final int DRAGON_MIN_DAMAGE = 15;
    public static final int DRAGON_MAX_DAMAGE = 30;


    public static final int DRAGON_GOLD = 100;


    public static final int SPECIAL_ATTACK_CHANCE = 35;
    public static final int DOUBLE_DAMAGE_CHANCE = 75;
    public static final int RECOVER_HEALTH_CHANCE = 90;

    private boolean specialAffectChanges;
    public Dragon()
    {
        specialAffectChanges = false;
    }
    @Override
    public Actor clone()
    {
        return null;
    }

    @Override
    public void attack()
    {
        specialAbility();
        if(specialAffectChanges == true)
        {
            //Dragon healed do normal attack
            //code


        }
        else
        {
            //Attack
            //code

            
            /** Return attack to normal after casting 
                it's special attack**/
            setAttack(getAttack() / 2);
        }
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
        
        //
        if(chance < SPECIAL_ATTACK_CHANCE)
        {
            int anotherChance = rand.nextInt(100);

            //10% chance to heal for 10 Health
            if(anotherChance >= RECOVER_HEALTH_CHANCE )
            {
                if(getCurrentHealth() != getMaxHealth())
                {
                    setHealth(getCurrentHealth() + HEAL_DRAGON);
                }
            }

            //Set dragon's attack to double damage on 25% chance
            else if(anotherChance >= DOUBLE_DAMAGE_CHANCE)
            {
                setAttack(getAttack() * 2);
                specialAffectChanges = true;
            }
        }
    }

    @Override
    public String toString()
    {
        return DRAGON + ", " + getDamage() + ", " + 
        getCurrentHealth() + ", " + getMaxHealth();
    }
}