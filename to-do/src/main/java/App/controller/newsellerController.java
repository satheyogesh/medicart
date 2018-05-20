package App.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import App.userinfo.Seller;
import App.service.*;

@Controller
public class newsellerController {

	@Autowired
	private SellerService service;

	@GetMapping("/seller")	
	public String home(ModelMap model )
	{
		//request.setAttribute("mode", "MODE_HOME");
		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "newseller";
	}
	
	@RequestMapping(value="/newseller", method = RequestMethod.GET)
	public String createSeller(ModelMap model){


		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_NEW");

		return "newseller";
	}
	
	@RequestMapping(value="/saveseller", method = RequestMethod.GET)
	public String saveSeller(ModelMap model){

		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
			return "newseller";
	}
	
	@RequestMapping(value="/newseller", method = RequestMethod.POST)
	public String saveSeller(@ModelAttribute Seller sell, BindingResult bindingResult,ModelMap model){

		service.addSellerData(sell);
		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		
		
		return "redirect:/saveseller";
	}
	
	@RequestMapping(value="/updateseller", method = RequestMethod.GET)
	public String updateTask(@RequestParam long id,ModelMap model)
	{
		Seller s = service.findOne(id);
		model.addAttribute("sellerobj",s);
		model.addAttribute("mode", "MODE_UPDATE");
		return "newseller";
	}
	
	@RequestMapping(value="/deleteseller", method = RequestMethod.GET)
	public String deleteTask(@RequestParam long id,ModelMap model)
	{
		service.deleteSellerData(id);
		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "newseller";
	}
	
	@RequestMapping(value="/error", method = RequestMethod.POST)
	public String error(ModelMap model){


		return "403";
	}
	
}
