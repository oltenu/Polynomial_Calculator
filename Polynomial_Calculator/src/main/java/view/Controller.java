package view;

import logic.Calculator;
import java.awt.event.*;

public class Controller {
    private final Calculator calculator;
    private final View view;

    public Controller(Calculator calculator, View view) {
        this.calculator = calculator;
        this.view = view;

        view.addAdditionButtonListener(new AdditionButtonListener());
        view.addSubtractionButtonListener(new SubtractionButtonListener());
        view.addMultiplicationButtonListener(new MultiplicationButtonListener());
        view.addDivisionButtonListener(new DivisionButtonListener());
        view.addDerivativeButtonListener(new DerivativeButtonListener());
        view.addIntegralButtonListener(new IntegralButtonListener());
    }

    class AdditionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (calculator.callOperation(1, view.getFirstPolynomial(), view.getSecondPolynomial())) {
                view.setResult(calculator.getResult());
                view.setResultLabel("Addition");
            } else
                view.invalidInputDialog();
        }
    }

    class SubtractionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (calculator.callOperation(2, view.getFirstPolynomial(), view.getSecondPolynomial())) {
                view.setResult(calculator.getResult());
                view.setResultLabel("Subtraction");
            } else
                view.invalidInputDialog();
        }
    }

    class MultiplicationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (calculator.callOperation(3, view.getFirstPolynomial(), view.getSecondPolynomial())) {
                view.setResult(calculator.getResult());
                view.setResultLabel("Multiplication");
            } else
                view.invalidInputDialog();
        }
    }

    class DivisionButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (calculator.callOperation(4, view.getFirstPolynomial(), view.getSecondPolynomial())) {
                view.setResult(calculator.getResult());
                view.setResultLabel("Division");
            } else
                view.invalidInputDialog();
        }
    }

    class DerivativeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (calculator.callOperation(5, view.getFirstPolynomial(), view.getSecondPolynomial())) {
                view.setResult(calculator.getResult());
                view.setResultLabel("Derivative");
            } else
                view.invalidInputDialog();
        }
    }

    class IntegralButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (calculator.callOperation(6, view.getFirstPolynomial(), view.getSecondPolynomial())) {
                view.setResult(calculator.getResult());
                view.setResultLabel("Integral");
            } else
                view.invalidInputDialog();
        }
    }
}