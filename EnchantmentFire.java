public class EnchantmentFire extends WeaponDecorator{
    public static final String ENCHANTED_FIRE = "Enchantment Fire-Power";
    public static final String ENCHANTMENT_DESCRIPTION = " Enchantment Effect: Additional Fire damage to enemy dealing ";
    public static final int MIN_DAMAGE = 5;
    public static final int MAX_DAMAGE = 10;
    protected WeaponDecorator decoratedWeapon;
    protected int damageUp;
    public EnchantmentFire(WeaponDecorator weapon) {
        this.decoratedWeapon = weapon;
        decoratedWeapon.timesDecorated++;
    }

    @Override public void setEnchantment(int effect) {
        Probability prob = new Probability();
        damageUp = prob.getRandomNumberBetween(MIN_DAMAGE, effect);
    }

    @Override public int getPower() {
        this.setEnchantment(MAX_DAMAGE);
        return decoratedWeapon.getPower() + this.damageUp;
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANTMENT_DESCRIPTION + MIN_DAMAGE +"-" + MAX_DAMAGE);
    }
}