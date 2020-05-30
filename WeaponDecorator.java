/*Decorator for weapons for enchanting weapons*/
public abstract class WeaponDecorator extends Weapon{
    /*Applied restrictions to decorations of up to max four enchantments */
    protected int timesDecorated;
    public WeaponDecorator(){ 
        this.timesDecorated = 0;
    }

    public int getCounter() {
        return this.timesDecorated;
    }

    public abstract void setEnchantment(int effect);
}