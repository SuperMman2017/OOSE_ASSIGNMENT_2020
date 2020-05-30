public class Weapon extends Item{

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
    public void setStat(String damageType, String weaponType, int minDamage, int maxDamage) {
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
        Probability prob = new Probability();
        return prob.getRandomNumberBetween(minDamage, maxDamage);
    }

    public String getDamageType() {
        return damageType;
    }

    public String getWeaponType() {
        return weaponType;
    }
}