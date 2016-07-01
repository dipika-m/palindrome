package palindrome.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author dipika.mulchandani
 *
 */
/**
 * @author dipika.mulchandani
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Innovator {
	@JsonProperty
	private String fname;
	@JsonProperty
	private String lname;

	/**
	 * @returns Fname of the Innovator
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param Fname
	 *            of the Innovator sets fName
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @returns Lname of the Innovator
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname
	 *            of the Innovator sets lName
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Innovator{" + "fname='" + fname + '\'' + ", lname=" + lname + '}';
	}
}
