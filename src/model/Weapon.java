public class Weapon extends Item{
    public static final char WEAPON = 'W';
    protected String damageType;
    protected String weaponType;

    protected int minDamage; 
    protected int maxDamage;

    /*Empty constructor for Decorating weapons */
    public Weapon() {

    }

    /*Normal constructor for concrete weapons */
    public Weapon(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    /*Setter that sets the damage and type of the weapon*/
    public void setStat(String name, String damageType, String weaponType, int minDamage, int maxDamage) {
        this.name = name;
        setType(WEAPON);
        setDamageType(damageType);
        setWeaponType(weaponType);
        setDamage(minDamage, maxDamage);
    }

    public void setDamage(int minDamage, int maxDamage) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
    
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public int getPower() {
        return getEffect();
    }

    public String getDamageType() {
        return damageType;
    }

    public String getWeaponType() {
        return weaponType;
    }

    @Override public void doEffect(Character c) {
        c.setAttack(getPower());
    }

    @Override public String getDescription() {
        return new String(this.name + " is a " + this.weaponType + " and deals a damage type of " + damageType);
    }
}
