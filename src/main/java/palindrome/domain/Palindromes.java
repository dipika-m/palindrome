package palindrome.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * @author dipika.mulchandani
 *
 */
public class Palindromes {
	@JsonProperty
	private List<Palindrome> palindromes;
	@JsonProperty
	private String error;

	public Palindromes(String error) {
		super();
		this.error = error;
	}

	public Palindromes(List<Palindrome> palindromes) {
		super();
		this.palindromes = palindromes;
	}

	public List<Palindrome> getPalindromes() {
		return palindromes;
	}

	public void setPalindromes(ArrayList<Palindrome> palindromes) {
		this.palindromes = palindromes;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
