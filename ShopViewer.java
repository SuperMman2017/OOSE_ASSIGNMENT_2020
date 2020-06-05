import java.util.InputMismatchException;
import java.util.LinkedList;

public class ShopViewer {
    private Player player;
    private ShopMenu shopController;
    private UserInterface ui;
    public ShopViewer(UserInterface ui, ShopMenu shopController, Player player) {
        this.shopController = shopController;
        this.ui = ui;
        this.player = player;
    }

    public void startShop() {
        
        boolean notDone = true;
        System.out.println("Welcome to the shop!");
        while(notDone) {
            displayShopChoice();
            int shopChoice =-1;
            boolean noExit = true;
            while(noExit) {
                try {
                    shopChoice = ui.inputNumber();
                }
                catch(InputMismatchException e ){
                    shopChoice = -1;
                }
                shopChoice = shopChoice >= 1 && shopChoice <= 4 ? shopChoice : -1;
                if(shopChoice == -1) {
                    System.out.println("You selection was invalid, try again.");
                }
                else {
                    noExit = false;
                    switch(shopChoice) {
                        case 1: 

                            buyItem();
                            break;

                        case 2: 
                            sellItem();
                            break;

                        case 3:
                            upgradeWeapon();
                            break;
                        case 4:
                            System.out.println("Leaving shop."); 
                            notDone = false;
                            break;
                    }
                }
            }
        }        
    }

    public void buyItem(){ 
        System.out.println("Select from items listed below");
        boolean notDone = true;
        while(notDone) {
            int buyChoice = -1;
            shopController.displayItems();
            System.out.println("Enter 0 if you wish to go back.");
            try {
                buyChoice = ui.inputNumber();
            }
            catch(NumberFormatException e) {
                buyChoice = -1;
            }
            buyChoice = buyChoice == 0 || (buyChoice >= GameViewer.MIN_CHOICE_VALUE &&
                        buyChoice <= shopController.getStock()) ? buyChoice : -1;
            if(buyChoice == -1) {
                System.out.println("Your input was invalid, try again.");
            }
            /*Check  */
            else if(    buyChoice >= GameViewer.MIN_CHOICE_VALUE && 
                        buyChoice <= shopController.getStock()) {
                    Item item = shopController.itemStock().get(buyChoice - 1);
                    System.out.println("Are you sure you want to buy " + item.getName() + "?\n Enter Yes or No(Y/y/N/n)");
                    char confirm = ui.inputCharacter();
                    if(confirm == 'Y' || confirm =='y') {
                        boolean canbuy = shopController.playerBuys(player, item);
                        if(canbuy) {
                            notDone = false;
                            System.out.println("You successfully bought " + item.getName());
                        }
                        else {
                            System.out.println("You do not have enough to buy " + item.getName());
                        }

                    }
                   
                }

            else if(buyChoice == 0) {
                notDone = false;
            }
        }
    }

    public void sellItem() {
        System.out.println("These are the items in your bag.");
        displayPlayerSell(player);
        boolean noExit = true;
        int sellChoice = -1;
        while(noExit) {
            System.out.println("Enter 0 if you wish to exit.");
            try {
                sellChoice = ui.inputNumber();
            }
            catch(NumberFormatException e) {
                sellChoice = -1;
            }
            sellChoice = sellChoice == 0 || (sellChoice >= GameViewer.MIN_CHOICE_VALUE && 
                         sellChoice <= player.getPlayerBag().getBag().size()) ? sellChoice : -1;
            if(sellChoice == 0) {
                noExit = false;
            }
            else if(sellChoice == -1) {
                System.out.println("Your input was invalid, try again");
            }
            else {
                Item sellingItem = player.getPlayerBag().getBag().get(sellChoice-1);
                if(sellingItem.equals(player.getCurrentArmor()) || sellingItem.equals(player.getCurrentWeapon())) {
                    System.out.println("You cannot sell your equipped items, unequip them first.");
                }
                else {
                    System.out.println("You are selling " + sellingItem.getName() + ". Are you sure you want to sell this?"
                                        + "Yes/No (Y/y/N/n)");
                    char finalChoice = ui.inputCharacter();
                    if(finalChoice == 'Y' || finalChoice == 'y') {
                        noExit = true;
                        shopController.playerSells(player, sellingItem);
                        System.out.println("You sold " + sellingItem.getName());
                    }
                }   
            }
        }
    }

    public void upgradeWeapon() {
        System.out.println("Choose an item from your inventory that you want to upgrade");
        

        boolean noExit = true;
        int playerChoice = -1;
        while(noExit) {

            LinkedList<Item> playerbag = player.getPlayerBag().getTypeList(Weapon.WEAPON);
            int count = 1; 
            /*Display the upgradable weapons in the player bag */
            for(Item item : playerbag) {
                System.out.println(count + ". " + item.getName() + "Description: " + item.getDescription());
                count++;
            }
            try{ 
                playerChoice = ui.inputNumber();
            }
            catch(InputMismatchException e ) {
                System.out.println("The option you selected was invalid, try again or enter 0 to quit.");
                playerChoice = -1;
            }
            playerChoice = playerChoice == 0 || (playerChoice >= 1 && playerChoice <= count) ? playerChoice : -1;
            /*User wishes to quit enchanting at weapon selection */
            if(playerChoice == 0) {
                noExit = false;
            }
            else if(playerChoice != -1) {
                boolean notDone = true;
                while(notDone)
                { 
                    Item weaponChosen = playerbag.get(playerChoice - 1);
                    /*Asks user for a number to corresponding to which enchantment type they want */
                    int chosenEnchantment = chooseEnchantment();
                    int price = shopController.goldPrice(chosenEnchantment);
                    if(chosenEnchantment == 0) {
                        notDone = false;
                    }
                    else if(player.getCurrentGold() >= price) {
                        boolean upgradingCurrentWeapon = false;
                        player.setGold(Math.max(0,player.getCurrentGold() - price));
                        if(player.getCurrentWeapon().equals(weaponChosen)) {
                            upgradingCurrentWeapon = true;
                        }
                        try {
                            Item enchantedWeapon = shopController.enchantWeapon(weaponChosen, chosenEnchantment);
                            player.removeFromBag(weaponChosen);
                            player.addToBag(enchantedWeapon);
                            if(upgradingCurrentWeapon) {
                                player.setWeapon(enchantedWeapon);
                            }
                        }
                        catch(InvalidChoiceException ee) {
                            System.out.println("Failed to enchant Weapon");
                        }
                    }
                    else {
                        System.out.println("You cannot afford this enchantment.");
                    }
                    notDone = false;
                    noExit = false;
                }
            }  
       } 
    }

    public int chooseEnchantment() {
        int enchantmentChoice = -1;
        while(enchantmentChoice == -1) {
            displayEnchantments();
            try {
                enchantmentChoice = ui.inputNumber();
            }
            catch(InputMismatchException e ) {
                enchantmentChoice = -1;
            }
            /*The user may only be able to choose a number selection between 1-4 or 0 as an exit */
            if(  enchantmentChoice < WeaponEnchanter.ENCHANT_MIN &&
                 enchantmentChoice > WeaponEnchanter.ENCHANT_MAX && enchantmentChoice != 0) {
                 enchantmentChoice = -1;
                System.out.println("Your selection is invalid try again or enter 0 to go back");
            }
        }
        return enchantmentChoice;
    }

    public void displayEnchantments() {
        System.out.println("1. " + EnchantmentDamage.ENCHANTED_DAMAGE +" " +
                                   EnchantmentDamage.ENCHANMENT_DESCRIPTION + 
                                   EnchantmentDamage.ENCHANTMENT_DAMAGE_1 + " Cost: " +
                                   EnchantmentDamage.ENCHANTMENT_COST);
        System.out.println("2. " + EnchantmentDamage.ENCHANTED_DAMAGE +" " +
                                   EnchantmentDamage.ENCHANMENT_DESCRIPTION + 
                                   EnchantmentDamage.ENCHANTMENT_DAMAGE_2 + " Cost: " +
                                   EnchantmentDamage.ENCHANT_COST_2);
        System.out.println("3. " + EnchantmentPower.ENCHANTED_POWER + " " +
                                   EnchantmentPower.ENCHANTMENT_DESCRIPTION + 
                                   EnchantmentPower.POWER_UP + " Cost: " +
                                   EnchantmentFire.ENCHANTMENT_COST);
        System.out.println("4. " + EnchantmentFire.ENCHANTED_FIRE + " " + 
                                   EnchantmentFire.ENCHANTMENT_DESCRIPTION + " " +
                                   EnchantmentFire.MIN_DAMAGE + "-" + EnchantmentFire.MAX_DAMAGE +
                                   " Cost: " + EnchantmentFire.ENCHANTMENT_COST);
    }


    public void displayShopChoice() {
        System.out.println("1. Buy\n2. Sell Item\n3. Enchant Weapon\n4. Leave shop");
    }

    public void displaySoldItem(Item item) {
        System.out.println("You sold " + item.getName() + " for " + (int)(item.getCost()*Shop.SELLING_PRICE) + " gold.");
    }

    public void displayBoughtItem(Item item) {
        System.out.println("You bought " + item.getName() + " for " + item.getCost() + " gold.");
    }

    /*Displays a list of items in the shop of specific type specified in the parameter */
    public void viewItemType(char type) {
        shopController.viewItemType(type);
    }

    public void displayCommand() {
        System.out.println("1. Buy Items\n2. Sell Item\n3. Exit");
    }

    public void displayBuyDecision(Item item) {
        System.out.println("Do you want to purchase "  + 
                            item.getName() + " for " + item.getCost() + "?"
                            + "Yes (Y/y)\nNo (N/n)?");
    }

    public void displayPlayerSell(Player player) {
        int counter = 1;
        for(Item item : player.getPlayerBag().getBag())  {
            System.out.println(counter + ". " + item.getName() + ", Cost: " + (int)(item.getCost() * Shop.SELLING_PRICE));
            counter++;
        }
    }

    public void displaySellDecision(Item item) {
        System.out.println("You are selling " +item.getName() + " for " 
                            + (int)(item.getCost()*0.80) + "\nConfirm Yes (Y/y) or No (N/n)" );
    }

    public void displayInvalidPurchase() {
        System.out.println("You cannot purchase this item.");
    }
}