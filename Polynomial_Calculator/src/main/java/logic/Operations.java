package logic;

import model.Polynomial;

public class Operations {

    public Polynomial addition(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial returnValue = new Polynomial();

        for(Integer exponent : firstPolynomial.getMonomialsMap().keySet()){
            if(secondPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent) + secondPolynomial.getMonomialsMap().get(exponent));
            else
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent));
        }

        for(Integer exponent : secondPolynomial.getMonomialsMap().keySet()){
            if(!firstPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, secondPolynomial.getMonomialsMap().get(exponent));
        }
        return returnValue;
    }

    public Polynomial subtraction(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial returnValue = new Polynomial();

        for(Integer exponent : firstPolynomial.getMonomialsMap().keySet()){
            if(secondPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent) - secondPolynomial.getMonomialsMap().get(exponent));
            else
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent));
        }

        for(Integer exponent : secondPolynomial.getMonomialsMap().keySet()){
            if(!firstPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, -secondPolynomial.getMonomialsMap().get(exponent));
        }
        return returnValue;
    }

    public Polynomial multiplication(Polynomial firstPolynomial, Polynomial secondPolynomial){
        Polynomial returnValue = new Polynomial();

        for(Integer firstExponent : firstPolynomial.getMonomialsMap().keySet())
            for(Integer secondExponent : secondPolynomial.getMonomialsMap().keySet()){
                int exponent = firstExponent + secondExponent;
                double coefficient = firstPolynomial.getMonomialsMap().get(firstExponent) * secondPolynomial.getMonomialsMap().get(secondExponent);
                if(returnValue.getMonomialsMap().containsKey(exponent))
                    returnValue.insertMonomial(exponent, returnValue.getMonomialsMap().get(exponent) + coefficient);
                else
                    returnValue.insertMonomial(exponent, coefficient);
            }

        return returnValue;
    }

    public String division(Polynomial firstPolynomial, Polynomial secondPolynomial){return null;}

    public Polynomial derivative(Polynomial polynomial){
        Polynomial returnValue = new Polynomial();

        for(Integer exponent : polynomial.getMonomialsMap().descendingKeySet()){
            if(exponent != 0)
                returnValue.insertMonomial(exponent - 1, polynomial.getMonomialsMap().get(exponent)*exponent);
        }

        return returnValue;
    }

    public Polynomial integral(Polynomial polynomial){
        Polynomial returnValue = new Polynomial();

        for(Integer exponent : polynomial.getMonomialsMap().descendingKeySet()){
            returnValue.insertMonomial(exponent + 1, polynomial.getMonomialsMap().get(exponent)/(exponent +1));
        }

        return returnValue;
    }
}
