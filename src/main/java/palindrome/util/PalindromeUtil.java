package palindrome.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import palindrome.domain.Innovator;
import palindrome.domain.Palindrome;
import palindrome.domain.Palindromes;
import palindrome.domain.Patent;
import palindrome.domain.Result;
/**
 * @author dipika.mulchandani
 *
 */
public class PalindromeUtil {

	public static Palindromes getPalindromes(Result result) {
		List<Palindrome> palindromes = new ArrayList<Palindrome>();
		if (result == null || result.getPatents() == null) {
			return new Palindromes("There are no result for specified query.");
		}

		ArrayList<Patent> patents = result.getPatents();
		for (Patent patent : patents) {
			for (Innovator innovator : patent.getInnovator()) {
				String name = innovator.getFname().concat(innovator.getLname());
				String nameS = innovator.getFname().concat(" ").concat(innovator.getLname());
				long count = getPalindromeCount(name);
				palindromes.add(new Palindrome(nameS, count));
			}
		}
		Collections.sort(palindromes, (o1, o2) -> o2.getCount().compareTo(o1.getCount()));

		return new Palindromes(palindromes);

	}
   /**
    * @param name
    * <p>This method gets the palindrome count for the parameter name
    * Name should be treated as case-insensitive (i.e. b and B is the same letter) 
    * and all white-spaces should be ignored. A valid palindromic string is one that 
    * uses only the letters in the given name, and is the same length as the given name. 
    * Each letter can be used more than once, and not every letter must be used. 
    * For example, given the name "Graham Bell", "aaahhhhaaa" and "bellmmlleb" are valid, 
    * but "aaa" and "hhhsagtbbb" are not.
    * </p>
    * */
	public static  long getPalindromeCount(String name) {
		long count;
		char[] charArray = name.toCharArray();
		//Find the number of character in the name
		int numberofChars = charArray.length;
		// Store the characters in the Hashset to get the unique characters
		HashSet<Character> charSet = new HashSet<Character>(numberofChars);
		for (Character character : charArray) {
			charSet.add(character);
		}
		int uniqueChars = charSet.size();
        /* Check if the number of characters is even then calculate with the formula
         *  u^n/2
         *  else if the number of characters is odd then calculate with the formula 
         *  u^(n+1)/2
         *  where u is unique chars
         *  and n is number of chars
         */
		if (numberofChars % 2 == 0) {
			count = Math.round(Math.pow(uniqueChars, numberofChars / 2));
		} else {
			count = Math.round(Math.pow(uniqueChars, (numberofChars + 1) / 2));
		}

		return count;
	}

}
