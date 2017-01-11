package it.jpta.components;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simon on 11/01/17.
 */
public class NodeImp implements Node {

    private String alias;

    private String nodeName;

    private List<Property> propertyNodeList;

    @Override
    public String getNodeName() {
        return nodeName;
    }

    @Override
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public void setAlias(@NotNull String alias) {
        this.alias = alias;
    }

    @Override
    public void setPropertyNodeList(@NotNull Property... properties) {
        this.propertyNodeList = Arrays.stream(properties).collect(Collectors.toList());
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public List<Property> getPropertyNodeList() {
        return propertyNodeList;
    }
}
