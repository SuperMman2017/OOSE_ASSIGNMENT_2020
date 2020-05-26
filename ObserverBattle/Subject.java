public class Subject {
    private List<Observer> observerList;


    public Subject(){
        observerList = new LinkedList<>();
    }

    public void addObserver(Observer o) {
        observerList.add(o);
    }

    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    public int getState() {

    }

    public void setState() {

    }
}