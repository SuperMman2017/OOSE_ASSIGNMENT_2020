import java.util.LinkedList;

public abstract class Subject {

    protected LinkedList<Observer> observers;
    public Subject(){
        observers = new LinkedList<>();
    }

    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
    
}