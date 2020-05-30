import java.util.LinkedList;

public class BattleViewer {
    //A list of players in the battlefield
    private Character player;
    private LinkedList<Character> enemies;

    public BattleViewer(Player player) {
        this.player = player;
        enemies = new LinkedList<>();
    }

    /**/
    public void turn() {
        for(Actor enemy : enemies) {
            enemy.attack();
        }
    }
    
    public void displayPlayerChoice(Character player) {
        System.out.println("1. Attack\n2. Bag");
    }

    public void enemyAttacks(Character enemy, Character Player){
        
    }

}