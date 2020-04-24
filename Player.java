public class Player extends Actor
{
    public static final int DEFAULT_PLAYER_HP = 30;
    private int gold;


    public Player(String name)
    {
        super(name,DEFAULT_PLAYER_HP,DEFAULT_PLAYER_HP);
    }

    @Override
    public Actor clone()
    {
        Player player = new Player(getName());

        player.setMinDefense(getMinDefense());
        player.setMaxDefense(getMaxDefense());

        player.setHealth(getCurrentHealth());
        player.setMaxHealth(getMaxHealth());
       
        player.setGold(this.gold);

        return player;
    }

    @Override
    public void defend()
    {

    }

    @Override
    public void attack()
    {
        
    }
    public int getCurrentGold()
    {
        return this.gold;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }
}
