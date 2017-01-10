package it.jpta.implementations;

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
    public void closeDriver(){
        driverClass.close();
    }

    @Override
    public Neo4jQuery getEmptyQuery(){
        return new Neo4jQuery();
    }


}
