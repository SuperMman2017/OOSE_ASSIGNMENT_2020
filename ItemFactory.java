public class ItemFactory {

    public ItemFactory() {

    }

    public static Item createPotion(String name, char type, int cost,int minEffect ,int maxEffect){
        Potion potion = new Potion(name,cost);
        String newDescription = new String(""+type);
        potion.setItem(name, cost, newDescription, minEffect, maxEffect);
        Item typePotion = null;
        
        if(type == 'D') {
            /*Wrap the potion object to create a potion of damage object*/ 
            typePotion = new PotionOfDamage(potion);
        }

        else if(type == 'H'){
            /*Wrap the potion object to a new Potion of healing object  */
            typePotion = new PotionOfHealing(potion);
        }
        return typePotion;
    }

    public Item createArmor(String name, String material, int cost, int minEffect, int maxEffect){
        Item armor = new Armor(name, material, minEffect, maxEffect, cost);
        return armor;
    }
}