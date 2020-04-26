import java.util.LinkedList;

public class BattleSystem {
    //A list of players in the battlefield
    private Actor player;
    private LinkedList<Actor> enemies;

    public BattleSystem(Player player) {
        this.player = player;
        enemies = new LinkedList<>();
    }

    public void turn() {
        for(Actor enemy : enemies) {
            enemy.attack();
        }
    }
    
    public void doAttack(Actor player, Actor enemy) {
        
    }
}