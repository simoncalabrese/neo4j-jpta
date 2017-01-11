package it.jpta.functions;

import it.jpta.components.Node;
import it.jpta.components.NodeImp;
import it.jpta.components.Property;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by simon on 11/01/17.
 */
public class ConversionFunction {

    public static String fromNodeToString(String command, Node node) {
        return command.concat(" (")
                .concat(node.getAlias().concat(":").concat(node.getNodeName()))
                .concat("{")
                .concat(node.getPropertyNodeList()
                .stream()
                .map(propertyToString)
                .collect(Collectors.joining(","))).concat("})");


    }

    private static Function<Property, String> propertyToString =
            e -> e.getKey().concat(":").concat(stringConverter(e.getValue(), elem -> "\'".concat(elem.toString()).concat("\'")));

    private static String stringConverter(Object elem, Function<Object, String> function) {
        return function.apply(elem);
    }
}
