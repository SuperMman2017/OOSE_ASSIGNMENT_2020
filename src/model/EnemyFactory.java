package model;
import model.*;
import Exceptions.*;
import java.util.HashMap;
import java.util.Set;

/*  EnemyFactory class stores all the enemy objects in the game for 
    store and retrieval of enemy objects to create Enemies in game */
public class EnemyFactory {
    public static final int DRAGON_SPAWN_CHANCE = 0;
    public static final int SLIME_SPAWN_CHANCE = 50;
    public static final int GOBLIN_SPAWN_CHANCE = 30;
    public static final int OGRE_SPAWN_CHANCE = 20;

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

    /*  Throws error if the new enemy object exists in the map,
         otherwise the method adds enemy object name and percentage 
         chance to the map */
    public void addEnemyChance(Enemy newEnemy, int chance) throws InvalidEnemyException {
        if(enemyChances.get(newEnemy.getName()) != null) {
            throw new InvalidEnemyException("Cannot add Enemy: "+ newEnemy.getName()+" as it already exists.");
        }
        enemyChances.put(newEnemy.getName(), chance);
    }

    /*  Returns boolean true if the enemy provided by the name in the parameter
        was removed successfully, returns false if the name of the enemy isn't listed on the 
        hash map*/
    public void setSpecificEnemy(String name,int newChance) throws InvalidEnemyException {

        if(enemyChances.get(name) == null) {
            throw new InvalidEnemyException("Cannot call this method as Enemy: " +name + " does not exist.");
        }
        enemyChances.remove(name);
        enemyChances.put(name, newChance);
    }

    /*Returns a random number */
    public Enemy getRandomEnemy() {
        Enemy enemy = null;
        Probability prob = new Probability();
        //Get a random number between 0 and the sum of probability
        int randomNumber = prob.getRandomNumberBetween(0, sumOfProbabilities());
        Set<String> keys = enemyChances.keySet();
        int percent = 0;
        for(String key : keys) {
            percent+=enemyChances.get(key);
            //Does the randon number lie between the lower and upper bound?
            if(randomNumber <= percent && randomNumber >= percent-enemyChances.get(key)) {
                enemy = enemies.get(key);
            }
        }
        return enemy.clone();
    }

    /*  This method calculates the sum of probabilities 
        in the set of probabilities of existing characters */

    private int sumOfProbabilities() {
        int sum=0;
        for(String key : enemyChances.keySet()) {
            sum+= enemyChances.get(key);
        }
        return sum;
    }

    /*Changes the spawn rate of all enemies in the map */
    public void decreaseEnemyChances(int chance) {
        Set<String> chanceSet = enemyChances.keySet();
        HashMap<String , Integer> newMap = new HashMap<>();
        for(String key : chanceSet) {
            
            /*  Remove the old spawn rate from the map
                 nd insert the new spawn rate */
            int oldChance = enemyChances.get(key);
            int newChance = oldChance - chance;
            newMap.put(key, newChance);
        }
        this.enemyChances = newMap;
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
    public Enemy getEnemy(String name) throws InvalidEnemyException {
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
    
    /*  This method returns true if the name 
        provided by the parameter exists as an enemy, 
        returnsfalse if it doesn't exist */
    public boolean check(String name) {
        return enemies.get(name) != null;
    }

}
