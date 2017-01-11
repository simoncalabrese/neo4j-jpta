package it.jpta.functions;

import it.jpta.components.Node;
import it.jpta.components.NodeImp;
import it.jpta.components.Property;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by simon on 11/01/17.
 */
public class ConversionFunction {

    public static String fromNodeToString(String command, List<Node> node) {
        return command.concat(node.stream().map(nodeToString).collect(Collectors.joining(",")));
    }

    private static Function<Node, String> nodeToString =
            node -> " (".concat(node.getAlias()
                    .concat(":")
                    .concat(node.getNodeName())
                    .concat(" {")
                    .concat(node.getPropertyNodeList().stream()
                            .map(ConversionFunction::propertyToStringConverter)
                            .collect(Collectors.joining(","))
                    ).concat(" })"));

    private static String propertyToStringConverter(Property property) {
        return "".concat(property.getKey())
                .concat(":")
                .concat("\'")
                .concat(property.getValue().toString())
                .concat("\'");
    }
}
