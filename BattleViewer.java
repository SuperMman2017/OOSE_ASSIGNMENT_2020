import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.LinkedList;
public class BattleViewer {
    //A list of players in the battlefield
    private Player player;
    private Enemy enemy;
    private BattleController battleController;
    private EnemyFactory enemyFactory;
    private UserInterface ui;
    private int battleEncounter;
    public BattleViewer(UserInterface ui, Player player, EnemyFactory enemyFactory, BattleController battleController) {
        battleEncounter = 0;
        this.player = player;
        this.ui = ui;
        this.enemyFactory = enemyFactory;
        enemy = enemyFactory.getRandomEnemy();
        this.battleController = battleController;
    }


    /*Start the battle*/
    public boolean battle() {
        battleEncounter++;
        boolean playerTurn = true;
        battleController.logMove("Battle Encounter No#" + battleEncounter);
        changeEnemy();
        if(enemy == null) {
            System.out.println("Enemy null");
        }
        else if(player == null) {
            System.out.println("Player null");
        }
        while(player.isAlive() && enemy.isAlive()) {
            battleController.displayPlayer();
            battleController.displayEnemy(enemy);
            displayPlayerChoice(player);
            int choice = playerBattleChoice();
 
            if(choice == 1) {
                battleController.playerAttacks();
                battleController.displayLastMessage();
                playerTurn = false;
            }

            if(!playerTurn && enemy.isAlive()) {
                playerTurn = true;
                battleController.enemyAttacks();
                battleController.displayLastMessage();
            }
 
            else if(choice == 2){
                System.out.println("Choose an item by number.");
                System.out.println("Available items are usable as listed: ");
                displayPlayerUsables();
                System.out.println("Enter 0 to cancel your choice");
                Item item = chooseItem(player.getPlayerBag().getTypeList(Potion.POTION).size());
                if(item != null) {
                    /*item is null when player cancels item selection */
                    boolean successUse = battleController.playerUsePotion(item);
                    if(successUse) {
                        playerTurn = false;
                    }
                    else {
                        System.out.println("You can't use this item");
                    }
                }
                else {
                    System.out.println("ERROR: Item retrieved was null");
                }
            }

            if(player.isAlive() && !enemy.isAlive()) {
                enemyDefeated();
                int goldEarned = enemy.getGoldDrop(); 
                String winMessage = new String (player.getName() + " Won!" + "\nYou picked up " + goldEarned + " gold.");
                battleController.logMove(winMessage);
                battleController.displayLog();
            }
            else if(!player.isAlive()){
                String loseMessage = new String (player.getName() + " lost." + "\nGame Over!");
                System.out.println(loseMessage);
                battleController.logMove(loseMessage);
                battleController.displayLog();
            }
        }
        return player.isAlive();
    }

    public Item chooseItem(int max) {
        Item itemChosen = null;
        boolean notDone = true;
        int itemChoice = 0;
        while(notDone) {
            itemChoice = ui.inputNumber();
            itemChoice = itemChoice == 0 || (itemChoice >= 1 && itemChoice <= max) ? itemChoice : -1;
            if(itemChoice == -1 ) {
                notDone = false;
            }
            /*Ask for user input again if the player enters incorrect values */
            while(itemChoice > max && itemChoice < 0 ) {
                System.out.println("This item does not exist, try again or Enter 0 to Quit");
                try {
                    itemChoice = ui.inputNumber();
                }
                    catch(InputMismatchException e ) {
                }
            }

            if(itemChoice >= 1 && itemChoice <= max) {
                Item item = player.getPlayerBag().getTypeList(Potion.POTION).get(itemChoice - 1);
                System.out.println("You chose " + item.getName()
                                               + " do you want to go with this?" +  "n\n1. Yes\n2. No");

                int finalChoice = ui.inputNumber();
                if(finalChoice == 1) {
                    itemChosen = item;
                    notDone = false;
                }
                else {
                    System.out.println("Re-select an item from the following 1-"+max);
                }
            }
            else if(itemChoice == 0) {
                itemChosen = null;
            }
        }
        return itemChosen;
    }

    public void showPlayerInfo() {
        battleController.displayPlayer();
    }

    public int playerBattleChoice() {
        int choice = -1;
        while(choice == -1) {
            try {
                choice = ui.inputNumber();             
            }
            catch(InputMismatchException e){
                choice = -1;
            }
            choice = choice >= 1 && choice <= 2 ? choice : -1; 
            if(choice == -1) {
                System.out.println("Your recent input was not an option. Try again.");
                choice = -1;
            }
        }
        return choice;
    }
    
    public void displayPlayerChoice(Character player) {
        System.out.println("1. Attack\n2. Bag");
    }
    
    /** This method initiates the enemy to attack the player**/
    public void enemyAttacks(){
        int attack = enemy.attack(battleController.log);
        player.setHealth(Math.max(0,(Math.max(0, player.getDefense() - attack) )) );
    }

    /** This method displays the usable items the player has in their bag**/
    public void displayPlayerUsables() {
        int count = 1;
        LinkedList<Item> list = player.getPlayerBag().getTypeList(Potion.POTION);
        for(Item item : list) {
            System.out.print(count + ". " + item.getName() + " ");
            if(item.getDescription().charAt(0) == PotionOfHealing.POTION_OF_HEALING) {
                System.out.print(   PotionOfHealing.POTION_HEALING_DESCRIPTION 
                                    + " for " + item.getMinEffect() + "-" + item.getMaxEffect());
            }
            else if(item.getDescription().charAt(0) == PotionOfDamage.POTION_OF_DAMAGE) {
                System.out.print(   PotionOfDamage.POTION_DAMAGE_DESCRIPTION
                                    + " for " + item.getMinEffect() + "-" + item.getMaxEffect());
            }
            count++;
        }
    }

    public void changeEnemy() {
        this.enemy = enemyFactory.getRandomEnemy();
        battleController.setEnemy(enemy);
    }

    public void enemyDefeated() {
        try {
            enemyFactory.decreaseEnemyChances(5);
            enemyFactory.setSpecificEnemy(Dragon.DRAGON, enemyFactory.getChance(Dragon.DRAGON) + 20);
        }
        catch(InvalidEnemyException e ) {
            e.printStackTrace();
        }  
        catch(ConcurrentModificationException e ) {
            System.out.println("What happened?");
            e.printStackTrace();
        }
    }
}