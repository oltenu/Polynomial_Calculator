import logic.Calculator;
import view.Controller;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Calculator calculator = new Calculator();
        new Controller(calculator, view);

        view.setVisible(true);
    }
}