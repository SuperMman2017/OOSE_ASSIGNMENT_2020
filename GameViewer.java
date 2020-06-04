import java.util.InputMismatchException;
import java.util.LinkedList;
public class GameViewer {
    public static final int MIN_CHOICE_VALUE = 1;
    public static final int MAX_CHOICE_VALUE = 6;
    private BattleViewer battleViewer;
    private ShopMenu shopController;
    private ShopViewer shopViewer;
    private UserInterface ui;
    private Player player;
    public GameViewer(BattleViewer battleViewer, ShopViewer shopViewer, UserInterface ui) {
        this.ui = ui;
        this.shopViewer = shopViewer;
        this.battleViewer = battleViewer;
    }

    public void startGame(){
        boolean noExit = true;
        System.out.println("Game started, options displayed below");
        while(noExit) {
            displayMenu();
            int chosenInput = 0;
            System.out.println("Enter your the number of your choice");
            try {
                chosenInput = ui.inputNumber();
            }
            catch(InputMismatchException exception) {
                chosenInput = 0;
            }
            /*  If the chosen input is less within the range of 1-6, 
                keep it at that value, else set it to 0 */
            chosenInput = chosenInput >= MIN_CHOICE_VALUE && 
            chosenInput <= MAX_CHOICE_VALUE ? chosenInput : 0;
            if(chosenInput != 0) {
                switch(chosenInput) {
                    //Player has chosen to go to the shop
                    case 1:
                        shopViewer.startShop();
                        break;
                    //player has chosen to change name
                    case 2:
                        changeName();
                        break;
                    //Player has chosen to selection a weapon
                    case 3:
                        changeWeapon();
                        break;
                    //Player has chosen to select an armor
                    case 4:
                        changeArmor();
                        break;
                    //Player wants to start battle    
                    case 5:
                        battleViewer.battle();
                        break;
                    //Player wishes to exit    
                    case 6:
                        finalPromptExit();
                        char exit = ui.inputCharacter();
                        if(exit == 'y' || exit == 'Y') {
                            noExit = false;
                        }
                        break;
                }
            }
            else {
                System.out.println("Your selection was invalid, try again.");
            }
        }
    }

    public void changeWeapon() {
        
        LinkedList<Item> weaponlist = player.getBag().getTypeList(Weapon.WEAPON);
        if(weaponlist.size() == 0) {
            System.out.println("Your bag doesn't have any weapons");
        }
        else {
            System.out.println("Choose a weapon");
            int counter = 1;
            for(Item item : weaponlist) {
                System.out.println( counter + ". " + item.getName() + item.getDescription() 
                                    + "\nMin Attack: " + item.getMinEffect() + "\nMax Attack: "
                                    + item.getMaxEffect());
                counter++;
            }
            int chosenWeapon = 0;
            boolean notExit = true;
            while(notExit) {
                try {
                    chosenWeapon = ui.inputNumber();
                }
                catch(InputMismatchException e) {
                    chosenWeapon = 0;
                }
                /*Checks if the chosen number is within the range list of item weapons */
                chosenWeapon = chosenWeapon >= MIN_CHOICE_VALUE 
                                            && chosenWeapon <= counter ? chosenWeapon : 0;
                if(chosenWeapon != 0) {
                    Item weapon = weaponlist.get(chosenWeapon - 1);
                    System.out.println("You chose: " + weapon.getName());
                    System.out.println("Do you want to equip this weapon? (Y/y/N/n)");
                    char decision = ui.inputCharacter();
                    if(decision == 'Y' || decision == 'y') {
                        player.setWeapon(weapon);
                        System.out.println("You equipped " + weapon.getName() );
                    }
                }
            }
        }
        
    }

public void changeArmor() {
        LinkedList<Item> armorlist = player.getBag().getTypeList(Armor.ARMOR);
        if(armorlist.size() != 0) {
            System.out.println("You bag does not have any armor");
        }
        else {
            System.out.println("Choose an armor");
            
            int counter = 1;
            for(Item item : armorlist) {
                System.out.println( counter + ". " + item.getName() + item.getDescription() 
                                    + "\nMin Attack: " + item.getMinEffect() + "\nMax Attack: "
                                    + item.getMaxEffect());
                counter++;
            }
            int chosenArmor = 0;
            boolean notExit = true;
            while(notExit) {
                try {
                    chosenArmor = ui.inputNumber();
                }
                catch(InputMismatchException e) {
                    chosenArmor = 0;
                }
                /*Checks if the chosen number is within the range list of item weapons */
                chosenArmor = chosenArmor >= MIN_CHOICE_VALUE 
                                            && chosenArmor <= counter ? chosenArmor : 0;
                if(chosenArmor != 0) {
                    Item armor = armorlist.get(chosenArmor - 1);
                    System.out.println("You chose: " + armor.getName());
                    System.out.println("Do you want to equip this weapon? (Y/y/N/n)");
                    char decision = ui.inputCharacter();
                    if(decision == 'Y' || decision == 'y') {
                        player.setWeapon(armor);
                        System.out.println("You equipped " + armor.getName() );
                    }
                }
            }
        }
    }
    public void changeName() {
        boolean noExit = true;
        while(noExit) {
            System.out.print("Enter Q to cancel your choice.\nEnter your name: ");
            String name = ui.inputString();
            boolean finalChoice = true;
            if(!name.trim().equals("")) {
                if(name.toUpperCase().equals("Q")) {
                    noExit = false;
                }
                else {
                    char decision;
                    while(finalChoice) {
                        System.out.println(name + " will be your name, are you sure you want to go with this? Enter Yes or No (Y/y or N/n) ");
                        
                        decision = ui.inputCharacter();
                        if(decision == 'Y' || decision == 'y') {
                            player.setName(name);
                        }
                        else {
                            finalChoice = false;
                        }
                    }
                }               
            } 
            else {
                System.out.println("You name cannot be empty. Try again.");
            }
        }
    }


    public void displayMenu() {
        System.out.println("1. Go to Shop\n2. Choose Character name\n3. Choose Weapon" +
                            "\n4 Choose armour\n5. Start Battle\n6. Exit Game");
    }

    public void finalPromptExit() {
        System.out.println("You are about to leave the game, are you sure you want to quit? Yes(Y/y) No(N/n)");
    }


}