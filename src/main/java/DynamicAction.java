
public class DynamicAction extends DynamicAttributes implements Action {
    private static final String ATTRIBUTE_NAME = "name";

    public DynamicAction() {}

    public DynamicAction(String name) {
        this.setAttribute(ATTRIBUTE_NAME, name);
    }

    public String getName() {
        return (String) getAttribute(ATTRIBUTE_NAME);
    }

    public boolean isNoOp() {
        return false;
    }

}

