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
        }
        int playerChoice = 0;
        try{ 
            playerChoice = 
        }
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