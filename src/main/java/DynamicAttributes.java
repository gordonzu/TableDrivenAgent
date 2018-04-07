import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class DynamicAttributes {
    private Map<Object, Object> attributes = new LinkedHashMap<>();

    String describeType() {
        return getClass().getSimpleName();
    }

    String describeAttributes() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        boolean first = true;
        for (Object key : attributes.keySet()) {
            if (first) {
                first = false;
            } else {
                sb.append(", ");
            }

            sb.append(key);
            sb.append("=");
            sb.append(attributes.get(key));
        }
        sb.append("]");

        return sb.toString();
    }

    public Set<Object> getKeySet() {
        return Collections.unmodifiableSet(attributes.keySet());
    }

    public void setAttribute(Object key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(Object key) {
        return attributes.get(key);
    }

    public void removeAttribute(Object key) {
        attributes.remove(key);
    }

    public DynamicAttributes copy() {
        DynamicAttributes copy = null;

        try {
            copy = getClass().newInstance();
            copy.attributes.putAll(attributes);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return copy;
    }

    @Override
    public boolean equals(Object o) {
        return o != null && getClass() == o.getClass()
                && attributes.equals(((DynamicAttributes) o).attributes);
    }

    @Override
    public int hashCode() {
        return attributes.hashCode();
    }

    @Override
    public String toString() {
        return describeType() + describeAttributes();
    }
}



/*
import java.util.LinkedHashMap;
import java.util.Map;

public class DynamicAttributes {
    private Map<Object, Object> attributes = new LinkedHashMap<>();

    public void setAttribute(Object key, Object value) {
        attributes.put(key, value);
    }

}
*/