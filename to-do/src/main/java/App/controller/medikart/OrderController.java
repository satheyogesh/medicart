package App.controller.medikart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import App.service.OrderService;
import App.service.SellerService;
import App.userinfo.Order;
import App.userinfo.Seller;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService service;

	
	@RequestMapping(value="/orders", method = RequestMethod.GET)
	public String home(ModelMap model )
	{
		//request.setAttribute("mode", "MODE_HOME");
		model.addAttribute("orderList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");		
		return "orders";
	}
	
	@RequestMapping(value="/orders/{id}", method = RequestMethod.GET)
	public String updateOrder(@PathVariable("id") long id /* @RequestParam long id*/,ModelMap model)
	{
		Order s = service.findOne(id);
		model.addAttribute("orderobj",s);
		model.addAttribute("mode", "MODE_UPDATE");
		
		List<String> list = new ArrayList<String>();

		list.add("Pending");
		list.add("Inprogress");
		list.add("Done");
	
		model.addAttribute("status", list);
		
		model.addAttribute("selectedStatus", s.getStatus());
		
		
		return "orders";
	}
	
	@RequestMapping(value="/saveorder", method = RequestMethod.POST)
	public String saveSeller(@ModelAttribute Order ord, BindingResult bindingResult,ModelMap model){

		service.addOrderData(ord);
		model.addAttribute("orderList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		
		
		return "redirect:/orders";
	}
	
	@RequestMapping(value="/saveorder", method = RequestMethod.GET)
	public String saveSeller(ModelMap model){

		model.addAttribute("sellerList", service.findAll());
		model.addAttribute("mode", "MODE_DETAILS");
		return "orders";
	}

	
	
}
