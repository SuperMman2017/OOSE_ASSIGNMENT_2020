import java.io.CharArrayReader;
import java.util.LinkedList;
public class Shop {
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
}