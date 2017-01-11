package it.jpta.implementations.querytype.interfaces;

import it.jpta.components.Node;

/**
 * Created by simon on 11/01/17.
 */
public interface Neo4JCreateQuery {

    Neo4JCreateQuery addNodeToCreate(Node node);

    String generateQuery();
}
