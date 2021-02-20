import org.junit.*;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.runner.JUnitCore;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class Test_MontrealTradApplication {

    protected MontrealTradeApplication montrealTradeApplication;

    @Mock
      ProductPricingService productPricingService;

    @InjectMocks
    Stock stock = new Stock("ABC","DEF","GHI");

    @InjectMocks
    Future future = new Future("CBA","FED","IHG", 12,2020);

    @Before
    public void setup(){
        montrealTradeApplication = new MontrealTradeApplication();
        when(productPricingService.price(anyString(),anyString())).thenReturn(10.0);
        when(productPricingService.price(anyString(),anyString(),anyInt(),anyInt())).thenReturn(10.0);
    }


    @Test(expected = ProductAlreadyRegisteredException.class)
    public void addProduct() throws ProductAlreadyRegisteredException {
        montrealTradeApplication.addNewProduct(stock);
        montrealTradeApplication.addNewProduct(stock);
    }

    @Test
    public void test_totalValueOfDaysTradedProducts() throws ProductAlreadyRegisteredException {
        montrealTradeApplication.addNewProduct(stock);
        montrealTradeApplication.addNewProduct(future);
        montrealTradeApplication.trade(stock,100);
        montrealTradeApplication.trade(future,1);
        assertEquals("Failed: Trade", montrealTradeApplication.totalValueOfDaysTradedProducts(), 1010, 0.0);
    }

    @Test
    public void test_trading() throws ProductAlreadyRegisteredException {
        montrealTradeApplication.addNewProduct(stock);
        montrealTradeApplication.addNewProduct(future);
        montrealTradeApplication.trade(stock,100);
        montrealTradeApplication.trade(future,1);
        assertEquals("Failed: Trade", montrealTradeApplication.totalTradeQuantityForDay(), 101, 0.0);
    }

    public static void main(String[] args) {
        Result result = org.junit.runner.JUnitCore.runClasses(TestStock.class);
        for (Failure f : result.getFailures()){
            System.out.println(f);
        }
        System.out.println(result.wasSuccessful());
    }

}
