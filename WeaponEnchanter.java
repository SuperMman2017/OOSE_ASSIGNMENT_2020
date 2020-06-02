/*This class is used to enchant weapons*/
public class WeaponEnchanter {
    public static final int ENCHANT_MIN = 1;
    public static final int ENCHANT_MAX = 4;
    public static final int FIRE_DAMAGE = 10;
    public WeaponEnchanter() {

    }

    public Weapon enchantFire(Weapon weapon) {
        WeaponDecorator decoratedWeapon = new EnchantmentFire(weapon);
        return decoratedWeapon;
    }

    public Weapon enchantDamage(Weapon weapon, int damage) {
        WeaponDecorator decoratedWeapon = new EnchantmentDamage(weapon);
        decoratedWeapon.setEnchantment(damage);
        return decoratedWeapon;
    }

    public Weapon enchantPower(Weapon weapon) {
        WeaponDecorator decoratedWeapon = new EnchantmentPower(weapon);
        return decoratedWeapon;
    }
}