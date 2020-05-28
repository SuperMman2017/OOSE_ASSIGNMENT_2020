/*Game class contains the list of observers that observe Menu classes and update it for the view*/
public class Game extends Subject {
    
    public GameMenu(){
        super();
    }

    /*Registers an observer to the game */
    @Override public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override public void removeObserver(Observer o) {
        observer.remove(o);
    }

    @Override notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }
    }
}