package it.jpta.implementations;

import it.jpta.implementations.querytype.interfaces.Neo4JCreateQuery;
import it.jpta.interfaces.EntityManager;
import it.jpta.implementations.querytype.classes.CreateNodeQuery;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.StatementResult;


/**
 * Created by simon on 10/01/17.
 */
public class EntityManagerImplementation implements EntityManager {

    private static Driver driverClass = DriverClass.readResources();

    public static EntityManager getEntityManager(){
        return new EntityManagerImplementation();
    }

    @Override
    public void closeDriver() {
        driverClass.close();
    }

    @Override
    public Neo4JCreateQuery getEmptyCreateQuery() {
        return CreateNodeQuery.createNodeQuery();
    }

    @Override
    public void executeQuery(final String query){
        StatementResult run = driverClass.session().run(query);
        System.out.println();
    }
}
