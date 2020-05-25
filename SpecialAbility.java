public abstract class SpecialAbility extends Enemy {
    protected Enemy enemy;

    public SpecialAbility(Enemy enemy) {
        super(enemy.getName(), enemy.getMaxHealth());
        this.enemy = enemy;
    }

    @Override public void attack() {
        enemy.attack();
    }

    @Override public void setHealth(int health) {
        enemy.setHealth(health);
    }

    @Override public void setAttack(int attack) {
        enemy.setAttack(attack);
    }
}