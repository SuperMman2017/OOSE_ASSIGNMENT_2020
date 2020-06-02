import java.util.LinkedList;
public class BattleController  {

    private Enemy enemy;
    private Player player;
    public LinkedList<String> log;


    public BattleController(Player player) {
        this.player = player;
        log = new LinkedList<>();
    }

    public void playerAttacks() {
        int attack = player.attack(log);
        int healthLost = Math.max(0,attack - enemy.getDefense());
        enemy.setHealth(enemy.getCurrentHealth() - healthLost);
        logMove(new String(player.getName() + " attacked with "
                 + player.getCurrentWeapon().getName() + " with "
                 + attack +" atk   power.\n " + enemy.getName() +" lost " + healthLost + " health."));
    }

    public void playerUsePotion(Item item){
        if(item.getDescription().equals("H")) {
            int oldHealth = player.getCurrentHealth();
            item.doEffect(player);
            int healthGained = player.getCurrentHealth() - oldHealth;
            logMove(   player.getName() + " used " + item.getName() + "\n" +
                                        player.getName() + " regained " + healthGained + " health.");
        }
        else if (item.getDescription().equals("D")) {
            item.doEffect(player);
            int attack = player.getAttack();
            int healthLost = enemy.getDefense() - attack;
            logMove(new String(player.getName() + " used " + item.getName()) );
            enemy.setHealth(Math.max(0, Math.max(0,enemy.getCurrentHealth() - healthLost)) );
            logMove(new String(enemy.getName() + " lost " + healthLost + " health.")  );
        }
        
    }

    /**/
    public void displayPlayer() {
        System.out.println("Name: " + player.getName() + "\n" +
                            "Armor: " + player.getCurrentArmor().getName() +
                            "Weapon: " + player.getCurrentWeapon().getName());
    }   

    public void displayEnemy(Enemy enemy) {
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

    public void increasePlayerGold(Enemy enemy) {
        player.setGold(enemy.getGoldDrop());
    }
}