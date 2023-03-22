package model;

import logic.DoubleFormat;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Double> monomialsMap;

    public Polynomial(TreeMap<Integer, Double> monomialsMap){
        this.monomialsMap = monomialsMap;
    }

    public Polynomial(){
        this(new TreeMap<>());
    }

    public void insertMonomial(int exponent, double coefficient){

        monomialsMap.put(exponent, coefficient);
    }

    public TreeMap<Integer, Double> getMonomialsMap(){
        return monomialsMap;
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        for(Integer exponent : monomialsMap.descendingKeySet()){
            if(returnValue.isEmpty() || monomialsMap.get(exponent) < 0){
                if(monomialsMap.get(exponent) != 0){
                    if(exponent > 1) {
                        returnValue.append((monomialsMap.get(exponent) == -1) ? ("-x^" + exponent) : (DoubleFormat.formatDouble(monomialsMap.get(exponent)) + "x^" + exponent));
                    } else if(exponent == 1){
                        returnValue.append((monomialsMap.get(exponent) == -1) ? ("-x") : (DoubleFormat.formatDouble(monomialsMap.get(exponent))+ "x"));
                    }
                    else
                        returnValue.append(DoubleFormat.formatDouble(monomialsMap.get(exponent)));
                }
            } else{
                if(monomialsMap.get(exponent) != 0){
                    if(exponent > 1)
                        returnValue.append((monomialsMap.get(exponent) == 1) ? ("+x^" + exponent) : ("+" + DoubleFormat.formatDouble(monomialsMap.get(exponent))+ "x^" + exponent));
                    else if(exponent == 1)
                        returnValue.append((monomialsMap.get(exponent) == 1) ? ("+x") : ("+" + DoubleFormat.formatDouble(monomialsMap.get(exponent)) + "x"));
                    else
                        returnValue.append("+").append(DoubleFormat.formatDouble(monomialsMap.get(exponent)));
                }
            }
        }

        return returnValue.toString();
    }
}
