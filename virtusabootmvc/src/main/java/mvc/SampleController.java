package mvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SampleController {
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome to virtusa");
		mav.setViewName("Welcome");
		return mav;
	}
	@GetMapping("/validate")
	public ModelAndView validate(@RequestParam("empname") String empname){
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", empname);
		mav.setViewName("Welcome");
		return mav;

	}
}
