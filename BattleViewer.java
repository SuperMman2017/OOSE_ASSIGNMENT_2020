import java.util.InputMismatchException;
import java.util.LinkedList;

public class BattleViewer {
    //A list of players in the battlefield
    private Player player;
    private Character enemy;
    private BattleController battleController;
    private EnemyFactory enemyFactory;
    private UserInterface ui;
    public BattleViewer(UserInterface ui, Player player) {
        this.ui = ui;
        battleController = new BattleController(player);
        enemyFactory = new EnemyFactory();
        enemy = enemyFactory.getRandomEnemy();
    }

    /**/
    public void battle() {
        while(player.isAlive() && enemy.isAlive()) {
            battleController.displayPlayer();
            displayPlayerChoice(player);
            int choice = playerBattleChoice();
            if(choice == 1) {
                int attack = player.attack();
                int healthLost = Math.max(0,attack - enemy.getDefense());
                enemy.setHealth(enemy.getCurrentHealth() - healthLost);
                battleController.logMove(new String(player.getName() + " attacked with "
                                         + player.getCurrentWeapon().getName() + " with "
                                         + attack +" atk   power.\n " + enemy.getName() +" lost " + healthLost + " health."));
            }
            else {

            }
        }

        battleController.displayLog();
    }

    public int playerBattleChoice() {
        int choice = 0;
        while(choice != 0 || choice != -1) {
            try {
                choice = ui.inputNumber();             
            }
            catch(InputMismatchException e){
                System.out.println("Error, invalid input. Try again. ");
                choice = -1;
            } 
            if(choice != 1 || choice != 2 && choice != -1) {
                System.out.println(choice + " is not an option. Try again. ");
                choice = 0;
            }
        }
        return choice;
    }
    
    public void displayPlayerChoice(Character player) {
        System.out.println("1. Attack\n2. Bag");
    }
    
    public void displayPlayerUsable() {
        for(Item item : player.getBag().getTypeList('P')) {
            System.out.println(item.getName() + " " + item.getDescription() );
        }
    }

    public void enemyAttacks(Character enemy, Character Player){
        
    }

}