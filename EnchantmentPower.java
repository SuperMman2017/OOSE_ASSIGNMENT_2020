public class EnchantmentPower extends WeaponDecorator{
    public static final int ENCHANTMENT_COST = 10;
    public static final String ENCHANTED_POWER = "Enchanted Power-Up ";
    public static final String ENCHANTMENT_DESCRIPTION = " Enchantment Effect: Multiplies damage by x";
    public static final double POWER_UP = 1.1;
    protected Item decoratedWeapon;
    protected int damageUp;
    public EnchantmentPower(Item weapon) {
        this.decoratedWeapon = weapon;
    }

    @Override public void setEnchantment(int effect) {
        this.damageUp = effect;
    }

    @Override public int getPower() {
        return (int)(this.decoratedWeapon.getEffect()*POWER_UP);
    }

    @Override public String getName() {
        return new String(ENCHANTED_POWER + decoratedWeapon.getName());
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANTMENT_DESCRIPTION + damageUp);
    }
}