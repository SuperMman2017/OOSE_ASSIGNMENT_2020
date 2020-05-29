
import java.util.*;

public class UserInterface {
    private Scanner input = new Scanner(System.in);
    private LinkedList<Loader> loader;
    Loader currentLoader;
    public UserInterface() {
        loader = new LinkedList<>();
        currentLoader = null;
    }

    /*Displays loader object to user  */
    public void chooseLoader() throws InvalidChoiceException {
        int max = loader.size();
        int choice = inputNumber();
        if(choice > max) {
            throw new InvalidChoiceException(new String(choice + " is not an option listed."));
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