package logic;

import model.Polynomial;
import org.junit.*;
import static org.junit.Assert.*;

public class TestOperations {
    Operations operations;

    @Before
    public void initializeTest() {
        operations = new Operations();
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
    public void AdditionTrueTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 1);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(3, 4);
        secondPolynomial.insertMonomial(2, 5);
        secondPolynomial.insertMonomial(1, 1);
        secondPolynomial.insertMonomial(0, 7);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(3, 6);
        expected.insertMonomial(2, 6);
        expected.insertMonomial(1, 4);
        expected.insertMonomial(0, 7);

        //when
        Polynomial actual = operations.addition(firstPolynomial, secondPolynomial);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void AdditionFalseTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 1);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(3, 4);
        secondPolynomial.insertMonomial(2, 5);
        secondPolynomial.insertMonomial(1, 1);
        secondPolynomial.insertMonomial(0, 7);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(3, 6);
        expected.insertMonomial(2, 2);
        expected.insertMonomial(1, 4);
        expected.insertMonomial(0, 5);

        //when
        Polynomial actual = operations.addition(firstPolynomial, secondPolynomial);

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void SubtractionTrueTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 3);
        firstPolynomial.insertMonomial(2, 6);
        firstPolynomial.insertMonomial(1, 2);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(3, 1);
        secondPolynomial.insertMonomial(2, 2);
        secondPolynomial.insertMonomial(1, 3);
        secondPolynomial.insertMonomial(0, 3);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(3, 2);
        expected.insertMonomial(2, 4);
        expected.insertMonomial(1, -1);
        expected.insertMonomial(0, -3);

        //when
        Polynomial actual = operations.subtraction(firstPolynomial, secondPolynomial);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void SubtractionFalseTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 1);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(3, 4);
        secondPolynomial.insertMonomial(2, 5);
        secondPolynomial.insertMonomial(1, 1);
        secondPolynomial.insertMonomial(0, 7);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(3, 6);
        expected.insertMonomial(2, 6);
        expected.insertMonomial(1, 4);
        expected.insertMonomial(0, 7);

        //when
        Polynomial actual = operations.subtraction(firstPolynomial, secondPolynomial);

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void MultiplicationTrueTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 1);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(2, 5);
        secondPolynomial.insertMonomial(0, 7);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(5, 10);
        expected.insertMonomial(4, 5);
        expected.insertMonomial(3, 29);
        expected.insertMonomial(2, 7);
        expected.insertMonomial(1, 21);

        //when
        Polynomial actual = operations.multiplication(firstPolynomial, secondPolynomial);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void MultiplicationFalseTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 4);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(2, 5);
        secondPolynomial.insertMonomial(2, 7);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(5, 9);
        expected.insertMonomial(4, 1);
        expected.insertMonomial(3, 5);
        expected.insertMonomial(2, 7);
        expected.insertMonomial(1, 16);

        //when
        Polynomial actual = operations.multiplication(firstPolynomial, secondPolynomial);

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void DivisionTrueTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 1);
        firstPolynomial.insertMonomial(2, -2);
        firstPolynomial.insertMonomial(1, 6);
        firstPolynomial.insertMonomial(0, -5);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(2, 1);
        secondPolynomial.insertMonomial(0, -1);

        String expected = "Q:x-2 R:7x-7";

        //when
        String actual = operations.division(firstPolynomial, secondPolynomial);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void DivisionFalseTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 1);
        firstPolynomial.insertMonomial(2, -2);
        firstPolynomial.insertMonomial(1, 6);
        firstPolynomial.insertMonomial(0, -5);

        Polynomial secondPolynomial = new Polynomial();
        secondPolynomial.insertMonomial(2, 1);
        secondPolynomial.insertMonomial(0, -1);

        String expected = "Q:x-2 R:0";

        //when
        String actual = operations.division(firstPolynomial, secondPolynomial);

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void DerivativeTrueTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 4);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(2, 6);
        expected.insertMonomial(1, 8);
        expected.insertMonomial(0, 3);

        //when
        Polynomial actual = operations.derivative(firstPolynomial);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void DerivativeFalseTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 2);
        firstPolynomial.insertMonomial(2, 4);
        firstPolynomial.insertMonomial(1, 3);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(2, 3);
        expected.insertMonomial(1, 5);
        expected.insertMonomial(3, 2);

        //when
        Polynomial actual = operations.derivative(firstPolynomial);

        //then
        assertNotEquals(expected, actual);
    }

    @Test
    public void IntegralTrueTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(3, 4);
        firstPolynomial.insertMonomial(2, 6);
        firstPolynomial.insertMonomial(1, 1);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(4, 1);
        expected.insertMonomial(3, 2);
        expected.insertMonomial(2, 0.5);

        //when
        Polynomial actual = operations.integral(firstPolynomial);

        //then
        assertEquals(expected, actual);
    }

    @Test
    public void IntegralFalseTest() {
        //given
        Polynomial firstPolynomial = new Polynomial();
        firstPolynomial.insertMonomial(5, 1);
        firstPolynomial.insertMonomial(4, 3);
        firstPolynomial.insertMonomial(2, 4);

        Polynomial expected = new Polynomial();
        expected.insertMonomial(6, 3);
        expected.insertMonomial(4, 2);
        expected.insertMonomial(0, 6);

        //when
        Polynomial actual = operations.integral(firstPolynomial);

        //then
        assertNotEquals(expected, actual);
    }
}