// AgentProgram.java

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class AgentProgram {

    private List<Percept> percepts = new ArrayList<>();
    private Table<List<Percept>, String, Action> table;
    private static final String ACTION = "action";

    AgentProgram(Map<List<Percept>, Action> perceptSequenceActions) {

        List<List<Percept>> rowHeaders = new ArrayList<>(perceptSequenceActions.keySet());

        List<String> colHeaders = new ArrayList<>();
        colHeaders.add(ACTION);

        table = new Table<>(rowHeaders, colHeaders);

        for (List<Percept> row : rowHeaders) {
            table.set(row, ACTION, perceptSequenceActions.get(row));
        }
    }

    public Action execute(Percept percept) {
        percepts.add(percept);
        return lookupCurrentAction();
    }

    private Action lookupCurrentAction() {
        Action action = null;

        action = table.get(percepts, ACTION);
        if (null == action) {
            action = NoOpAction.NO_OP;
        }

        return action;
    }
}


/*import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AgentProgram {
    private List<Percept> percepts = new ArrayList<>();
    private Table<List<Percept>, String, Action> table;
    private static final String ACTION = "action";

    public Table<List<Percept>, String, Action> getTable() {
        return table;
    }

    public AgentProgram(Map<List<Percept>, Action> seq) {
        List<List<Percept>> rHeaders = new ArrayList<>(seq.keySet());
        List<String> cHeaders = new ArrayList<>();
        cHeaders.add(ACTION);

        table = new Table<>(rHeaders, cHeaders);

        for (List<Percept> row : rHeaders) {
            table.set(row, ACTION, seq.get(row));
        }
    }

    public Action execute(Percept p) {
        percepts.add(p);
        return lookupCurrentAction();
    }

    private Action lookupCurrentAction() {
        Action action = null;

        action = table.get(percepts, ACTION);
        if (null == action) {
            action = NoOpAction.NO_OP;
        }
        return action;
    }

}
*/