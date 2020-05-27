package Game.Character;

public abstract class GameCharacter {

    protected String name;
    protected int health;
    protected int maxHealth;

    protected int defense;
    protected int attack;
    
    /** Default constructor method for Character class
     *  health parameter is assumed as current and max health
     */
    public GameCharacter() {
    }

    public abstract GameCharacter clone();
}