/*Decorator for weapons for enchanting*/
public abstract class WeaponDecorator extends ItemDecorator {
    protected Weapon weapon;
    protected int cost;
    public WeaponDecorator(Weapon weapon, int cost){ 
        this.weapon = weapon;
        this.cost = cost;
    }
    
    /*Character's gold is decreased, effect will be applied to the weapon object*/
    @Override public void doEffect(Character c) {
        c.setGold(c.getGold() - this.cost);
    }
}