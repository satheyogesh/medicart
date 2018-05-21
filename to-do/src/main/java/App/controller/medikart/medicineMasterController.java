package App.controller.medikart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class medicineMasterController {

	@GetMapping("/medicinemaster")
	public String home(ModelMap model)
	{
		return "medicineMaster";
	}
}
