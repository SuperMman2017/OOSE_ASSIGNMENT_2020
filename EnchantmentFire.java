public class EnchantmentFire extends WeaponDecorator{
    public static final int ENCHANTMENT_COST = 20;
    public static final String ENCHANTED_FIRE = "Enchantment Fire-Power";
    public static final String ENCHANTMENT_DESCRIPTION = " Enchantment Effect: Additional Fire damage to enemy dealing +";
    public static final int MIN_DAMAGE = 5;
    public static final int MAX_DAMAGE = 10;
    protected Item decoratedWeapon;
    protected int damageUp;
    public EnchantmentFire(Item weapon) {
        this.decoratedWeapon = weapon;
        this.setEffect(weapon.getMinEffect(), weapon.getMaxEffect());
    }

    @Override public void setEnchantment(int effect) {
        Probability prob = new Probability();
        damageUp = prob.getRandomNumberBetween(MIN_DAMAGE, effect);
    }


    @Override public int getEffect() {
        this.setEnchantment(MAX_DAMAGE);
        return decoratedWeapon.getEffect() + this.damageUp;
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANTMENT_DESCRIPTION + MIN_DAMAGE +"-" + MAX_DAMAGE);
    }

    @Override public String getName(){
        return new String( ENCHANTED_FIRE + " " + decoratedWeapon.getName());
    }

    @Override public char getItemType() {
        return decoratedWeapon.getItemType();
    }

    @Override public int getCost() {
        return decoratedWeapon.getCost();
    }
}