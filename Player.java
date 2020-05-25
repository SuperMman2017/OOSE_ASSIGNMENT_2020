public class Player extends Character{
    public static final String PLAYER = "Player";
    public static final int DEFAULT_PLAYER_HP = 30;

    private Item currentWeapon;
    private Item currentArmor;

    private PlayerBag bag;
    private int gold;
    
    public Player() {
        super(PLAYER,DEFAULT_PLAYER_HP);
        currentWeapon = null;
        currentArmor = null;

        bag = new PlayerBag();
        setGold(100);
    }

    public Player(String name) {
        super(name,DEFAULT_PLAYER_HP);
        setGold(0);
    }

    public void setArmor(Item armor) {
        currentArmor = armor;
    }

    public void setWeapon(Item weapon) {
        currentWeapon = weapon;
    }

    @Override
    public Character clone() {
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
