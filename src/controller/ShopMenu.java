import java.util.LinkedList;
public class ShopMenu {
    
    private Shop shop;
    public ShopMenu(Shop shop){
        this.shop = shop;
    }

    /*Displays the items in the shop*/
    public void displayItems() {
        int counter = 1;
        for(Item item : shop.getList()) {
            if(item.getItemType() != Potion.POTION) {
                if(item.getItemType() == Weapon.WEAPON) {
                    System.out.println( counter + ". " + item.getName() + " Description: " + item.getDescription() + ", COST: " + item.getCost()
                                        + "\nPotential Damage " + item.getMinEffect() + "-"+ item.getMaxEffect());
                }
                else if (item.getItemType() == Armor.ARMOR) {
                    System.out.println(counter + ". " + item.getName() + " Description " + item.getDescription() + ", COST:" + item.getCost() +
                                        "\nPotential Defense " + item.getMinEffect() + "-" + item.getMaxEffect());
                }                
            }
            else {
                if(item.getDescription().charAt(0) == PotionOfHealing.POTION_OF_HEALING) {
                    System.out.println( counter + ". " + item.getName() + " Description: " + PotionOfHealing.POTION_HEALING_DESCRIPTION + ", COST: " + item.getCost() 
                                         + "\nPotential Effect " + item.getMinEffect() + "-" + item.getMaxEffect());
                }
                else if(item.getDescription().charAt(0) == PotionOfDamage.POTION_OF_DAMAGE) {
                    System.out.println( counter + ". " + item.getName() + " Description: " + PotionOfDamage.POTION_DAMAGE_DESCRIPTION + ", COST: " + item.getCost() 
                                         + "\nPotential Effect " + item.getMinEffect() + "-" + item.getMaxEffect());
                }
            }
            counter++;
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
            successfulBuy = true;
        }
        return successfulBuy;
    }

    /*Thie method removes an item from the player bag and displays the player decision*/
    public void playerSells(Player player, Item item) {
        player.removeFromBag(item);
        player.setGold((int)(item.getCost() * Shop.SELLING_PRICE) + player.getCurrentGold());
        shop.addItem(item);
    }


    /*Displays a list of items in the shop of specific type specified in the parameter */
    public void viewItemType(char type) {
        LinkedList<Item> specificItems = shop.getItemListType(type);
        for(Item item: specificItems) {
            
            System.out.println(item.toString());
        }
    }
    
    public int goldPrice(int choice) {
        int goldprice = 0;
        if(choice == 1) {
            goldprice = EnchantmentDamage.ENCHANTMENT_COST;
        }
        else if(choice == 2) {
            goldprice = EnchantmentDamage.ENCHANT_COST_2;
        }
        else if(choice == 3) {
            goldprice = EnchantmentPower.ENCHANTMENT_COST;
        }
        else if(choice == 4) {
            goldprice = EnchantmentFire.ENCHANTMENT_COST;
        }
        return goldprice;
    }

    public Item enchantWeapon(Item weapon, int choice) throws InvalidChoiceException {
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
        Item newItem = decoratedWeapon;
        return newItem;
    }

    public int getStock() {
        return shop.getList().size();
    }

    public LinkedList<Item> itemStock() {
        return shop.getList();
    }
}
