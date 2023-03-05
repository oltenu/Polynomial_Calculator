package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class View extends JFrame {
    private JPanel headerPanel;
    private JPanel inputPanel;
    private JPanel operationsPanel;
    private JPanel resultPanel;

    private JTextField firstPolynomialTextField;
    private JTextField secondPolynomialTextField;
    private JTextField resultTextField;

    private JLabel resultLabel;

    private JButton additionButton;
    private JButton subtractionButton;
    private JButton multiplicationButton;
    private JButton divisionButton;
    private JButton derivationButton;
    private JButton integralButton;


    public View(){
        //ImageIcon applicationIcon = new ImageIcon(Objects.requireNonNull(View.class.getResource("D:\\Darius\\Facultate\\Anul_II\\Semestrul_II\\Tehnici_de_Programare_Fundamentale\\Laborator\\Assingment_01\\PT2023_30224_Oltean_Darius_Assignment_1\\Polynomial_Calculator\\src\\main\\resources\\images\\calculator")));
        //setIconImage(applicationIcon.getImage());
        setSize(350, 500);
        setTitle("Polynomial Calculator");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.LIGHT_GRAY);
        contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));

        createHeaderPanel();
        createInputPanel();
        createOperationsPanel();
        createResultPanel();

        contentPanel.add(headerPanel);
        contentPanel.add(inputPanel);
        contentPanel.add(operationsPanel);
        contentPanel.add(resultPanel);

        add(contentPanel);
    }

    //Creating main panels
    public void createHeaderPanel(){
        headerPanel = new JPanel();
        headerPanel.setBackground(Color.LIGHT_GRAY);
        headerPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JLabel headerLabel = new JLabel("Polynomial Calculator", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));

        JPanel fillingPanel = new JPanel();
        fillingPanel.setBackground(Color.LIGHT_GRAY);

        headerPanel.add(headerLabel);
        headerPanel.add(fillingPanel);
    }

    public void createInputPanel(){
        inputPanel = new JPanel();
        inputPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setLayout(new GridLayout(2, 2, 5, 5));

        JLabel firstPolynomialLabel = new JLabel("  First Polynomial", SwingConstants.CENTER);
        firstPolynomialLabel.setFont(new Font("Arial", Font.BOLD, 13));
        JLabel secondPolynomial = new JLabel("      Second Polynomial", SwingConstants.CENTER);
        secondPolynomial.setFont(new Font("Arial", Font.BOLD, 13));

        firstPolynomialTextField = new JTextField();
        firstPolynomialTextField.setColumns(20);
        secondPolynomialTextField = new JTextField();
        secondPolynomialTextField.setColumns(20);

        inputPanel.add(firstPolynomialLabel);
        inputPanel.add(firstPolynomialTextField);
        inputPanel.add(secondPolynomial);
        inputPanel.add(secondPolynomialTextField);
    }

    public void createOperationsPanel(){
        operationsPanel = new JPanel();
        operationsPanel.setBackground(Color.LIGHT_GRAY);
        operationsPanel.setLayout(new GridLayout(3, 2, 10, 10));

        additionButton = new JButton("Addition");
        additionButton.setFont(new Font("Arial", Font.BOLD, 20));
        additionButton.setFocusable(false);
        subtractionButton = new JButton("Subtraction");
        subtractionButton.setFont(new Font("Arial", Font.BOLD, 20));
        subtractionButton.setFocusable(false);
        multiplicationButton = new JButton("Multiplication");
        multiplicationButton.setFont(new Font("Arial", Font.BOLD, 20));
        multiplicationButton.setFocusable(false);
        divisionButton = new JButton("Division");
        divisionButton.setFont(new Font("Arial", Font.BOLD, 20));
        divisionButton.setFocusable(false);
        derivationButton = new JButton("Derivation");
        derivationButton.setFont(new Font("Arial", Font.BOLD, 20));
        derivationButton.setFocusable(false);
        integralButton = new JButton("Integral");
        integralButton.setFont(new Font("Arial", Font.BOLD, 20));
        integralButton.setFocusable(false);

        operationsPanel.add(additionButton);
        operationsPanel.add(subtractionButton);
        operationsPanel.add(multiplicationButton);
        operationsPanel.add(divisionButton);
        operationsPanel.add(derivationButton);
        operationsPanel.add(integralButton);

    }

    public void createResultPanel(){
        resultPanel = new JPanel();
        resultPanel.setBackground(Color.LIGHT_GRAY);
        resultPanel.setLayout(new GridLayout(2, 1, 10, 10));

        resultLabel = new JLabel("Awaiting operation...");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));

        resultTextField = new JTextField();
        resultTextField.setColumns(20);
        resultTextField.setEditable(false);

        resultPanel.add(resultLabel);
        resultPanel.add(resultTextField);
    }

    //Util methods
    public String getFirstPolynomial(){
        return firstPolynomialTextField.getText();
    }

    public String getSecondPolynomial(){
        return secondPolynomialTextField.getText();
    }

    public void setResult(String result){
        resultTextField.setText(result);
    }

    public void setResultLabel(String operation){
        resultLabel.setText("Result of " + operation);
    }

    //Listeners
    public void addAdditionButtonListener(ActionListener addition){
        additionButton.addActionListener(addition);
    }

    public void addSubtractionButtonListener(ActionListener subtraction){
        subtractionButton.addActionListener(subtraction);
    }

    public void addMultiplicationButtonListener(ActionListener multiplication){
        multiplicationButton.addActionListener(multiplication);
    }

    public void addDivisionButtonListener(ActionListener division){
        divisionButton.addActionListener(division);
    }

    public void addDerivationButtonListener(ActionListener derivation){
        derivationButton.addActionListener(derivation);
    }

    public void addIntegralButtonListener(ActionListener integral){
        integralButton.addActionListener(integral);
    }
}