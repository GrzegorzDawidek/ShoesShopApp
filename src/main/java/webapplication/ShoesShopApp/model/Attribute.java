package webapplication.ShoesShopApp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attribute_id")
    private Long attributeId;
    @Column(name = "attribute_name")
    private String attributeName;
    private String value;

    @ManyToMany(mappedBy = "attributes")
    private Set<Product> products = new HashSet<>();

    public Attribute() {
    }

    public Attribute( String attributeName, String value) {
        this.attributeName = attributeName;
        this.value = value;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeId=" + attributeId +
                ", attributeName='" + attributeName + '\'' +
                ", value='" + value +
                '}';
    }
}
