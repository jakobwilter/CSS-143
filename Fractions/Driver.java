import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program counts unique fractions from a text file at their reduced fraction. The Driver class will create
 * a scanner to read in fractions from a file, and use it's subsidiary classes to find unique fractions and count
 * them, respectively. Only the most reduced unique fractions will output to the screen along with their frequency.
 *
 * Jakob Wilter
 * April 13, 2018
 * Fractions
 **/

public class Driver {
    public static void main(String[] args) {
        // Scanner initialized to read in fractions from a text file.
        Scanner file = null;

        //
        try {
            file = new Scanner(new FileInputStream("fractions.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not be found.");
            System.exit(0);
        }

        ObjectList fractionsList = new ObjectList();

        // While the text file still contains unread lines, method will continue to build fractions.
        while (file.hasNextLine()) {
            String fraction = file.nextLine();
            Scanner split = new Scanner(fraction);
            split.useDelimiter("/");
            int numerator = split.nextInt();
            int denominator = split.nextInt();
            Fraction value = new Fraction(numerator, denominator);

            // boolean equivalent checks if fractions are identical.
            boolean equivalent = false;
            for (int index = 0; index < fractionsList.size(); index++) {
                if (((FractionCounter) fractionsList.get(index)).compareAndIncrement(value)) {
                    equivalent = true;
                    break;
                }
            }

            // Checks if the unique reduced fraction has already been read in.
            // If false, fraction will be stored into the fractions list.
            if (equivalent == false) {
                fractionsList.add(new FractionCounter(value));
            }
            split.close();
        }

        // Checks whether there are still fractions to be read in.
        if (fractionsList.size() == 0) {
            System.out.println("Fraction not available.");
        }
        for (int j = 0; j < fractionsList.size(); j++) {
            System.out.println(fractionsList.get(j));
        }
    }
}
