public class test_weapon {
    public static void main(String [] args) {
        Weapon weapon = new WeaponDecorator("Stick", 10);
        weapon.setStat("Hurt", "Wood", 5, 10);
        weapon.setDescription(". Poke your enemies with this stick for weak damage.");
        WeaponDecorator decoratedWeapon = new EnchantmentDamage(weapon);
        decoratedWeapon.setEnchantment(10);
        System.out.println(decoratedWeapon.getName() + decoratedWeapon.getDescription());
    }
}