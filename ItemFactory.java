public class ItemFactory {

    public ItemFactory() {

    }

    public Item createPotion(String name, char type, int cost, char potionType,int minEffect ,int maxEffect){
        Potion potion = new Potion(name,cost, potionType);
        String newDescription = new String(""+type);
        potion.setItem(name, cost, newDescription, minEffect, maxEffect);
        Item typePotion = null;
        
        if(potionType == 'D') {
            /*Wrap the potion object to create a potion of damage object*/ 
            typePotion = new PotionOfDamage(potion);
        }

        else if(potionType == 'H'){
            /*Wrap the potion object to a new Potion of healing object  */
            typePotion = new PotionOfHealing(potion);
        }
        return typePotion;
    }
}