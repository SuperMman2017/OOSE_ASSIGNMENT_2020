package model;
import model.*;
public class ItemFactory {

    public ItemFactory() {

    }

    /*  Purpose: factory method for creating Potions, wraps a potion object
                 around a potion of healing/damage based off the char paramater
                 type, this method is supposed returns Item object of potions.

        Comment: For some reason this method does not set the item attributes
                 for potion but will create and return the correct potion type
                 based on the paramater character type */
    public static Item createPotion(String name, char type, int cost,int minEffect ,int maxEffect){
        Potion potion = new Potion(name,cost);
        String newDescription = new String(""+type);
        potion.setItem(name, cost, newDescription, minEffect, maxEffect);
        Item typePotion = null;
        potion.setType(Potion.POTION);
        if(type == PotionOfDamage.POTION_OF_DAMAGE) {
            /*Wrap the potion object to create a potion of damage object*/ 
            typePotion = new PotionOfDamage(potion);
        }

        else if(type == 'H'){
            /*Wrap the potion object to a new Potion of healing object  */
            typePotion = new PotionOfHealing(potion);
        }
        return typePotion;
    }

    /*  Purpose: Create and return an Item object of type 
                 Armor based on the paramater variables*/
    public Item createArmor(String name, String material, int cost, int minEffect, int maxEffect){
        Item armor = new Armor(name, material, minEffect, maxEffect, cost);
        return armor;
    }
}
