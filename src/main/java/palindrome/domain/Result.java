package palindrome.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author dipika.mulchandani
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	@JsonProperty
	private int count;

	@JsonProperty
	private ArrayList<Patent> results;

	public Result() {
	}

	public ArrayList<Patent> getPatents() {
		return results;
	}

	public void setPatents(ArrayList<Patent> patents) {
		this.results = patents;
	}

	@Override
	public String toString() {
		return "Patent{" + "count='" + count + "results='" + results + '}';
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
