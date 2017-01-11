package it.jpta.components;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by simon on 11/01/17.
 */
public interface Node {

    String getNodeName();

    void setNodeName(String nodeName);

    void setAlias(@NotNull String alias);

    void setPropertyNodeList(@NotNull Property... properties);

    String getAlias();

    List<Property> getPropertyNodeList();
}
