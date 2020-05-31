import java.util.HashMap;
import java.util.Set;
public class EnemyFactory {
    public static final int DRAGON_SPAWN_CHANCE = 0;
    public static final int SLIME_SPAWN_CHANCE = 50;
    public static final int GOBLIN_SPAWN_CHANCE = 30;
    public static final int OGRE_SPAWN_CHANCE = 20;
    /*Constant ERROR represents  */
    public static final int ERROR = -1;
    private HashMap<String, Enemy> enemies;
    /*Maps out the chances for each */
    private HashMap<String, Integer> enemyChances;

    /*Constructor for factory, intializes the 4 enemies and their chances */
    public EnemyFactory() {
        enemies = new HashMap<>();
        enemyChances = new HashMap<>();
        enemies.put(Dragon.DRAGON, new Dragon());
        enemies.put(Slime.SLIME, new Slime());
        enemies.put(Ogre.OGRE, new Ogre());
        enemies.put(Goblin.GOBLIN, new Goblin());
        setEnemyChances();
    }

    public void setEnemyChances() {
        enemyChances.put(Dragon.DRAGON, DRAGON_SPAWN_CHANCE);
        enemyChances.put(Slime.SLIME, SLIME_SPAWN_CHANCE);
        enemyChances.put(Ogre.OGRE, OGRE_SPAWN_CHANCE);
        enemyChances.put(Goblin.GOBLIN, GOBLIN_SPAWN_CHANCE);
    }

    public void addEnemyChance(Enemy newEnemy, int chance) {
        enemyChances.put(newEnemy.getName(), chance);
    }

    /*  Returns boolean true if the enemy provided by the name in the parameter
        was removed successfully, returns false if the name of the enemy isn't listed on the 
        hash map*/
    public boolean setSpecificEnemy(String name,int newChance) {
        boolean success = false;
        if(enemyChances.get(name) != null) {
            enemyChances.remove(name);
            enemyChances.put(name, newChance);
            success = true;
        }
        return success;
    }

    /*Changes the spawn rate of all enemies in the map */
    public void changeEnemyChances(int chance) {
        Set<String> chanceSet = enemyChances.keySet();
        for(String key : chanceSet) {

            /*  Remove the old spawn rate from the map
                 nd insert the new spawn rate */
            enemyChances.remove(key);
            enemyChances.put(key,chance);
        }
    }

    /*  Returns the chance of the enemy if name provided in the parameter exists in the map
        otherwise it will throw an InvalidEnemyException error*/
    public int getChance(String name) throws InvalidEnemyException{
        if(enemyChances.get(name) == null) {
            throw new InvalidEnemyException("Cannot call this method  as Enemy: " + name + " does not exist");
        }
        return enemyChances.get(name);
    }

    /*  Returns a clone copy of the enemy mapped by a string, returns null i. This method throws 
        InvalidEnemyException if the enemy name provided in the method parameter doesn't exist in the map*/
    public Character getEnemy(String name) throws InvalidEnemyException {
        Enemy enemy = enemies.get(name);
        if(enemy != null) {
            return enemy.clone();
        }
        else {
            throw new InvalidEnemyException("Cannot call this method as Enemy: " + name + " Does not exist.");
        }
    }

    public void addEnemy(Enemy enemy) throws InvalidEnemyException {
        if(enemies.get(enemy.getName()) != null) {
            throw new InvalidEnemyException("Cannot add Enemy: " + enemy.getName() + " as it already exists.");
        }
        enemies.put(enemy.getName(),enemy);
    }

    public void removeEnemy(String name) throws InvalidEnemyException {
        if(enemies.get(name) == null) {
            throw new InvalidEnemyException("Cannot call this method as Enemy: " + name + " Does not exist" );
        }
        enemies.remove(name);
    }
    
    public boolean check(String name) {
        return enemies.get(name) != null;
    }

}