package it.jpta.implementations;

import it.jpta.implementations.querytype.interfaces.Neo4JCreateQuery;
import it.jpta.interfaces.EntityManager;
import org.neo4j.driver.v1.Driver;


/**
 * Created by simon on 10/01/17.
 */
public class EntityManagerImplementation implements EntityManager {

    private static Driver driverClass = DriverClass.readResources();

    public static EntityManagerImplementation getEntityManager(){
        return new EntityManagerImplementation();
    }

    @Override
    public void closeDriver() {
        driverClass.close();
    }

    public Neo4JCreateQuery getEmptyCreateQuery() {
        return null;
    }
}
