import java.util.LinkedList;
/*Do not use this class */
public class BattleSystem {
    //A list of players in the battlefield
    private Character player;
    private LinkedList<Character> enemies;

    public BattleSystem(Player player) {
        this.player = player;
        enemies = new LinkedList<>();
    }

    /**/
    public void turn() {
        for(Actor enemy : enemies) {
            enemy.attack();
        }
    }
    
    public void doAttack(Character player, Character enemy) {
        
    }

    public void enemyAttacks(Character enemy, Character Player){
        
    }
}