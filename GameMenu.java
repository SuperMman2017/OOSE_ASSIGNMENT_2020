import java.util.InputMismatchException;

public class GameMenu {
    private UserInterface ui;
    public GameMenu(UserInterface ui) {
        this.ui = ui;
    }

    public int getMenuChoice(){
        int chosenInput = 0;
        
        while(chosenInput <= 0) {
            try {
                chosenInput = ui.inputNumber();
                /*User input, */
                chosenInput = chosenInput >= GameViewer.MIN_CHOICE_VALUE && chosenInput
                                             <= GameViewer.MAX_CHOICE_VALUE ? chosenInput : 0;
            }
            catch(InputMismatchException e) {
                chosenInput = 0;
            }
            if(chosenInput == 0) {
                System.out.println("Your recent input was invalid, try again");
            }
        }
        return chosenInput;
    }
}