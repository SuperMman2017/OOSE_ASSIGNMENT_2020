public class Dragon extends Enemy implements SpecialAbility
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
    public static final int DOUBLE_DAMAGE_CHANCE = 75;
    public static final int RECOVER_HEALTH_CHANCE = 90;

    private boolean specialAffectChanges;
    
    
    public Dragon()
    {
        super(DRAGON, DRAGON_MAX_HEALTH,DRAGON_MAX_HEALTH);

        setAttack(DRAGON_MIN_DAMAGE);
        rngDefense(DRAGON_MIN_DEFENSE,DRAGON_MAX_DEFENSE);
        specialAffectChanges = false;
    }


    @Override
    public Actor clone()
    {
        Actor dragon = new Dragon();
        dragon.setAttack(getDamage());
        dragon.setDefense(getDefense());
        return dragon;
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
            setAttack(getDamage() / 2);
            specialAffectChanges = false; 
        }
    }


    @Override
    public void specialAbility()
    {
        Probability prob = new Probability();
        if(prob.getChance(SPECIAL_ATTACK_CHANCE))
        {

            //10% chance to heal for 10 Health
            if(prob.getChance(DOUBLE_DAMAGE_CHANCE))
            {
                if(getCurrentHealth() != getMaxHealth())
                {
                    setHealth(getCurrentHealth() + HEAL_DRAGON);
                }
            }

            //Set dragon's attack to double damage on 25% chance
            else if(prob.getChance(RECOVER_HEALTH_CHANCE))
            {
                setAttack(getDamage() * 2);
                specialAffectChanges = true;
            }
        }
    }

    @Override
    public String toString()
    {
        return DRAGON; 
    }
}