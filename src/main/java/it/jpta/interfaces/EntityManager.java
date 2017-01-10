package it.jpta.interfaces;

import it.jpta.implementations.EntityManagerImplementation;
import it.jpta.implementations.Neo4jQuery;

/**
 * Created by simon on 10/01/17.
 */
public interface EntityManager {

    void closeDriver();

    Neo4jQuery getEmptyQuery();
}
