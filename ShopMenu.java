public class ShopMenu {
    private ShopViewer shopView;

    public ShopMenu(Shop shop){
        shopView = new ShopViewer(shop);
    }

    public void browse() {
        shopView.viewItems();
    }

    public void playerBuys(Player player, Item item) {
        if(player.getCurrentGold() >= item.getCost() && player.getPlayerBag().getBag().size() < Player.MAX_BAG_SIZE ) {
            player.setGold(player.getCurrentGold() - item.getCost());
            player.addToBag(item);
            shopView.itemSold(item);

        }
    }

    public void playerSells(Player player, Item item) {
        player.removeFromBag(item);
        player.setGold((int) (item.getCost() * 0.80) + player.getCurrentGold());
        shopView.addToShop(item);
    }
}