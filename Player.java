public class Player extends Actor{
    public static final String PLAYER = "Player";
    public static final int DEFAULT_PLAYER_HP = 30;
    private int gold;
    
    public Player()
    {
        super(PLAYER,DEFAULT_PLAYER_HP,DEFAULT_PLAYER_HP);
        setGold(0);
    }
    public Player(String name) {
        super(name,DEFAULT_PLAYER_HP,DEFAULT_PLAYER_HP);
        setGold(0);
    }

    @Override
    public Actor clone() {
        Player player = new Player(getName());

        player.setHealth(getCurrentHealth());
        player.setMaxHealth(getMaxHealth());
       
        player.setGold(this.gold);

        return player;
    }

    @Override
    public void attack() {
        
    }

    public int getCurrentGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString()
    {
        return getName();
    }
}
