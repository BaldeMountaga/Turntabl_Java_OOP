public class Future extends Product {

    private String exchange;
    private String contractCode;
    private int month;
    private int year;
    private ProductPricingService productPricingService;

    public Future(String productId, String exchange, String contractCode, int month, int year) {
        super(productId);
        this.exchange = exchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getPrice() {
        return productPricingService.price(this.exchange,this.contractCode,this.month,this.year);
    }

}
