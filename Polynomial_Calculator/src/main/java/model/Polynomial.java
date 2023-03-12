package model;

import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Integer> monomialsMap;

    public Polynomial(){
        monomialsMap = new TreeMap<>();
    }

    public void insertMonomial(int exponent, int coefficient){

        monomialsMap.put(exponent, coefficient);
    }

    public TreeMap<Integer, Integer> getMonomialsMap(){
        return monomialsMap;
    }

    public void clear(){
        monomialsMap.clear();
    }

    @Override
    public String toString() {
        StringBuilder returnValue = new StringBuilder();
        for(Integer exponent : monomialsMap.descendingKeySet()){
            if(returnValue.isEmpty() || monomialsMap.get(exponent) < 0){
                if(monomialsMap.get(exponent) != 0){
                    if(exponent > 1) {
                        returnValue.append((monomialsMap.get(exponent).equals(-1)) ? ("-x^" + exponent) : (monomialsMap.get(exponent) + "x^" + exponent));
                    } else if(exponent == 1){
                        returnValue.append((monomialsMap.get(exponent).equals(-1)) ? ("-x") : (monomialsMap.get(exponent) + "x"));
                    }
                    else
                        returnValue.append(monomialsMap.get(exponent));
                }
            } else{
                if(monomialsMap.get(exponent) != 0){
                    if(exponent > 1)
                        returnValue.append((monomialsMap.get(exponent).equals(1)) ? ("+x^" + exponent) : ("+" + monomialsMap.get(exponent) + "x^" + exponent));
                    else if(exponent == 1)
                        returnValue.append((monomialsMap.get(exponent).equals(1)) ? ("+x") : ("+" + monomialsMap.get(exponent) + "x"));
                    else
                        returnValue.append("+").append(monomialsMap.get(exponent));
                }
            }
        }

        return returnValue.toString();
    }
}
