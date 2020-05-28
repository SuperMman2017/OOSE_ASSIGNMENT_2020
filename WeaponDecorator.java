/*Decorator for weapons*/
public abstract class WeaponDecorator extends Item {
    protected Weapon weapon;
    public WeaponDecorator(Weapon weapon){ 
        this.weapon = weapon;
    }
}