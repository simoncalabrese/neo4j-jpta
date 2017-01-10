package it.jpta.functions;

/**
 * Created by simon on 10/01/17.
 */
public class Relation<START,END,RELATION> {
    private START startNode;
    private END endNode;
    private RELATION relation;

    public Relation(START startNode, END endNode, RELATION relation) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.relation = relation;
    }


}
