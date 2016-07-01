package palindrome.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author dipika.mulchandani
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patent {
	@JsonProperty
	private String category;
	@JsonProperty
	private ArrayList<Innovator> innovator;

	public Patent() {
	}

	/**
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<Innovator> getInnovator() {
		return innovator;
	}

	public void setInnovator(ArrayList<Innovator> innovator) {
		this.innovator = innovator;
	}

	@Override
	public String toString() {
		return "Value{" + "category=" + category + ", innovator='" + innovator.toString() + '\'' + '}';
	}
}
