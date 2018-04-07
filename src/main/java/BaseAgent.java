// Agent interface

public interface BaseAgent extends BaseObject {

    Action execute(Percept percept);

    boolean isAlive();

    void setAlive(boolean alive);
}
