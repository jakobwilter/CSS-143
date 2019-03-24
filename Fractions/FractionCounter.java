/**
 * FractionCounter class prints data to console and is responsible for the logic which tags unique fractions to
 * their counter and increments the counter by the number of time a unique fraction is read from the fraction file.
 * FractionCounter also holds a constructor that allows theCounter and theFraction to be applied to an instance.
 * FractionCounter overrides the toString() method allowing it to return the necessary output for the program.
 *
 * Jakob Wilter
 * April 13, 2018
 * Fractions
 **/

public class FractionCounter {
    private int theCounter;
    private Fraction theFraction;

    // Compares fractions and adds to counter if equivalent
    public boolean compareAndIncrement(Fraction theFraction) {
        if (this.theFraction.equals(theFraction)) {
            theCounter++;
            return true;
        } else {
            return false;
        }
    }

    // Constructor holds the fraction object in its parameter. Add to counter when duplicates are read in.
    public FractionCounter(Fraction newFraction) {
        this.theFraction = newFraction;
        theCounter++;
    }

    // Overrides toString method to return output as a fraction with an occurrence count.
    @Override
    public String toString() {
        return (this.theFraction.getNumerator() + "/" + this.theFraction.getDenominator() + " has a count of "
                + theCounter + ".");
    }
}
