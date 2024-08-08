package PdfFormater.codingerror.model;

import java.util.Objects;
import java.util.Optional;

public class Product {
    private Optional<String> pname;
    private int quantity;
    private float dimensions;
    private float priceperpeice;
    private float total;


    public Product(String pname, int quantity,float dimensions ,float priceperpeice, float total ) {
        this.pname = Optional.ofNullable(pname);
        this.quantity = quantity;
        this.dimensions = dimensions;
        this.priceperpeice = priceperpeice;
        this.total = total;
    }

    public Optional<String> getPname() {
        return pname;
    }
    public float getDimensions(){
        return dimensions;
    }
    public float getTotal(){
        return total;
    }


    public void setPname(String pname) {
        this.pname = Optional.ofNullable(pname);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceperpeice() {
        return priceperpeice;
    }

    public void setPriceperpeice(float priceperpeice) {
        this.priceperpeice = priceperpeice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(pname, product.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pname);
    }

    @Override
    public String toString() {
        return "{" +
                "pname=" + pname +
                ", quantity=" + quantity +
                ", dimensions=" + dimensions +
                ", priceperpeice=" + priceperpeice +
                ", total=" + total +
                '}';
    }
}
