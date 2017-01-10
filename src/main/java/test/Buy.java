package test;

import it.jpta.annotations.Relation;

/**
 * Created by simon on 10/01/17.
 */
@Relation(name = "buy")
public class Buy {
    private String alias;
    private String date;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
