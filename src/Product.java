abstract class Product {

    private String productId;

    //constructor
    protected Product(String productId) {
        this.productId = productId;
    }

    //getter and setter methods
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    //Method is implemented in Future and Stock class
    public abstract Double getPrice();

}