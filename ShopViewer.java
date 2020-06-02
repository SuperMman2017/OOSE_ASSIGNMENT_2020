import java.util.InputMismatchException;
import java.util.LinkedList;
public class ShopViewer {
    private Player player;
    private ShopMenu shopController;
    private UserInterface ui;
    public ShopViewer(UserInterface ui, ShopMenu shopController, Player player) {
        this.shopController = shopController;
        this.ui = ui;
    }

    public void startShop() {
        
        boolean notDone = true;
        System.out.println("Welcome to the shop!");
        while(notDone) {
            displayShopChoice();
            
        }        
    }

    public void purchaseWeapon() {

    }

    public void purchaseItem() {

    }

    public void purchaseArmor() {

    }

    public void upgradeWeapon() {
        System.out.println("Choose an item from your inventory that you want to upgrade");
        LinkedList<Item> playerbag = player.getBag().getBag();
        int count = 1;
        for(Item item : playerbag) {
            if(item.getItemType() == 'W') {
                System.out.println(count + ". " + item.getName() + "Description: " + item.getDescription());
            }
            count++;
        }

        int playerChoice = -1;
        while(playerChoice == -1 )
        try{ 
            playerChoice = ui.inputNumber();
        }
        catch(InputMismatchException e ) {
            System.out.println("The option you selected was invalid, try again or enter 0 to quit.");
            playerChoice = -2;
        }
        if(playerChoice < 1 || playerChoice > count) {
            System.out.println("The choice you entered was out of range or invalid, try again.");
        }
        else {
            if(player.getBag().getBag().get(playerChoice) instanceof Weapon) {
            /*I CBF */
                Weapon weaponChosen = (Weapon)player.getBag().getBag().get(playerChoice);
                int chosenEnchantment = chooseEnchantment();
                boolean upgradingCurrentWeapon = false;
                if(player.getCurrentWeapon().equals(weaponChosen)) {
                    upgradingCurrentWeapon = true;
                }
                if(chosenEnchantment != 0) {
                    player.removeFromBag(weaponChosen);
                    try {
                        Weapon enchantedWeapon = shopController.enchantWeapon(weaponChosen, chosenEnchantment);
                        player.addToBag(enchantedWeapon);
                        if(upgradingCurrentWeapon) {
                            player.setWeapon(enchantedWeapon);
                        }
                    }
                    catch(InvalidChoiceException ee) {
                        System.out.println("Failed to enchant Weapon");
                    }
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
        System.out.println("1. Buy\n2. Sell Item\n3. Enchant Weapon");
    }

    public void displaySoldItem(Item item) {
        System.out.println("You sold " + item.getName() + " for " + (int)(item.getCost()*0.80) + " gold.");
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
        for(Item item : player.getPlayerBag().getBag())  {
            System.out.println(item.getName() + ", Cost: " + (int)(item.getCost() * 0.80));
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