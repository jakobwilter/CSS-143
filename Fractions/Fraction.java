/**
 * Fraction class examines the ratio between the numerator and the denominator of a fraction.
 * This class aims to store the most reduced form of each unique fraction read in from the text file.
 * This class will also count the number of fractions that have been read in from the file.
 *
 * Jakob Wilter
 * April 13, 2018
 * Fractions
 **/

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public void setNumerator(int num){
        numerator = num;
    }

    public void setDenominator(int den){
        denominator = den;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Implemented into FractionCounter class to checks whether the unique reduced fraction has already been read in.
    public boolean equals(Fraction other) {
        if (other.numerator == numerator && other.denominator == denominator) {
            return true;
        }
        return false;
    }

    /**
    * reduce function throws Arithmetic exceptions and test for unusual cases. It will take unique fractions
    * and find their lowest most reduced fraction. This will allow counter to identify unique matches within the array.
    **/
    private void reduce() throws ArithmeticException {
        if (denominator == 0) { //0 cannot be read in a fraction if it is in the place of the denominator variable.
            throw new ArithmeticException();
        }
        if (numerator == 0) {
            denominator = 1;
            return;
        }

        // Check for boundary and unusual cases. Ensures that all fractions are accounted for.
        int numeratorCase = 0;
        if (numerator < 0) {
            numeratorCase++;
        }
        if (denominator < 0) {
            numeratorCase++;
        }
        if (numeratorCase == 1) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        } else if (numeratorCase == 2) {
            numerator = -numerator;
            denominator = -denominator;
        }

        // Identifies the greatest common denominator ('gcd') of the number and the variable denominator.
        int gcd = Math.min(numerator, denominator);
        for (int i = gcd; i > 1; i--) {
            gcd = 1;
            if ((numerator % i == 0) && (denominator % i) == 0) {
                gcd = i;
                break;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }
}
