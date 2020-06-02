
public class EnemyState implements Observer{
    private Actor enemy;
    private Subject enemySubject;

    public EnemyState(Subject enemySubject) {
        this.enemySubject = enemySubject;
        enemySubject.registerObserver(this);
    }

    public void update(Actor enemy) {
        this.enemy = enemy;
    }
}