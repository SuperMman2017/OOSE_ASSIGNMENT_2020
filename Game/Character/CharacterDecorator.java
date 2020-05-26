public abstract class CharacterDecorator extends Character implements Actor{
    protected Character character;
    public CharacterDecorator(Character character) {
        super();
        this.character = character;
    }

    @Override public void setHealth(int health) {
        this.health = health;
    }

    @Override public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    @Override public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override public void setName(String name) {
        this.name = name;
    }

    @Override public int getHealth() {
        return health;
    }

    @Override public int getMaxHealth() {
        return maxHealth;
    }

    @Override public int getAttack() {
        return attack;
    }

    @Override public int getDefense() {
        return defense;
    }

    @Override public String getName() {
        return name;
    }

    @Override public void clone() {
        Character cloneChar = new CharacterDecorator();
        cloneChar.setHealth(getHealth());
        cloneChar.setMaxHealth(getMaxHealth());
        cloneChar.setAttack(getAttack());
        cloneChar.setDefense(getDefense())
        cloneChar.setName(getName());
        return cloneChar;
    }
}