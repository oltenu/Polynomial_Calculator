import logic.Calculator;
import view.*;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Calculator calculator = new Calculator();
        new Controller(calculator, view);

        view.setVisible(true);
    }
}