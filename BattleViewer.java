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
                int attack = player.attack(battleController.log);
                int healthLost = Math.max(0,attack - enemy.getDefense());
                enemy.setHealth(enemy.getCurrentHealth() - healthLost);
                battleController.logMove(new String(player.getName() + " attacked with "
                                         + player.getCurrentWeapon().getName() + " with "
                                         + attack +" atk   power.\n " + enemy.getName() +" lost " + healthLost + " health."));
            }
            else {
                System.out.println("Choose an item by number.");
                System.out.println("Available items are usable as listed: ");
                
                LinkedList<Item> usable = player.getBag().getTypeList('P');
                int count = 1;
                for(Item item : usable) {
                    System.out.println( count + ". " + item.getName() + ": " + item.getDescription());
                    count++;
                }
                System.out.println("Enter 0 to cancel your choice");
                Item item = chooseItem(player.getBag().getBag().size());
                if(item != null) {
                    /*item is null when player cancels item selection */
                }
                else {
                    /*Go back to attack or item options */
                }
            }
        }

        battleController.displayLog();
    }

    public Item chooseItem(int max) {
        Item itemChosen = null;
        boolean notDone = true;
        int itemChoice = 0;
        while(notDone) {
            itemChoice = ui.inputNumber();
            if(itemChoice == 0 ) {
                notDone = false;
            }
            while(itemChoice > max && itemChoice < 0 ) {
                System.out.println("This item does not exist, try again ");
                itemChoice = ui.inputNumber();
            }
            if(itemChoice >= 1 && itemChoice <= max) {
                System.out.println("You chose " + player.getBag().getBag().get(itemChoice-1).getName()
                                               + " do you want to go with this?" +  "n\n1. Yes\n2. No");

                int finalChoice = ui.inputNumber();
                if(finalChoice == 1) {
                    notDone = false;
                    itemChosen = player.getBag().getBag().get(itemChoice);
                }
                else {
                    System.out.println("Re-select an item from the following 1-"+max);
                }
            }
        }
        return itemChosen;
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

    /** This method initiates the enemy to attack the player**/
    public void enemyAttacks(){
        int attack = enemy.attack(battleController.log);
        player.setHealth(Math.max(0,(Math.max(0, player.getDefense() - attack) )) );
    }

    /** This method displays the usable items the player has in their bag**/
    public void displayPlayerUsables() {
        for(Item item : player.getBag().getBag()) {
            System.out.println(item.getName() + "Description: " + item.getDescription());
        }
    }

    public void changeEnemy() {
        this.enemy = enemyFactory.getRandomEnemy();
    }

    public void enemyDefeated() {
        enemyFactory.decreaseEnemyChances(5);
        try {
            enemyFactory.setSpecificEnemy(Dragon.DRAGON, enemyFactory.getChance(Dragon.DRAGON) + 20);
        }
        catch(InvalidEnemyException e ) {
            e.printStackTrace();
        }       
    }
}