import jdk.jfr.SettingDefinition;

public class Slime extends Actor
{
    public static final int SLIME_HEALTH = 10;
    public Slime(int minDef,int maxDef)
    {
        super("Slime", SLIME_HEALTH,SLIME_HEALTH);
        setDefense(minDef,maxDef);

    }

    @Override
    public Actor clone()
    {
        Slime slime = new Slime(getMinDefense(),getMaxDefense());
        return slime;
    }
}