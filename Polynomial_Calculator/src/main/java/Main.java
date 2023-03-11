import logic.Operations;
import model.Polynomial;
import view.View;

public class Main {
    public static void main(String[] args){
        /*View view = new View();
        view.setVisible(true);*/
        Operations op = new Operations();
        Polynomial test = new Polynomial();
        test.insertMonomial(4, 7);
        test.insertMonomial(3, -2);
        test.insertMonomial(2, 4);
        test.insertMonomial(0, -4);

        Polynomial test1 = new Polynomial();
        test1.insertMonomial(5, 3);
        test1.insertMonomial(4, 6);
        test1.insertMonomial(1, 2);
        test1.insertMonomial(0, 5);

        Polynomial add = op.addition(test, test1);
        Polynomial sub = op.subtraction(test, test1);

        System.out.println(add);
        System.out.println(sub);
    }
}
