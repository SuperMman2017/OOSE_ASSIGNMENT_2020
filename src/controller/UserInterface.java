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
        return new String(input.next());
    }

    /*Return -1 if the input is not an integer number */
    public int inputNumber() {
        int number = 0;
        try {
            String in = input.next();
            number = Integer.parseInt(in);
        }
        catch(NumberFormatException e) {
            number = -1;
        }
        return number;
    }

    public char inputCharacter() {
        char in = input.next().charAt(0);
        return in;
    }

}