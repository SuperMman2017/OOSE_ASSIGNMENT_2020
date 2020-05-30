/*Decorator for weapons for enchanting weapons*/
public abstract class WeaponDecorator extends Weapon{
    public WeaponDecorator(){ 

    }

    public abstract void setEnchantment(int effect);
}