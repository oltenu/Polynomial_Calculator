package view;

import logic.Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final Calculator calculator;
    private final View view;

    public Controller(Calculator calculator, View view){
        this.calculator = calculator;
        this.view = view;

        view.addAdditionButtonListener(new AdditionButtonListener());
        view.addSubtractionButtonListener(new SubtractionButtonListener());
        view.addMultiplicationButtonListener(new MultiplicationButtonListener());
        view.addDivisionButtonListener(new DivisionButtonListener());
        view.addDerivativeButtonListener(new DerivativeButtonListener());
        view.addIntegralButtonListener(new IntegralButtonListener());
    }

    class AdditionButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setResult(calculator.callOperation(1, view.getFirstPolynomial(), view.getSecondPolynomial()));
            view.setResultLabel("Addition");
        }
    }

    class SubtractionButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setResult(calculator.callOperation(2, view.getFirstPolynomial(), view.getSecondPolynomial()));
            view.setResultLabel("Subtraction");
        }
    }

    class MultiplicationButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setResult(calculator.callOperation(3, view.getFirstPolynomial(), view.getSecondPolynomial()));
            view.setResultLabel("Multiplication");
        }
    }

    class DivisionButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setResult(calculator.callOperation(4, view.getFirstPolynomial(), view.getSecondPolynomial()));
            view.setResultLabel("Division");
        }
    }

    class DerivativeButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setResult(calculator.callOperation(5, view.getFirstPolynomial(), view.getSecondPolynomial()));
            view.setResultLabel("Derivative");
        }
    }

    class IntegralButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setResult(calculator.callOperation(6, view.getFirstPolynomial(), view.getSecondPolynomial()));
            view.setResultLabel("Integral");
        }
    }
}
