package logic;

import model.Polynomial;

import java.util.TreeMap;

public class Operations {

    public Polynomial addition(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial sum = new Polynomial();
        TreeMap<Integer, Integer> firstMonomialsMap = firstPolynomial.getMonomialsMap();
        TreeMap<Integer, Integer> secondMonomialsMap = secondPolynomial.getMonomialsMap();

        for(Integer exponent : firstMonomialsMap.keySet()){
            if(secondMonomialsMap.containsKey(exponent))
                sum.insertMonomial(exponent, firstMonomialsMap.get(exponent) + secondMonomialsMap.get(exponent));
            else
                sum.insertMonomial(exponent, firstMonomialsMap.get(exponent));
        }

        for(Integer exponent : secondMonomialsMap.keySet()){
            if(!firstMonomialsMap.containsKey(exponent))
                sum.insertMonomial(exponent, secondMonomialsMap.get(exponent));
        }
        return sum;
    }

    public Polynomial subtraction(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial sub = new Polynomial();
        TreeMap<Integer, Integer> firstMonomialsMap = firstPolynomial.getMonomialsMap();
        TreeMap<Integer, Integer> secondMonomialsMap = secondPolynomial.getMonomialsMap();

        for(Integer exponent : firstMonomialsMap.keySet()){
            if(secondMonomialsMap.containsKey(exponent))
                sub.insertMonomial(exponent, firstMonomialsMap.get(exponent) - secondMonomialsMap.get(exponent));
            else
                sub.insertMonomial(exponent, firstMonomialsMap.get(exponent));
        }

        for(Integer exponent : secondMonomialsMap.keySet()){
            if(!firstMonomialsMap.containsKey(exponent))
                sub.insertMonomial(exponent, -secondMonomialsMap.get(exponent));
        }
        return sub;
    }

    public String multiplication(){return null;}

    public String division(){return null;}

    public String derivation(){return null;}

    public String integral(){return null;}
}
