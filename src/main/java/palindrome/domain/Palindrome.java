package palindrome.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author dipika.mulchandani
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Palindrome {

	@JsonProperty
	private String name;
	@JsonProperty
	private Long count;
   
	public Palindrome(String name, long count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
