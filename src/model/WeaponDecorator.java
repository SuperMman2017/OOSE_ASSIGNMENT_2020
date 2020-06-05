package model;
import model.*;
/*Decorator for weapons for enchanting weapons*/
public class WeaponDecorator extends Weapon{
    public static final String ENCHANTMENT_1 = "Damage-Up";
    public WeaponDecorator() {
    }

    public WeaponDecorator(String name, int cost) {
        super(name, cost);
    }

    public void setEnchantment(int effect) {
        /*This parent method does nothing, its subclasses will override this method and set its enchantments */
    }
}
