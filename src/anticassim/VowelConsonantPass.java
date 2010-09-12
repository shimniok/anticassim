/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anticassim;

import java.util.Random;

/**
 *
 * @author mes
 */
public class VowelConsonantPass implements PasswordGenerator {

    static Random random;
    static String vowels;
    static String consonants;

    public VowelConsonantPass() {
        random = new Random();
        vowels = "aeiou";
        consonants = "bcdfghjklmnpqrstvwxyz";
    }

    public String generate(int passLength) {
	String thePassword = "";
	int which = random.nextInt(2); // determines whether vowel(even) or consonant(odd)

	for (int i = 0; i < passLength; i++) {

	    if (which++ % 2 == 0) {
		thePassword += vowels.charAt( random.nextInt(vowels.length()) );
	    }
	    else {
		thePassword += consonants.charAt( random.nextInt(consonants.length()) );
	    }
	}
	return thePassword;
    }
}
