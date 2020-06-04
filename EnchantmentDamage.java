public class EnchantmentDamage extends WeaponDecorator{
    public static final int ENCHANTMENT_COST = 5;
    public static final int ENCHANT_COST_2 = 10;
    public static final int ENCHANTMENT_DAMAGE_1 = 2;
    public static final int ENCHANTMENT_DAMAGE_2 = 5;
    public static final String ENCHANTED_DAMAGE = " Enchantment Damage-Up ";
    public static final String ENCHANMENT_DESCRIPTION = " Enchantment effect: Increased damage power by +";
    protected Item decoratedWeapon;
    private int damageUp;
    public EnchantmentDamage(Item weapon) {
        this.decoratedWeapon = weapon;
    }

    @Override public void setEnchantment(int damageUp) {
        this.damageUp = damageUp;
    }

    @Override public int getPower() {
        return decoratedWeapon.getEffect() + damageUp;
    }

    @Override public String getName(){ 
        return ENCHANTED_DAMAGE + decoratedWeapon.getName();
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANMENT_DESCRIPTION + this.damageUp);
    }
 }