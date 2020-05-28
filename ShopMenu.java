public class ShopMenu {
    private ShopViewer shopView;

    public ShopMenu(){
        shopView = new ShopViewer;
    }

    public void browse(char choice) {
        System.out.println("You can Filter items by type by pressing (F/f)\n");
        viewItemType();
        if(choice == 'f' || choice == 'F') {
            System.out.println();
        }
    }

    public void playerBuys(Player player, Item item) {
        if(player.getGold() >= item.getCost() && player.getBag().size() < player.MAX_BAG_SIZE {
            player.setGold(player.getGold() - item.getCost());
            player.addItem(item);
            shopView.itemSold(item);

        }
    }

    public void playerSells(Player player, Item item) {
        player.removeFromBag(item);
        player.setGold((int)(item.getCost()*0.80) + player.getGold());
        shopView.addToShop(item);
    }
}