
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.lang.invoke.MethodHandleImpl.assertSame;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class Test_Stock {

    //mocking the interface product pricing service to allow us to test its functionalities
    @Mock
    ProductPricingService productPricingService;

    @InjectMocks
    Stock stock = new Stock();

    @Before
    public void setup(){
    }

    @Test
    public void stock_test_setExchange(){
        stock.setExchange("EXCHANGE_A");
        assertSame("Failed: Stock Creation", "EXCHANGE_A", stock.getExchange());
    }


    public static void main(String[] args) {
        Result result = org.junit.runner.JUnitCore.runClasses(Test_Stock.class);
        for (Failure f : result.getFailures()){
            System.out.println(f);
        }
        System.out.println(result.wasSuccessful());
    }

}
