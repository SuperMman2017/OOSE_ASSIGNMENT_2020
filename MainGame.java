import java.text.NumberFormat;
import java.util.LinkedList;

public class MainGame {
    public static final String regex = ",";
    /*potion has 1  */
    public static final int ITEM_ARG = 6;
    public static final int WEAPON_ARG = 7;
    public static final String shopFile = "shopdata.csv";

    public static final char ARMOR = 'A';
    public static final char WEAPON = 'W';
    public static final char POTION = 'P';
    public static final char POTION_HEAL = 'H';
    public static final char POTION_DAMAGE = 'D';
    private static Loader loader = new TextFileLoader(); 
    private static ItemFactory itemFactory = new ItemFactory();
    public static void main(String []args) {
        Shop shop = new Shop();
        Player player = new Player();

        try {
            loadItems(itemFactory, shop, loader.Load(shopFile));
        }
        catch(InvalidFileException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadItems(ItemFactory factory, Shop shop,LinkedList<String> fileContents) throws InvalidFileException {
        
        for(String content : fileContents) {
            String[] tokens = content.split(regex);
            /*7 arguments for armor */
            if(tokens.length == WEAPON_ARG) {
                Item item = null;
                if(tokens[0].toUpperCase().charAt(0) == WEAPON) {
                    Weapon weapon = new Weapon();
                    item = weapon;
                }
                else {
                    throw new InvalidFileException(new String("Contents in file failed to load, fix " + shopFile + " to avoid this error"));
                }
            }
            /*6 arguments for potions or armor*/
            else if(tokens.length == ITEM_ARG) {
                Item item = null;
                if(tokens[0].toUpperCase().charAt(0) == POTION) {
                    if(tokens[5].toUpperCase().charAt(0) == POTION_HEAL) {
                        try{
                            int cost = Integer.valueOf(tokens[1]);
                            int minEffect = Integer.valueOf(tokens[2]);
                            int maxEffect = Integer.valueOf(tokens[3]);
                            item = ItemFactory.createPotion(tokens[1],POTION_HEAL,cost,minEffect,maxEffect);
                        }
                        catch(NumberFormatException e) {
                            System.out.println(e.getMessage() + "Failed to load file: " + shopFile + ". Fix the file to solve error");
                        }


                    }
                }
                else if (tokens[0].charAt(0) == ARMOR){
                    Armor armor = new Armor();
                    item = armor;
                }

                if(item != null) {
                    shop.addItem(item);
                }
            }
        }
    }
}