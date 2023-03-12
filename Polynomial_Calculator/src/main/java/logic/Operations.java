package logic;

import model.Polynomial;

import java.util.Map;
import java.util.TreeMap;

public class Operations {

    public Polynomial addition(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial returnValue = new Polynomial();
        TreeMap<Integer, Integer> firstMonomialsMap = firstPolynomial.getMonomialsMap();
        TreeMap<Integer, Integer> secondMonomialsMap = secondPolynomial.getMonomialsMap();

        for(Integer exponent : firstMonomialsMap.keySet()){
            if(secondMonomialsMap.containsKey(exponent))
                returnValue.insertMonomial(exponent, firstMonomialsMap.get(exponent) + secondMonomialsMap.get(exponent));
            else
                returnValue.insertMonomial(exponent, firstMonomialsMap.get(exponent));
        }

        for(Integer exponent : secondMonomialsMap.keySet()){
            if(!firstMonomialsMap.containsKey(exponent))
                returnValue.insertMonomial(exponent, secondMonomialsMap.get(exponent));
        }
        return returnValue;
    }


    public Polynomial subtraction(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial returnValue = new Polynomial();
        TreeMap<Integer, Integer> firstMonomialsMap = firstPolynomial.getMonomialsMap();
        TreeMap<Integer, Integer> secondMonomialsMap = secondPolynomial.getMonomialsMap();

        for(Integer exponent : firstMonomialsMap.keySet()){
            if(secondMonomialsMap.containsKey(exponent))
                returnValue.insertMonomial(exponent, firstMonomialsMap.get(exponent) - secondMonomialsMap.get(exponent));
            else
                returnValue.insertMonomial(exponent, firstMonomialsMap.get(exponent));
        }

        for(Integer exponent : secondMonomialsMap.keySet()){
            if(!firstMonomialsMap.containsKey(exponent))
                returnValue.insertMonomial(exponent, -secondMonomialsMap.get(exponent));
        }
        return returnValue;
    }

    public Polynomial multiplication(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial returnValue = new Polynomial();
        TreeMap<Integer, Integer> firstMonomialsMap = firstPolynomial.getMonomialsMap();
        TreeMap<Integer, Integer> secondMonomialsMap = secondPolynomial.getMonomialsMap();

        for(Integer firstExponent : firstMonomialsMap.keySet())
            for(Integer secondExponent : secondMonomialsMap.keySet()){
                int exponent = firstExponent + secondExponent;
                int coefficient = firstMonomialsMap.get(firstExponent) * secondMonomialsMap.get(secondExponent);
                if(returnValue.getMonomialsMap().containsKey(exponent))
                    returnValue.insertMonomial(exponent, returnValue.getMonomialsMap().get(exponent) + coefficient);
                else
                    returnValue.insertMonomial(exponent, coefficient);
            }

        return returnValue;
    }

    public String division(){return null;}

    public Polynomial derivation(Polynomial polynomial){
        Polynomial returnValue = new Polynomial();
        TreeMap<Integer, Integer> monomialsMap = polynomial.getMonomialsMap();

        for(Integer exponent : monomialsMap.descendingKeySet()){
            if(exponent != 0)
                returnValue.insertMonomial(exponent - 1, monomialsMap.get(exponent)*exponent);
        }

        return returnValue;
    }

    public String integral(){return null;}
}
