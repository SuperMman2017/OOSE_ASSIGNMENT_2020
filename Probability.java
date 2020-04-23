import java.util.Random; 

public class Probability
{
    private Random rand;

    public boolean getChance(int prob)
    {
        rand = new Random();
        int chance = Random.nextInt(prob+1);

        return chance <= prob;
    }
}