package it.jpta.functions;


/**
 * Created by simon on 10/01/17.
 */
@FunctionalInterface
public interface LeftToRightRelation<A, B, C,Expression> {
    Expression apply(A left, B right, C relationstart);
}
