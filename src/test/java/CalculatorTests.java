import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorTests {
    private CalculatorDemo calculatorDemo;
    @BeforeAll
    public static void SetupClass(){
        System.out.println("Set up class");
    }
    @BeforeEach
    public void setup(){
        System.out.println("Set up test");
         calculatorDemo = new CalculatorDemo();
    }

    public static double[][] data(){
        return new double[][]{{0, 1, 1},{-1.5, 1.5, 0},{2.5, 3.6, 6.1}};
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    public void addTest(double[] data){
        double result = calculatorDemo.add(data[0], data[1]);
        Assertions.assertEquals(data[2], result, "Calculator sum is not expected");
    }
    //@Disabled("Disabled until bug #99 has bee fixed")
    @Test
    public void addTest2(){
        double result = calculatorDemo.multiply(2, 4);
        Assertions.assertEquals(8, result, "Calculator multiplication is not expected");
    }
    @AfterEach
    public void teardownClass(){
        System.out.println("Tear down class");
    }
    @AfterAll
    public static void teardown(){
        System.out.println("Tear down test");
    }
}
