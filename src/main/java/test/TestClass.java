package test;

import it.jpta.exceptios.ValueException;
import it.jpta.implementations.EntityManagerImplementation;
import it.jpta.implementations.Neo4jQuery;

/**
 * Created by simon on 10/01/17.
 */
public class TestClass {

    public static void main(String[] rgs) throws ValueException {
        Neo4jQuery emptyQuery = EntityManagerImplementation.getEntityManager().getEmptyQuery();

        Person person = new Person();
        person.setAlias("p");
        person.setName("Simon");
        person.setSurname("Calabrese");

        Product product = new Product();
        product.setAlias("prod");
        product.setName("Cioccolata");
        product.setPrice(3.2);

        Buy buy = new Buy();
        buy.setAlias("b");
        buy.setDate("22-12-16");

        Neo4jQuery neo4jQuery = emptyQuery
                .addNode(person)
                .addNode(product)
                .addRelation(person, product, buy)
                .addReturnType(person.getAlias());
        System.out.println();
    }
}
