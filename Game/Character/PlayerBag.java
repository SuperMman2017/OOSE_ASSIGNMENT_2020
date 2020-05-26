/*  Player bag class that stores in-game Item objects 
    for player to keep over the course of the game*/
public class PlayerBag {

    public static final int EMPTY = 0;
    private LinkedList<Item> bag;
    private int maxSize;

    public PlayerBag(int maxSize) {
        bag = new LinkedList<>();
        this.maxSize = maxSize;

    }

    /*Adds Item object to the Item bag*/
    public boolean addItem(Item item) {
        if(bag.size() < maxSize) {
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

    public boolean isFull() {
        return bag.size() == maxSize;
    }
}