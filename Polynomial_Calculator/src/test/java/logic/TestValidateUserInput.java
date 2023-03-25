package logic;

import org.junit.*;

public class TestValidateUserInput {
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

    //Tests
    @Test
    public void test01(){
        String input = "x";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test02(){
        String input = "-x";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test03(){
        String input = "+x";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test04(){
        String input = "10";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test05(){
        String input = "3x";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test06(){
        String input = "x^3-2";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test07(){
        String input = "2x^4+x^3-3x^2+4x-7";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test08(){
        String input = "x^-3+2x^2";
        boolean expected = false;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test09(){
        String input = "-2x+2x^2";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test10(){
        String input = "20x^2+4x^3";
        boolean expected = true;
        boolean actual = inputProcessor.validateUserInput(input);
        Assert.assertEquals(expected, actual);
    }
}