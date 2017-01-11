package it.jpta.implementations;

import it.jpta.exceptions.ConfException;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;

import javax.print.URIException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by simon on 10/01/17.
 */
public class DriverClass {

    private static class Configuration {
        private String host;
        private String port;
        private String user;
        private String password;

        public Configuration(String host, String port, String user, String password) {
            this.host = host;
            this.port = port;
            this.user = user;
            this.password = password;
        }
    }

    protected static Driver readResources() {
        final String path = "META-INF/conf.conf";
        ClassLoader classLoader = DriverClass.class.getClassLoader();
        //File file = new File(classLoader.getResource(path).getFile());
        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(path).toURI()))) {
            Map<String, String> map = stream.map(e -> e.replace(" ", "").split("="))
                    .collect(Collectors.toMap(e -> e[0], e -> e[1]));
            Configuration configuration = new Configuration(
                    map.get("host"),
                    map.get("port"),
                    map.get("user"),
                    map.get("password"));
            return GraphDatabase.driver("bolt://" + configuration.host + ":" + configuration.port
                    , AuthTokens.basic(configuration.user, configuration.password));

        } catch (URISyntaxException | IOException uri ) {
            try {
                throw new ConfException("Error in conf file");
            } catch (ConfException conf) {
                conf.getMessage();
            }
        }
        return null;
    }
}
