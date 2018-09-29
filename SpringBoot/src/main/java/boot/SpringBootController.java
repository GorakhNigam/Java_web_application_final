package boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootController {
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Sppring Boot Controller";
	}
	@RequestMapping("/hello")
	public String saywelcome() {
		return "hello spring boot";
	}
}
