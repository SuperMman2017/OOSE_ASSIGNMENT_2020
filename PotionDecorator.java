
public abstract class PotionDecorator extends Potion{
    
    public PotionDecorator(String name, int cost) {
        super(name, cost);
    }
    
    public abstract String getDescription();

}