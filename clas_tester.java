
public class clas_tester {

    public static void main(String args[])
    {
        testSlime();   
        
        testDragon();

        testGoblin();

        testOgre();
    }

    public static void testSlime()
    {
        Enemy slime = new Slime();
        Actor act = (Actor)slime;

        System.out.println(act.toString() + act.getDefense());
    }

    public static void testDragon()
    {
        Enemy dragon = new Dragon();
        Actor act = (Actor)dragon;
        
        System.out.println(act.toString() + act.getDefense());
    }

    public static void testOgre()
    {
        Enemy ogre = new Ogre();
        Actor act = (Actor)ogre;

        System.out.println(act.toString() + act.getDefense());
    }

    public static void testGoblin()
    {
        Enemy goblin = new Goblin();
        Actor act = (Actor)goblin;
        
        System.out.println(act.toString() + act.getDefense());
    }
}