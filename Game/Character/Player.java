package Game.Character;

public class Player extends CharacterDecorator {
    public static final String PLAYER = "Player";
    public static final int DEFAULT_PLAYER_HP = 30;

    private Item currentWeapon;
    private Item currentArmor;

    private PlayerBag bag;
    private int gold;
    
    public Player(GameCharacter charr) {
        super(charr);
        currentWeapon = null;
        currentArmor = null;

        bag = new PlayerBag();
        setGold(100);
    }

    public void setArmor(Item armor) {
        currentArmor = armor;
    }

    public void setWeapon(Item weapon) {
        currentWeapon = weapon;
    }

    @Override public GameCharacter clone() {
        Player player = new Player(this);

        player.setHealth(getHealth());
        player.setMaxHealth(getMaxHealth());
        player.setAttack(getAttack());
        player.setDefense(getDefense());
        player.setGold(gold);

        return player;
    }

    @Override public void attack() {
        
    }

    public int getCurrentGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override public String toString()
    {
        return getName();
    }
}
