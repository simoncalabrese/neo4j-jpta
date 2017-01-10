package it.jpta.components;

/**
 * Created by simon on 10/01/17.
 */
public enum CommandEnum {
    MATCH("MATCH"),
    DELETE("DELETE");

    private String commandValue;

    CommandEnum(String commandValue) {
        this.commandValue = commandValue;
    }

    public String getCommandValue() {
        return commandValue;
    }
}
