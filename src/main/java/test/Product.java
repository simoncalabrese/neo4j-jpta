package test;

import it.jpta.annotations.Node;

/**
 * Created by simon on 10/01/17.
 */
@Node(
        name = "product"
)
public class Product {

    private String alias;
    private String name;
    private Double price;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
