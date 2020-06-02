import java.util.LinkedList;
public class ShopMenu {
    
    private Shop shop;
    public ShopMenu(Shop shop){
        this.shop = shop;
    }

    /*Displays the items in the shop*/
    public void displayItems() {
        for(Item item : shop.getList()) {
            System.out.println(item.getName() + " Description: " + item.getDescription());
        }
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
            shop.removeItem(item);
            successfulBuy = true;
        }
        return successfulBuy;
    }

    /*Thie method removes an item from the player bag and displays the player decision*/
    public void playerSells(Player player, Item item) {
        player.removeFromBag(item);
        player.setGold((int) (item.getCost() * 0.80) + player.getCurrentGold());
        shop.addItem(item);
    }


    /*Displays a list of items in the shop of specific type specified in the parameter */
    public void viewItemType(char type) {
        LinkedList<Item> specificItems = shop.getItemListType(type);
        for(Item item: specificItems) {
            System.out.println(item.toString());
        }
    }

    public Weapon enchantWeapon(Weapon weapon, int choice) throws InvalidChoiceException {
        /*Enchant weeapon to add addinational damage + 2*/
        WeaponDecorator decoratedWeapon = new WeaponDecorator();
        if(choice == 1) {
            decoratedWeapon = new EnchantmentDamage(weapon);
            decoratedWeapon.setEnchantment(EnchantmentDamage.ENCHANTMENT_DAMAGE_1);
        }
        else if(choice == 2) {
            decoratedWeapon = new EnchantmentDamage(weapon);
            decoratedWeapon.setEnchantment(EnchantmentDamage.ENCHANTMENT_DAMAGE_2);
        }
        else if(choice == 3) {
            decoratedWeapon = new EnchantmentPower(weapon);
        }
        else if(choice == 4) {
            decoratedWeapon = new EnchantmentFire(weapon);

        }
        else {
            throw new InvalidChoiceException(new String("Error, your selection was not valid."));
        }
        return weapon;
    }
}
