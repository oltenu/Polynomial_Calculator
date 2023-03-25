package logic;

import java.util.*;
import java.util.regex.*;

public class InputProcessor {
    public boolean validateUserInput(String userInput) {
        if(userInput.isBlank())
            return false;
        userInput = userInput.trim();
        Pattern pattern = Pattern.compile("(([+-])?([0-9]+)?(x)?(\\^[0-9]+)?)+");
        Matcher matcher = pattern.matcher(userInput);

        return matcher.matches();
    }

    public TreeMap<Integer, Double> parseUserInput(String userInput) {
        TreeMap<Integer, Double> monomialsMap = new TreeMap<>();
        userInput = userInput.trim();

        if (Character.isDigit(userInput.charAt(0)) || userInput.startsWith("x"))
            userInput = "+" + userInput;

        Pattern pattern = Pattern.compile("(([+-])?([0-9]+)?(x)?(\\^[0-9]+)?)");
        Matcher matcher = pattern.matcher(userInput);
        List<String> monomials = new ArrayList<>();
        while(matcher.find())
            monomials.add(matcher.group());

        for (String element : monomials) {
            if (element.contains("x^")) {
                String[] numbers = element.split("x\\^");
                if (numbers[0].equals("+") || numbers[0].equals("-"))
                    numbers[0] += "1";
                int exponent = Integer.parseInt(numbers[1]);
                double coefficient = Double.parseDouble(numbers[0]);
                if (monomialsMap.containsKey(exponent)) {
                    monomialsMap.put(exponent, monomialsMap.get(exponent) + coefficient);
                } else {
                    monomialsMap.put(exponent, coefficient);
                }
            } else if (element.contains("x")) {
                String coefficientString;
                if(!Character.isDigit(element.charAt(1)))
                    coefficientString = element.replace("x", "1");
                else
                    coefficientString  = element.replace("x", "");
                if (monomialsMap.containsKey(1)) {
                    monomialsMap.put(1, monomialsMap.get(1) + Double.parseDouble(coefficientString));
                } else {
                    monomialsMap.put(1, Double.parseDouble(coefficientString));
                }
            } else if(!element.isEmpty()){
                if (monomialsMap.containsKey(0)) {
                    monomialsMap.put(0, monomialsMap.get(0) + Double.parseDouble(element));
                } else {
                    monomialsMap.put(0, Double.parseDouble(element));
                }
            }
        }

        return monomialsMap;
    }
}
