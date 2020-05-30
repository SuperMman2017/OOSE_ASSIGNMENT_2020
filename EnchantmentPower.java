public class EnchantmentPower extends WeaponDecorator{
    public static final String ENCHANTED_POWER = "Enchanted Power-Up ";
    public static final String ENCHANTMENT_DESCRIPTION = " Enchantment Effect: Multiplies damage by ";
    protected Weapon decoratedWeapon;
    protected int damageUp;
    public EnchantmentPower(Weapon weapon) {
        this.decoratedWeapon = weapon;
    }

    @Override public void setEnchantment(int effect) {
        this.damageUp = effect;
    }

    @Override public int getPower() {
        return (int)(this.decoratedWeapon.getPower()*damageUp);
    }

    @Override public String getName() {
        return new String(ENCHANTED_POWER + decoratedWeapon.getName());
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANTMENT_DESCRIPTION + damageUp);
    }
}