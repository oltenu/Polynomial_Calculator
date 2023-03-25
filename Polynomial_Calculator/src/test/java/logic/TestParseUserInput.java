package logic;

import model.Polynomial;
import org.junit.*;

import java.util.TreeMap;

public class TestParseUserInput {
    private InputProcessor inputProcessor;

    //Test setting
    @Before
    public void initializeTest(){inputProcessor = new InputProcessor();}

    @BeforeClass
    public static void setUp(){
        System.out.println("Testing has started!");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Testing has ended!");
    }

    @Test
    public void test01(){
        String input = "7x^3+3x^4+2x+6";
        String expected = "3x^4+7x^3+2x+6";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test02(){
        String input = "x^2-x";
        String expected = "x^2-x";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test03(){
        String input = "-x^3+2x^2";
        String expected = "-x^3+2x^2";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test04(){
        String input = "x^5";
        String expected = "x^5";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test05(){
        String input = "5";
        String expected = "5";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test06(){
        String input = "-x^3+2x^3+5x^3+4x";
        String expected = "6x^3+4x";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test07(){
        String input = "x-2x^3+2+4";
        String expected = "-2x^3+x+6";
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test08(){
        String input = "x^10-4x";
        String expected = "x^10-4x";
        TreeMap<Integer, Double> monomialsMa = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMa);

        Assert.assertEquals(expected, actual.toString());
    }
}
