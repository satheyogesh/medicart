package App.taskdao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import App.userinfo.Seller;

@Repository
public interface SellerRepository extends CrudRepository<Seller,Long>  {

}
