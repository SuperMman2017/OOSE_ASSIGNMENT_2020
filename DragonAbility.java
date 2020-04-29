public abstract class DragonAbility extends Enemy {
    protected Enemy dragon;

    public DragonAbilityEnemy dragon) {
        this.dragon = dragon;
    }

    @Override public void attack() {
        dragon.attack();
    }

    @Override public void setHealth(int health) {
        dragon.setHealth(health);
    }

    @Override public void setAttack(int attack) {
        dragon.setAttack(attack);
    }
}