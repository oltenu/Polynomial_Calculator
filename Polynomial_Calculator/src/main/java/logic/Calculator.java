package logic;

import model.Polynomial;

public class Calculator {

    public String callOperation(int operationId, String firstUserInput, String secondUserInput){
        Polynomial secondPolynomial;
        Polynomial firstPolynomial;
        switch (operationId) {
            case 1 -> {
                firstPolynomial = new Polynomial(firstUserInput);
                secondPolynomial = new Polynomial(secondUserInput);
                return Operations.addition(firstPolynomial, secondPolynomial).toString();
            }
            case 2 -> {
                firstPolynomial = new Polynomial(firstUserInput);
                secondPolynomial = new Polynomial(secondUserInput);
                return Operations.subtraction(firstPolynomial, secondPolynomial).toString();
            }
            case 3 -> {
                firstPolynomial = new Polynomial(firstUserInput);
                secondPolynomial = new Polynomial(secondUserInput);
                return Operations.multiplication(firstPolynomial, secondPolynomial).toString();
            }
            case 4 -> {
                firstPolynomial = new Polynomial(firstUserInput);
                secondPolynomial = new Polynomial(secondUserInput);
                return Operations.division(firstPolynomial, secondPolynomial);
            }
            case 5 -> {
                firstPolynomial = new Polynomial(firstUserInput);
                return Operations.derivative(firstPolynomial).toString();
            }
            case 6 -> {
                firstPolynomial = new Polynomial(firstUserInput);
                return Operations.integral(firstPolynomial).toString();
            }
        }
        return null;
    }
}
