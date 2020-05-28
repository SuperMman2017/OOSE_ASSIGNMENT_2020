/*  Player bag class that stores in-game Item objects 
    for player to keep over the course of the game*/
import java.util.LinkedList;
public class PlayerBag {

    public static final int EMPTY = 0;
    
    private LinkedList<Item> bag;
    private int maxSize;
    private int currentSize;

    public PlayerBag(int maxSize) {
        bag = new LinkedList<Item>();
        this.maxSize = maxSize;
        currentSize = 0;
    }

    /*Adds Item object to the Item bag*/
    public boolean addItem(Item item) {
        if(maxSize > currentSize) {
            bag.add(item);
            return true;
        }
        return false;
    }

    /*Returns the item matching the name parameter*/
    public Item getItem(String name) {
        for(Item i: bag) {
            if(i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    /*Removes an item from the bag*/
    public boolean removeItem(String name) {
        for(Item i: bag) {
            if(i.getName().equals(name)) {
                bag.remove(i);
                return true;
            }
        }
        return false;
    }

    /*Returns a list of items that are of the type specified in the parameter*/
    public LinkedList<Item> getTypeList(String type) {
        LinkedList<Item> typeList = new LinkedList<>();
        for(Item i: bag) {
            if(i.getItemType().equals(type)){
                typeList.add(i);
            }
        }
        return typeList;
    }

    public LinkedList<Item> getBag() {
        return bag;
    }
}