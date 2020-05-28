import java.util.LinkedList;

public abstract class Subject {

    protected LinkedList<Observer> observers;
    public Subject(){
        observers = new LinkedList<>();
    }

    public abstract void registerObserver(Observer o);
    public abstract void removeObserver(Observer o);
    public abstract void notifyObservers();
    
}