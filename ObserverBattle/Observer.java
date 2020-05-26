public abstract class Observer {
    private Subject sub;
    public Observer(){
        sub = new Subject();
    }

    public abstract void update();
}