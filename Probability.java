import java.util.Random; 

public class Probability {
    private static Random rand;
    public static final int MAX_CHANCE = 100;

    public Probability() {

        rand = new Random();
    }

    /**Returns boolean of the probability occured for the paramater prob **/
    public boolean getChance(int prob) {

        if(prob >= 100) {
            return true;
        }
        int chance = rand.nextInt();
        return chance >= prob;
    }

    /**Returns a pseudo-random number between upper bound and lower bound**/
    public int getRandomNumberBetween(int lowerBound, int upperBound) {
        return rand.nextInt(upperBound - lowerBound+1) + lowerBound;
    }

}