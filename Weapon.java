
public class Weapon extends Item{

    private String damageType;
    private String weaponType;

    private int minDamage; 
    private int maxDamage;

    public Weapon(String name, int cost) {
        super(name, cost);

    }

    public Weapon(String name, int cost, String damageType, String weaponType, int minDamage, int maxDamage) {
        super(name, cost);
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