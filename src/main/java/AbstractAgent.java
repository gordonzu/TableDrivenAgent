

public abstract class AbstractAgent implements BaseAgent {
    protected AgentProgram program;
    private boolean alive = true;

    public AbstractAgent() {}

    public AbstractAgent(AgentProgram aProgram) {
        program = aProgram;
    }

    public Action execute(Percept p) {
        if (null != program) {
            return program.execute(p);
        }
        return NoOpAction.NO_OP;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}

