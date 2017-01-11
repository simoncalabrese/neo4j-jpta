package it.jpta.interfaces;

import it.jpta.implementations.EntityManagerImplementation;
import it.jpta.implementations.querytype.interfaces.Neo4JCreateQuery;

/**
 * Created by simon on 10/01/17.
 */
public interface EntityManager {

    void closeDriver();


    Neo4JCreateQuery getEmptyCreateQuery();

    void executeQuery(String query);
}
