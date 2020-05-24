
public class class_tester {

    public static void main(String args[])
    {
        testSlime();   
        
        testDragon();

        testGoblin();

        testOgre();
        
        testPlayer();
    }

    public static void testSlime()
    {
        Enemy slime = new Slime();
        Actor act = (Actor)slime;

        System.out.println(act.toString() );
    }

    public static void testDragon()
    {
        Enemy dragon = new Dragon();
        Actor act = (Actor)dragon;
        
        System.out.println(act.toString() );
    }

    public static void testOgre()
    {
        Enemy ogre = new Ogre();
        Actor act = (Actor)ogre;
        Enemy downcast = (Enemy)act;
        downcast.specialAbility();
        System.out.println(act.toString() );
    }

    public static void testGoblin()
    {
        Enemy goblin = new Goblin();
        Actor act = (Actor)goblin;
        
        System.out.println(act.toString() );
    }

    public static void testPlayer()
    {
        Player player = new Player();
        Actor upcast = (Actor)player;
        Player downcast = (Player)upcast;
        downcast.getCurrentGold();
        System.out.println(downcast.toString() );
    }
}