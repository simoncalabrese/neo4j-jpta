package it.jpta.implementations.querytype.classes;

import it.jpta.components.Node;
import it.jpta.functions.ConversionFunction;
import it.jpta.implementations.querytype.interfaces.Neo4JCreateQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon on 11/01/17.
 */
public class CreateNodeQuery implements Neo4JCreateQuery {

    private List<Node> nodesToCreate = new ArrayList<>();

    public static Neo4JCreateQuery createNodeQuery() {
        return new CreateNodeQuery();
    }

    @Override
    public Neo4JCreateQuery addNodeToCreate(Node node) {
        nodesToCreate.add(node);
        return this;
    }

    @Override
    public String generateQuery() {
        return ConversionFunction.fromNodeToString("create",nodesToCreate);
    }
}
