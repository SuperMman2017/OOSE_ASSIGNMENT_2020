import java.util.Random; 

public class Probability
{
    private static Random rand;

    public static boolean getChance(int prob)
    {
        rand = new Random();
        int chance = rand.nextInt(prob+1);

        return chance >= prob;
    }
}