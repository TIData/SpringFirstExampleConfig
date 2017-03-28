package domein;

import domain.HelloService;
import domain.HelloServiceImpl;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class HelloServiceTest {

    private HelloService helloService;
    private String input, expResult;

    @Before
    public void before() {
        helloService = new HelloServiceImpl();
    }

    public HelloServiceTest(String input, String expResult) {
        this.input = input;
        this.expResult = expResult;
    }

    @Parameters
    public static Collection<String[]> getTestParameters() {
        return Arrays.asList(
                new String[][] { {"", "Hello !"}, { null, "Hello !"}, 
                    {"   ", "Hello    !"}, {"test", "Hello test!"}, 
                    {"* TeST tEsT +", "Hello * TeST tEsT +!"}
                });
        }
        
    @Test

    public void legeString() {
        Assert.assertEquals(expResult, helloService.sayHello(input));
    }
}
