package Game.Character;

public interface Actor {
    public void setHealth(int health);
    public void setMaxHealth(int maxHealth);
    public void setDefense(int defense);
    public void setAttack(int attack);
    public void setName(String name);

    public int getHealth();
    public int getMaxHealth();
    public int getDefense();
    public int getAttack();
    public String getName();

}