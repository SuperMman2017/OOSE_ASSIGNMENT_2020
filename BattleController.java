import java.util.LinkedList;
public class BattleController  {
    private Player player;
    private Enemy enemy;
    private LinkedList<String> log;


    public BattleController(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        log = new LinkedList<>();
    }

    /**/
    public void displayPlayer() {
        System.out.println("Name: " + player.getName() + "\n" +
                            "Armor: " + player.getCurrentArmor().getName() +
                            "Weapon: " + player.getCurrentWeapon().getName());
    }   

    public void displayEnemy() {
        System.out.println("Enemy: " + enemy.getName() + "\n"
                            );
    } 

    public void logMove(String action) {
        log.add(action);
    }

    /*Display the list of events/actions that occurred during the battle*/
    public void displayLog() {
        for(String event : log) {
            System.out.println(event);
        }
    }

    public void playerLost() {

    }

    public void usePotion(PotionOfHealing item) {
        player.removeFromBag(item);
        /*increases player health based on the potion */
        item.doEffect(player);
    }

    public void increasePlayerGold() {
        player.setGold(enemy.getGoldDrop());
    }
}