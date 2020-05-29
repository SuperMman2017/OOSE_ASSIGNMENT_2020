import java.util.LinkedList;
public class BattleMenu implements IMenu {
    private Player player;
    private Enemy enemy;
    private LinkedList<String> log;


    public BattleMenu(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        log = new LinkedList<>();
    }

    public void startBattle() {
        while(player.isAlive() && enemy.isAlive()) {
            /*Battle*/
            displayPlayer();
        }
    }
    
    /**/
    public void displayPlayer() {
        System.out.println("Name: " + player.getName() + "\n" +
                            "Armor: " + player.getCurrentArmor().getName());
    }   

    public void displayEnemy() {
        System.out.println(enemy.toString());
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

    @Override public void showMenu() {
        System.out.println("A. Attack\nB. Defend\nC. Bag");
    }

    public void showPlayerBag(){

    }
}