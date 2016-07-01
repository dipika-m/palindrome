package palindrome.controller;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import palindrome.domain.Palindromes;
import palindrome.domain.Result;
import palindrome.util.PalindromeUtil;

/**
 * @author dipika.mulchandani
 * 
 * <p>
 * The controller searches the NASA patents for given text and retrieve up 
 * to given number of patents. Configuration of this filter is based on
 * the following initialization parameters:</p>
 * <ul>
 * <li><strong>search</strong> - The patent search text to be configured
 *     for this request.  This parameter
 *     is required, so there is no default.</li>
 * <li><strong>limit</strong> - The parameter to be configured for the limit of searches if the
 *     client has not already specified an limit.  By default, this
 *     parameter is set to 1.</li>
 * </ul>
 *
 */
@RestController
public class PalindromeController {

	@RequestMapping("/palindromes")
	public Palindromes getPalindromes(@RequestParam(required = true) String search,
			@RequestParam(required = false, defaultValue = "1") int limit) {
		RestTemplate restTemplate = new RestTemplate();
		// // Add the Jackson message converter
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
	    // Fires the nasa's Rest api to retrive data
		if(limit < 1 || limit > 5){
			return new Palindromes("Please enter valid limit : min:1, max:5");
		}
		Result result = restTemplate.getForObject(
				"https://api.nasa.gov/patents/content?query=" + search + "&limit=" + limit + "&api_key=DEMO_KEY",
				Result.class);
		return PalindromeUtil.getPalindromes(result);

	}

	

}
