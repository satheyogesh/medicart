package App.taskdao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import App.userinfo.Order;

@Repository
public interface OrderRepository  extends CrudRepository<Order,Long>  {
	
}
