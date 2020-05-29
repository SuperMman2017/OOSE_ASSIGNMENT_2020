/*Game class contains the list of observers that observe Menu classes and update it for the view*/
public class Game extends Subject {
    
    public Game(){
        super();
    }

    /*Registers an observer to the game */
    @Override public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }

    
}