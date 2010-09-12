/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anticassim;

import java.awt.*;
import java.applet.*;
import java.util.Random;

/**
 *
 * @author mes
 */

/* RandomPassword
 *
 * Generates a random password
 *
 * generate() -- generates a new password string based on random algorithm using character
 *               sets as specified by options.
 * initOptions() -- initalizes options specific to this algorithm
 *
 */
public class RandomPass implements PasswordGenerator {

    static Random random;
    static String uppercase;
    static String lowercase;
    static String numbers;
    static String punctuation;
    private boolean lettersEnabled;
    private boolean numbersEnabled;
    private boolean punctuationEnabled;

    public RandomPass() {
        random = new Random();
        uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        lowercase = "abcdefghijklmnopqrstuvwxyz";
        numbers = "0123456789";
        punctuation = "~`!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";
    }

    public void setLetters(boolean enabled) {
        lettersEnabled = enabled;
    }

    public void setNumbers(boolean enabled) {
        numbersEnabled = enabled;
    }

    public void setPunctuation(boolean enabled) {
        punctuationEnabled = enabled;
    }

    // generate() -- the generator that makes random passwords
    //
    public String generate(int passLength) {
	String thePassword = "";

        String characters;
	int c;

        // TODO: available character set based on optionsn
        characters = "";
        if (lettersEnabled) {
            characters += uppercase + lowercase;
        } else if (numbersEnabled) {
            characters += numbers;
        } else if (punctuationEnabled) {
            characters += punctuation;
        }

	for (int i = 0; i < passLength; i++) {
	    c = random.nextInt(characters.length());	// pick chars out of charset
	    thePassword += characters.charAt(c);
	}
	return thePassword;
    }

}

