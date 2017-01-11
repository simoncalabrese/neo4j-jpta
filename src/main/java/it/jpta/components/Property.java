package it.jpta.components;

/**
 * Created by simon on 11/01/17.
 */
public class Property<S> {

    private String key;
    private S value;

    public Property(String key, S value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public S getValue() {
        return value;
    }

    public void setValue(S value) {
        this.value = value;
    }
}
