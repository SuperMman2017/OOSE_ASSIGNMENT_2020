import java.util.LinkedList;
public class Shop {
    private LinkedList<Item> shopItems;
    private WeaponEnchanter enchanter;
    public Shop() {
        shopItems = new LinkedList<>();
        enchanter = new WeaponEnchanter();
    }

    /*Adds an item object to the list of items in the shop */
    public void addItem(Item i) {
        shopItems.add(i);
    }
    
    /*Removes an item object matching the object item parameter */
    public void removeItem(Item i) {
        shopItems.remove(i);
    }

    /*Returns an Item object at a specific index */
    public Item getItem(int index) {
        return shopItems.get(index);
    }

    /*Returns the list of items in the shop */
    public LinkedList<Item> getList() {
        return shopItems;
    }

    /*Retuns a list of item objects that are specific to the type provided by the parameter*/
    public LinkedList<Item> getItemListType(char type){
        LinkedList<Item> list = new LinkedList<>();
        for(Item item : shopItems) {
            if(item.getItemType() == type) {
                list.add(item);
            }
        }
        return list;
    }

    public void enchantDamage(Weapon weapon, int damage) {
        weapon = enchanter.enchantDamage(weapon, damage);
    }

    public Item cheapestArmor(Player player) {
        int price = 10000;
        Item cheapestArmor = null;
        for(Item item : shopItems) {
            System.out.println(item.getCost());
            item.doEffect(player);
            if(Armor.ARMOR == item.getItemType() && price > item.getCost())  {
                
                price = item.getCost();
                cheapestArmor = item;
            }
        }
        if(cheapestArmor == null) {
            throw new NullPointerException("Null armor is retrieved from the shop");
        }
        return cheapestArmor;
    }

    public Item cheapestWeapon(Player player) {
        int price = 10000;
        Item cheapestWeapon = null;
        for(Item item : shopItems) {
            System.out.println(item.getCost());
            item.doEffect(player);
            if(Weapon.WEAPON == item.getItemType() && price > item.getCost())  {
                price = item.getCost();
                cheapestWeapon = item;
            }
        }
        if(cheapestWeapon == null) {
            throw new NullPointerException("Null weapon is retrieved from the Shop");
        }
        return cheapestWeapon;
        
    }
}