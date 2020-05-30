public class test_weapon {
    public static void main(String [] args) {
        Weapon weapon = new Weapon("Stick", 10);
        weapon.setStat("Hurt", "Wood", 5, 10);
        weapon.setDescription(". Poke your enemies with this stick for weak damage.");
        EnchantmentDamage decoratedWeapon = new EnchantmentDamage(weapon);
        decoratedWeapon.setEnchantment(10);
        System.out.println(decoratedWeapon.getName() + decoratedWeapon.getDescription());
    }
}