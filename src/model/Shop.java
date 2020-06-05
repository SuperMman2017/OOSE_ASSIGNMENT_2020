package model;
import model.*;
import java.util.LinkedList;
public class Shop {
    public static double SELLING_PRICE = 0.50;
    private LinkedList<Item> shopItems;
    public Shop() {
        shopItems = new LinkedList<>();
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

    /*public void enchantDamage(Weapon weapon, int damage) {
        weapon = enchanter.enchantDamage(weapon, damage);
    }*/


    /*Finds the cheapest armor in the shop */
    public Item cheapestArmor() {
        int price = 10000;
        Item cheapestArmor = null;
        for(Item item : shopItems) {
            if(Armor.ARMOR == item.getItemType() && item.getCost() < price)  {
                price = item.getCost();
                cheapestArmor = item;
            }
        }
        if(cheapestArmor == null) {
            throw new NullPointerException("Null armor is retrieved from the shop");
        }
        return cheapestArmor;
    }


    /*Finds the cheapest weapon in the shop */
    public Item cheapestWeapon() {
        int price = 10000;
        Item cheapestWeapon = null;
        for(Item item : shopItems) {
            if(Weapon.WEAPON == item.getItemType() && item.getCost() < price)  {
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
