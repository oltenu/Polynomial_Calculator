package logic;

import org.junit.*;

public class TestValidateUserInput {
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

    //Tests
    @Test
    public void test01() {
        //given
        String input = "x";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test02() {
        //given
        String input = "-x";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test03() {
        //given
        String input = "+x";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test04() {
        //given
        String input = "10";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test05() {
        //given
        String input = "3x";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test06() {
        //given
        String input = "x^3-2";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test07() {
        //given
        String input = "2x^4+x^3-3x^2+4x-7";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test08() {
        //given
        String input = "x^-3+2x^2";
        boolean expected = false;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test09() {
        //given
        String input = "-2x+2x^2";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        //given
        String input = "20x^2+4x^3";
        boolean expected = true;

        //when
        boolean actual = inputProcessor.validateUserInput(input);

        //then
        Assert.assertEquals(expected, actual);
    }
}