import java.util.HashMap;

public class MontrealTradeApplication implements MontrealTradedProducts {

    private final HashMap<String,Product> allProducts = new HashMap<>();
    private final HashMap<String,Integer> tradeHistory = new HashMap<>();


    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if(this.allProducts.containsKey(product.getProductId()))
            throw new ProductAlreadyRegisteredException("Product exist with ID:"+product.getProductId());
        else
            this.allProducts.put(product.getProductId(),product);
    }

    @Override
    public void trade(Product product, int quantity) {
        Integer previousQuantity = this.tradeHistory.getOrDefault(product.getProductId(), 0);
        this.tradeHistory.put(product.getProductId() ,previousQuantity + quantity );
    }

    @Override
    public int totalTradeQuantityForDay() {
        int totalQuantity = 0;
        for(String key : this.tradeHistory.keySet()){
            totalQuantity += this.tradeHistory.get(key);
        }
        return totalQuantity;
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = 0;
        for(String key : this.tradeHistory.keySet()){
            Integer quantity = this.tradeHistory.get(key);
            double price = this.allProducts.get(key).getPrice();
            totalValue += (price*quantity);
        }
        return totalValue;
    }
}
