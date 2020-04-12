public class Player extends Actor implements IAttackable, IDefendable
{
    public static final int DEFAULT_PLAYER_HP = 30;
    private int gold;


    public Player(String name)
    {
        super(name,DEFAULT_PLAYER_HP,DEFAULT_PLAYER_HP);

    }
    @Override
    public void defend()
    {

    }

    @Override
    public void attack()
    {
        
    }
}
