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

    public static void main(String []args) {
        Shop shop = new Shop();
        Player player = new Player();
        ItemFactory itemFactory = new ItemFactory(); 
        try {
            loadItems(shop, loader.Load(shopFile));
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
                if(tokens[5].toUpperCase().charAt(0) == POTION_HEAL) {
                    item = new Potion(tokens[1], );
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