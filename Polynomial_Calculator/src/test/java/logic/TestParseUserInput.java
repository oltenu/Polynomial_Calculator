package logic;

import model.Polynomial;
import org.junit.*;
import java.util.TreeMap;

public class TestParseUserInput {
    private InputProcessor inputProcessor;

    //Test setting
    @Before
    public void initializeTest() {
        inputProcessor = new InputProcessor();
    }

    @BeforeClass
    public static void setUp() {
        System.out.println("Testing has started!");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Testing has ended!");
    }

    @Test
    public void test01() {
        //given
        String input = "7x^3+3x^4+2x+6";
        String expected = "3x^4+7x^3+2x+6";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test02() {
        //given
        String input = "x^2-x";
        String expected = "x^2-x";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test03() {
        //given
        String input = "-x^3+2x^2";
        String expected = "-x^3+2x^2";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test04() {
        //given
        String input = "x^5";
        String expected = "x^5";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test05() {
        //given
        String input = "5";
        String expected = "5";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test06() {
        //given
        String input = "-x^3+2x^3+5x^3+4x";
        String expected = "6x^3+4x";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test07() {
        //given
        String input = "x-2x^3+2+4";
        String expected = "-2x^3+x+6";

        //when
        TreeMap<Integer, Double> monomialsMap = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMap);

        //then
        Assert.assertEquals(expected, actual.toString());
    }

    @Test
    public void test08() {
        //given
        String input = "x^10-4x";
        String expected = "x^10-4x";

        //when
        TreeMap<Integer, Double> monomialsMa = inputProcessor.parseUserInput(input);
        Polynomial actual = new Polynomial(monomialsMa);

        //then
        Assert.assertEquals(expected, actual.toString());
    }
}
