
public class DynamicAction extends DynamicAttributes implements Action {
    private static final String ATTRIBUTE_NAME = "name";

    public DynamicAction() {}

    public DynamicAction(String name) {
        this.setAttribute(ATTRIBUTE_NAME, name);
    }

    public boolean isNoOp() {
        return false;
    }

}

