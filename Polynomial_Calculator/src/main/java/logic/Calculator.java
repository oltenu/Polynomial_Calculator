package logic;

import model.Polynomial;

public class Calculator {
    private final InputProcessor inputProcessor;
    private final Operations operations;
    private String result;

    public Calculator() {
        inputProcessor = new InputProcessor();
        operations = new Operations();
    }

    public boolean callOperation(int operationId, String firstUserInput, String secondUserInput) {
        Polynomial secondPolynomial;
        Polynomial firstPolynomial;
        switch (operationId) {
            case 1 -> {
                if (inputProcessor.validateUserInput(firstUserInput) && inputProcessor.validateUserInput(secondUserInput)) {
                    firstPolynomial = new Polynomial(inputProcessor.parseUserInput(firstUserInput));
                    secondPolynomial = new Polynomial(inputProcessor.parseUserInput(secondUserInput));
                    result = operations.addition(firstPolynomial, secondPolynomial).toString();
                } else return false;
            }
            case 2 -> {
                if (inputProcessor.validateUserInput(firstUserInput) && inputProcessor.validateUserInput(secondUserInput)) {
                    firstPolynomial = new Polynomial(inputProcessor.parseUserInput(firstUserInput));
                    secondPolynomial = new Polynomial(inputProcessor.parseUserInput(secondUserInput));
                    result = operations.subtraction(firstPolynomial, secondPolynomial).toString();
                } else return false;
            }
            case 3 -> {
                if (inputProcessor.validateUserInput(firstUserInput) && inputProcessor.validateUserInput(secondUserInput)) {
                    firstPolynomial = new Polynomial(inputProcessor.parseUserInput(firstUserInput));
                    secondPolynomial = new Polynomial(inputProcessor.parseUserInput(secondUserInput));
                    result = operations.multiplication(firstPolynomial, secondPolynomial).toString();
                } else return false;
            }
            case 4 -> {
                if (inputProcessor.validateUserInput(firstUserInput) && inputProcessor.validateUserInput(secondUserInput)) {
                    firstPolynomial = new Polynomial(inputProcessor.parseUserInput(firstUserInput));
                    secondPolynomial = new Polynomial(inputProcessor.parseUserInput(secondUserInput));
                    result = operations.division(firstPolynomial, secondPolynomial);
                } else return false;
            }
            case 5 -> {
                if (inputProcessor.validateUserInput(firstUserInput) && inputProcessor.validateUserInput(secondUserInput)) {
                    firstPolynomial = new Polynomial(inputProcessor.parseUserInput(firstUserInput));
                    result = operations.derivative(firstPolynomial).toString();
                } else return false;
            }
            case 6 -> {
                if (inputProcessor.validateUserInput(firstUserInput) && inputProcessor.validateUserInput(secondUserInput)) {
                    firstPolynomial = new Polynomial(inputProcessor.parseUserInput(firstUserInput));
                    result = operations.integral(firstPolynomial).toString();
                } else return false;
            }
        }
        return true;
    }

    public String getResult() {
        return result;
    }
}
