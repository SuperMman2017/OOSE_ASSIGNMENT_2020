/*  Class actor that can represent player/enemy 
    or possible NPC in the game*/
public interface Actor 
{
    public void attack();
    
    public void setHealth(int health);
    public void setMaxHealth(int health);
    public void setDefense(int defense);
    public void setAttack(int attack);

    public int getMaxHealth();
    public int getCurrentHealth();
    public int getDefense();
    public int getAttack();

    public String getName();

    public boolean isAlive();
}
