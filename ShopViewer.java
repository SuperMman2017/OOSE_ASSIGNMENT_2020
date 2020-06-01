import java.util.LinkedList;
public class ShopViewer {
    private ShopMenu shopController;
    public ShopViewer(ShopMenu shopController) {
        this.shopController = shopController;
    }

    /*Displays the list of items available in the Shop */
    public void viewItems(){
        for(Item item : shop.getList()) {
            System.out.println(item.toString());
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
    public void viewItemType(Shop shop, char type) {
        LinkedList<Item> specificItems = shop.getItemListType(type);
        for(Item item: specificItems) {
            System.out.println(item.toString());
        }
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