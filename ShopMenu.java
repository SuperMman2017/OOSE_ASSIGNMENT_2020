public class ShopMenu {
    private ShopViewer shopView;
    
    public ShopMenu(Shop shop){
        shopView = new ShopViewer(shop);
    }

    /*Displays the items in the shop*/
    public void browse() {
        shopView.viewItems();
    }

    /*  This method removes the item from the shop 
        and is added to the player bag, the method 
        returns false if the player object does not
        have enough gold to purchase the item*/
    public boolean playerBuys(Player player, Item item) {
        boolean successfulBuy = false;
        if(player.getCurrentGold() >= item.getCost() && player.getPlayerBag().getBag().size() < Player.MAX_BAG_SIZE ) {
            player.setGold(player.getCurrentGold() - item.getCost());
            player.addToBag(item);
            shopView.displayBoughtItem(item);
            successfulBuy = true;
        }
        return successfulBuy;
    }

    /*Thie method removes an item from the player bag and displays the player decision*/
    public void playerSells(Player player, Item item) {
        player.removeFromBag(item);
        player.setGold((int) (item.getCost() * 0.80) + player.getCurrentGold());
        shopView.addToShop(item);
        shopView.displaySoldItem(item);
    }

}