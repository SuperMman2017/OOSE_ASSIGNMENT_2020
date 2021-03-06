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
        this.setEffect(weapon.getMinEffect(), weapon.getMaxEffect());
    }

    @Override public void setEnchantment(int damageUp) {
        this.damageUp = damageUp;
    }

    @Override public int getEffect() {
        return decoratedWeapon.getEffect() + damageUp;
    }

    @Override public String getName(){ 
        return ENCHANTED_DAMAGE + " " + this.decoratedWeapon.getName();
    }

    @Override public String getDescription() {
        return new String(decoratedWeapon.getDescription() + ENCHANMENT_DESCRIPTION + this.damageUp);
    }

    @Override public char getItemType() {
        return decoratedWeapon.getItemType();
    }

    @Override public int getCost() {
        return decoratedWeapon.getCost();
    }
 }
