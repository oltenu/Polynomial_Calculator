import logic.Calculator;
import model.Polynomial;
import view.Controller;
import view.View;

public class Main {
    public static void main(String[] args) {
        /*View view = new View();
        Calculator calculator = new Calculator();
        new Controller(calculator, view);

        view.setVisible(true);*/

        Polynomial p = new Polynomial();
        p.insertMonomial(3, 5);
        p.insertMonomial(2,3.4);
        p.insertMonomial(1,2.37);
        p.insertMonomial(0, 5);
        System.out.println(p);
    }
}