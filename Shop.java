import java.util.LinkedList;
public class Shop {
    private LinkedList<Item> shopItems;

    public Shop() {
        shopItems = new LinkedList<>();
    }

    public void addItem(Item i) {
        shopItems.add(i);
    }
    
    public void removeItem(Item i) {
        shopItems.remove(i);
    }

    public Item getItem(int index) {
        return shopItems.get(index);
    }

    public LinkedList<Item> getList() {
        return shopItems;
    }
}