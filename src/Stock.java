public class Stock extends Product{

    //member variables
    private String exchange;
    private String ticker;
    private ProductPricingService productPricingService;

    //constructor
    public Stock(String productId, String exchange, String ticker) {
        super(productId);
        this.exchange = exchange;
        this.ticker = ticker;
    }

    public Stock() {
        super("");
    }

    //getter and setters
    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    //implement the get Price method from product class
    public Double getPrice() {
        return productPricingService.price(this.exchange,this.ticker);
    }
}
