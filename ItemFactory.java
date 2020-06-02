public class ItemFactory {

    public ItemFactory() {

    }

    public Item createPotion(String name, char type, int cost, char potionType, int effect){
        Potion potion = new Potion(name,cost, potionType);
        Item typePotion = null;
        
        if(potionType == 'D') {
            /*Wrap the potion object to create a potion of damage object*/ 
            typePotion = new PotionOfDamage(potion);
        }

        else if(potion.getPotionType() == 'H'){
            /*Wrap the potion object to a new Potion of healing object  */
            typePotion = new PotionOfHealing(potion);
        }
        return typePotion;
    }
}