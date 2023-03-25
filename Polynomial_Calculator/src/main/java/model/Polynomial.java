package model;

import logic.utility.DoubleFormat;

import java.util.Objects;
import java.util.TreeMap;

import static logic.utility.DoubleFormat.*;

public class Polynomial {
    private TreeMap<Integer, Double> monomialsMap;

    public Polynomial(TreeMap<Integer, Double> monomialsMap) {
        this.monomialsMap = monomialsMap;
    }

    public Polynomial() {
        this(new TreeMap<>());
    }

    public void insertMonomial(int exponent, double coefficient) {

        monomialsMap.put(exponent, coefficient);
    }

    public TreeMap<Integer, Double> getMonomialsMap() {
        return monomialsMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polynomial that = (Polynomial) o;
        return Objects.equals(monomialsMap, that.monomialsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monomialsMap);
    }

    @Override
    public String toString() {
        if(monomialsMap.size() == 1 && monomialsMap.containsValue(0d))
            return "0";
        StringBuilder returnValue = new StringBuilder();
        for (Integer exponent : monomialsMap.descendingKeySet()) {
            if (monomialsMap.get(exponent) < 0) {
                if (exponent > 1) {
                    returnValue.append((monomialsMap.get(exponent) == -1) ? ("-x^" + exponent) : (formatDouble(monomialsMap.get(exponent)) + "x^" + exponent));
                } else if (exponent == 1) {
                    returnValue.append((monomialsMap.get(exponent) == -1) ? ("-x") : (formatDouble(monomialsMap.get(exponent)) + "x"));
                } else
                    returnValue.append(formatDouble(monomialsMap.get(exponent)));
            } else if (monomialsMap.get(exponent) > 0) {
                if (exponent > 1)
                    returnValue.append((monomialsMap.get(exponent) == 1) ? ("+x^" + exponent) : ("+" + formatDouble(monomialsMap.get(exponent)) + "x^" + exponent));
                else if (exponent == 1)
                    returnValue.append((monomialsMap.get(exponent) == 1) ? ("+x") : ("+" + formatDouble(monomialsMap.get(exponent)) + "x"));
                else
                    returnValue.append("+").append(formatDouble(monomialsMap.get(exponent)));
            }
        }

        if(returnValue.length() >= 2){
            Character p0 = returnValue.charAt(0);
            Character p1 = returnValue.charAt(1);
            if (p0.equals('1') || p0.equals('+'))
                returnValue.deleteCharAt(0);
            else if (p0.equals('-') && p1.equals('1'))
                returnValue.deleteCharAt(1);
        }

        return returnValue.toString();
    }
}
