package App.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import App.taskdao.OrderRepository;
import App.userinfo.Order;
import App.userinfo.Seller;

@Service
public class OrderService {

	@Autowired
	private OrderRepository wRepository;
	
	@Autowired
	private OrderService orderService;

	
	public List<Order> findAll(){
		List<Order> orderList = new ArrayList<Order>();
		for(Order s : wRepository.findAll())
		{
			orderList.add(s);
		}
		return orderList;
	}
	
    public Order findOne(long  id) {
    	return wRepository.findOne(id);
    }
    
    public void addOrderData(Order ord)
    {
		   wRepository.save(ord);
    }
    


}
