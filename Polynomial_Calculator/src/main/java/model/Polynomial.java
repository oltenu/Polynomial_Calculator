package model;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Double> monomialsMap;

    public Polynomial(String userInput){
        monomialsMap = new TreeMap<>();
    }

    public Polynomial(){
        this("");
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
                        returnValue.append((monomialsMap.get(exponent) == -1) ? ("-x^" + exponent) : (String.format("%g", monomialsMap.get(exponent)) + "x^" + exponent));
                    } else if(exponent == 1){
                        returnValue.append((monomialsMap.get(exponent) == -1) ? ("-x") : (String.format("%g", monomialsMap.get(exponent))+ "x"));
                    }
                    else
                        returnValue.append(String.format("%g", monomialsMap.get(exponent)));
                }
            } else{
                if(monomialsMap.get(exponent) != 0){
                    if(exponent > 1)
                        returnValue.append((monomialsMap.get(exponent) == 1) ? ("+x^" + exponent) : ("+" + String.format("%g", monomialsMap.get(exponent))+ "x^" + exponent));
                    else if(exponent == 1)
                        returnValue.append((monomialsMap.get(exponent) == 1) ? ("+x") : ("+" + String.format("%g", monomialsMap.get(exponent)) + "x"));
                    else
                        returnValue.append("+").append(String.format("%g", monomialsMap.get(exponent)));
                }
            }
        }

        return returnValue.toString();
    }
}
