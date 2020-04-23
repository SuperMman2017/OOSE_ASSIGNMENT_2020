import java.util.LinkedList;

public class BattleSystem 
{
    //A list of players in the battlefield
    private LinkedList<Actor> members;
    public BattleSystem(LinkedList<Actor> members)
    {
        this.members = members;
    }


    public void turn()
    {
        for(Actor member: members)
        {
            member.attack();
        }
    }


    
    public void doAttack(Actor player, Actor enemy)
    {

    }
}