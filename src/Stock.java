public class Stock extends Product{

    private String exchange;
    private String ticker;
    private ProductPricingService productPricingService;

    public Stock(String productId, String exchange, String ticker) {
        super(productId);
        this.exchange = exchange;
        this.ticker = ticker;
    }

    public Stock() {
        super("");
    }

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

    public Double getPrice() {
        return productPricingService.price(this.exchange,this.ticker);
    }

}
