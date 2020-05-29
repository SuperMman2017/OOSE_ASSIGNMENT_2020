
import java.util.*;

public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private LinkedList<Loader> loader;
    public UserInterface() {
        loader = new LinkedList<>();
    }

    /*Displays loader object to user  */
    public void chooseLoader() {
        int i = 1;
        for(Loader loaderType : loader) {
            System.out.println(i + "." + loaderType.toString());
            i++;
        }
    }

    public String inputString() {
        return new String(input.nextLine());
    }

    public int inputNumber() {
        int number = 0;
        try {
            number = input.nextInt();
        }
        catch(InputMismatchException e) {
            e.printStackTrace();
        }
        return number;
    }

    public char inputCharacter() {
        return input.nextLine().charAt(0);
    }

}