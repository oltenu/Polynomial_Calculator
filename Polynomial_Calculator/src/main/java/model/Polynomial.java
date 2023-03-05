package model;

import java.util.Map;
import java.util.TreeMap;

public class Polynomial {
    private Map<Integer, Integer> monomialsMap;

    public Polynomial(){
        monomialsMap = new TreeMap<>();
    }

    public void extractPolynomial(String userInput){

    }

    public void clear(){
        monomialsMap.clear();
    }
}
