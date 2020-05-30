public class EnchantmentDamage extends WeaponDecorator{
    public static final String ENCHANTED_DAMAGE = "Enchantment Damage-Up";
    public static final String ENCHANMENT_DESCRIPTION = " Enchantment effect: Increased damage power by ";
    protected WeaponDecorator decoratedWeapon;
    private int damageUp;
    public EnchantmentDamage(WeaponDecorator weapon) {
        this.decoratedWeapon = weapon;
        this.timesDecorated++;
        this.decoratedWeapon.timesDecorated++;
    }

    @Override public void setEnchantment(int damageUp) {
        this.damageUp = damageUp;
    }

    @Override public int getPower() {
        return decoratedWeapon.getPower() + damageUp;
    }

    @Override public String getName(){ 
        return new String(ENCHANTED_DAMAGE+this.decoratedWeapon.getName());
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANMENT_DESCRIPTION + this.damageUp);
    }
 }