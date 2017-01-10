package it.jpta.implementations;


import it.jpta.exceptios.ValueException;
import it.jpta.functions.Relation;
import it.jpta.functions.LeftToRightRelation;
import it.jpta.implementations.queryUtils.Neo4jQueryUtils;
import it.jpta.interfaces.EntityManager;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by simon on 10/01/17.
 */
@SuppressWarnings("unchecked")
public class Neo4jQuery<N, R> extends Neo4jQueryUtils<N, R> {


    private static EntityManagerImplementation entityManager = EntityManagerImplementation.getEntityManager();

    private List<Relation> relation = new LinkedList<>();
    private Set<String> resultSet = new HashSet<>();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Neo4jQuery createQuery() {
        return entityManager.getEmptyQuery();
    }

    public Neo4jQuery addNode(N value) throws ValueException {
        return addNode(value,true);
    }

    public Neo4jQuery addNode(N value,Boolean startOrEnd) throws ValueException {
        return addNode(value, startOrEnd, functionNode);
    }

    public Neo4jQuery addRelation(R value) throws ValueException {
        return addRelation(null, null, value, functionRelation);
    }

    public Neo4jQuery addRelation(N nodeStart, N nodeEnd, R value) throws ValueException {
        return addRelation(nodeStart, nodeEnd, value, functionRelation);
    }

    private Neo4jQuery addNode(N node, Boolean startOrEnd,LeftToRightRelation<N, N, R, Relation> createNode) throws ValueException {
        if (isValidInputNode((Class<N>) node.getClass())) {
            relation.add(startOrEnd ? createNode.apply(node, null, null) : createNode.apply(null, node, null));
        } else {
            throw new ValueException("Value is not a Node value");
        }
        return this;
    }

    private Neo4jQuery addRelation(N nodeStart, N nodeEnd, R value,
                                   LeftToRightRelation<N, N, R, Relation> createFunction) throws ValueException {
        if (isValidInputRelation((Class<R>) value.getClass())) {
            relation.add(createFunction.apply(nodeStart, nodeEnd, value));
        } else {
            throw new ValueException("Value is not a Relation value");
        }
        return this;
    }

    public Neo4jQuery addReturnType(String alias) {
        resultSet.add(alias);
        return this;
    }

    public String generateQueryString() {

    }


}
