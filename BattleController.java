import java.util.LinkedList;
public class BattleController  {

    private Enemy enemy;
    private Player player;
    public LinkedList<String> log;


    public BattleController(Player player) {
        this.player = player;
        log = new LinkedList<>();
        this.enemy = null;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void playerAttacks() {
        int attack = player.attack(log);
        int healthLost = Math.max(0,attack - enemy.getDefense());
        enemy.setHealth(Math.max(0, enemy.getCurrentHealth() - healthLost) );
        logMove(new String(player.getName() + " attacked with "
                 + player.getCurrentWeapon().getName() + " with "
                 + attack +" atk   power.\n " + enemy.getName() +" lost " + healthLost + " health."));
    }

    public void enemyAttacks() {
        int attack = enemy.attack(log);
        int healthLost = Math.max(0, attack - player.getDefense());
        player.setHealth(Math.max(0, player.getCurrentHealth() - healthLost) );
    }

    public boolean playerUsePotion(Item item){
        boolean successUse = false;
        if( item.getDescription().charAt(0) == PotionOfHealing.POTION_OF_HEALING
            && player.getCurrentHealth() != player.getMaxHealth()) {
            successUse = true;
            int oldHealth = player.getCurrentHealth();
            item.doEffect(player);
            int healthGained = player.getCurrentHealth() - oldHealth;
            logMove(   player.getName() + " used " + item.getName() + "\n" +
                                        player.getName() + " regained " + healthGained + " health.");
        }
        else if (item.getDescription().charAt(0) == PotionOfDamage.POTION_OF_DAMAGE) {
            successUse = true;
            item.doEffect(player);
            int attack = player.getAttack();
            int healthLost = attack;
            logMove(new String(player.getName() + " used " + item.getName()) );
            enemy.setHealth(Math.max(0, Math.max(0,enemy.getCurrentHealth() - healthLost)) );
            logMove(new String(enemy.getName() + " lost " + healthLost + " health.")  );
        }
        player.removeFromBag(item);
        return successUse;
    }

    /**/
    public void displayPlayer() {
        System.out.println( "Name: " + player.getName() + "\n" + "Health: " +
                            player.getCurrentHealth() + "/"+ player.getMaxHealth()+
                            "\nArmor: " + player.getCurrentArmor().getName() +
                            "\nWeapon: " + player.getCurrentWeapon().getName());
    }   

    public void displayEnemy(Enemy enemy) {
        System.out.println("Enemy: " + enemy.getName() + "\n" + "Health: " + 
                            enemy.getCurrentHealth() + "/" + enemy.getMaxHealth());
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

    /*Not used anymore */
    /*public void usePotion(PotionOfHealing item) {
        player.removeFromBag(item);
        /*increases player health based on the potion */
     /*   item.doEffect(player);
    }*/

    public void increasePlayerGold(Enemy enemy) {
        player.setGold(enemy.getGoldDrop());
    }

    public void displayLastMessage() {
        System.out.println(log.getLast());
    }
}