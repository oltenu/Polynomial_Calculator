package logic;

import model.Polynomial;
import java.util.Map;

public class Operations {

    public Polynomial addition(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial returnValue = new Polynomial();

        for (Integer exponent : firstPolynomial.getMonomialsMap().keySet()) {
            if (secondPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent) + secondPolynomial.getMonomialsMap().get(exponent));
            else
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent));
        }

        for (Integer exponent : secondPolynomial.getMonomialsMap().keySet()) {
            if (!firstPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, secondPolynomial.getMonomialsMap().get(exponent));
        }
        return returnValue;
    }

    public Polynomial subtraction(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial returnValue = new Polynomial();

        for (Integer exponent : firstPolynomial.getMonomialsMap().keySet()) {
            if (secondPolynomial.getMonomialsMap().containsKey(exponent)) {
                if (firstPolynomial.getMonomialsMap().get(exponent) - secondPolynomial.getMonomialsMap().get(exponent) != 0)
                    returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent) - secondPolynomial.getMonomialsMap().get(exponent));
            } else {
                returnValue.insertMonomial(exponent, firstPolynomial.getMonomialsMap().get(exponent));
            }
        }

        for (Integer exponent : secondPolynomial.getMonomialsMap().keySet()) {
            if (!firstPolynomial.getMonomialsMap().containsKey(exponent))
                returnValue.insertMonomial(exponent, -secondPolynomial.getMonomialsMap().get(exponent));
        }
        return returnValue;
    }

    public Polynomial multiplication(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial returnValue = new Polynomial();
        Polynomial zeroTest = new Polynomial();
        zeroTest.insertMonomial(0, 0);
        if(firstPolynomial.equals(zeroTest) || secondPolynomial.equals(zeroTest))
            return zeroTest;

        for (Integer firstExponent : firstPolynomial.getMonomialsMap().keySet())
            for (Integer secondExponent : secondPolynomial.getMonomialsMap().keySet()) {
                int exponent = firstExponent + secondExponent;
                double coefficient = firstPolynomial.getMonomialsMap().get(firstExponent) * secondPolynomial.getMonomialsMap().get(secondExponent);
                if (returnValue.getMonomialsMap().containsKey(exponent))
                    returnValue.insertMonomial(exponent, returnValue.getMonomialsMap().get(exponent) + coefficient);
                else
                    returnValue.insertMonomial(exponent, coefficient);
            }

        return returnValue;
    }

    public String division(Polynomial firstPolynomial, Polynomial secondPolynomial) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();
        Polynomial dividend;
        Polynomial divisor;
        if (firstPolynomial.getMonomialsMap().lastKey() > secondPolynomial.getMonomialsMap().lastKey()) {
            divisor = secondPolynomial;
            dividend = firstPolynomial;
        } else {
            divisor = firstPolynomial;
            dividend = secondPolynomial;
        }

        remainder.insertMonomial(0, 0);

        while ((!dividend.getMonomialsMap().isEmpty() && !divisor.getMonomialsMap().isEmpty()) && dividend.getMonomialsMap().lastKey() >= divisor.getMonomialsMap().lastKey()) {
            Map.Entry<Integer, Double> dividendEntry = dividend.getMonomialsMap().lastEntry();
            Map.Entry<Integer, Double> divisorEntry = divisor.getMonomialsMap().lastEntry();
            double coefficient = dividendEntry.getValue() / divisorEntry.getValue();
            int exponent = dividendEntry.getKey() - divisorEntry.getKey();
            if (quotient.getMonomialsMap().containsKey(exponent))
                quotient.insertMonomial(exponent, quotient.getMonomialsMap().get(exponent) + coefficient);
            else
                quotient.insertMonomial(exponent, coefficient);
            Polynomial tempMul = new Polynomial();
            tempMul.insertMonomial(exponent, coefficient);
            Polynomial dividendMulQuotient = multiplication(divisor, tempMul);
            remainder = subtraction(dividend, dividendMulQuotient);
            dividend = remainder;
        }

        return "Q:" + quotient + " R:" + remainder;
    }

    public Polynomial derivative(Polynomial polynomial) {
        Polynomial returnValue = new Polynomial();

        for (Integer exponent : polynomial.getMonomialsMap().descendingKeySet()) {
            if (exponent != 0)
                returnValue.insertMonomial(exponent - 1, polynomial.getMonomialsMap().get(exponent) * exponent);
            else {
                returnValue.insertMonomial(0, returnValue.getMonomialsMap().getOrDefault(0, 0d));
            }
        }

        return returnValue;
    }

    public Polynomial integral(Polynomial polynomial) {
        Polynomial returnValue = new Polynomial();

        for (Integer exponent : polynomial.getMonomialsMap().descendingKeySet()) {
            returnValue.insertMonomial(exponent + 1, polynomial.getMonomialsMap().get(exponent) / (exponent + 1));
        }

        return returnValue;
    }
}
