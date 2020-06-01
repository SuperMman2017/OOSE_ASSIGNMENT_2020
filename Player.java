import java.util.LinkedList;

public class Player extends Character{
    public static final String PLAYER = "Player";
    public static final int DEFAULT_PLAYER_HP = 30;
    public static final int MAX_BAG_SIZE = 15;
    
    private Weapon currentWeapon;
    private Armor currentArmor;

    private PlayerBag bag;

    private int gold;
    
    public Player() {
        super(PLAYER,DEFAULT_PLAYER_HP);
        currentWeapon = null;
        currentArmor = null;

        bag = new PlayerBag(MAX_BAG_SIZE);
        setGold(100);
    }

    public Player(String name) {
        super(name,DEFAULT_PLAYER_HP);
        setGold(0);
    }

    public void setArmor(Armor armor) {
        currentArmor = armor;
    }

    public void setWeapon(Weapon weapon) {
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

    @Override public int attack(LinkedList<String> log) {
        return currentWeapon.getPower();
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

    public PlayerBag getBag(){
        return bag;
    }

    public void addToBag(Item item) {
        bag.addItem(item);
    }

    public void removeFromBag(Item item) {
        bag.removeItem(item);
    }

    public PlayerBag getPlayerBag() {
        return bag;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public Armor getCurrentArmor() {
        return currentArmor;
    }
}
