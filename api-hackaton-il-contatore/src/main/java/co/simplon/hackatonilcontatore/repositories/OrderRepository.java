package co.simplon.hackatonilcontatore.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.simplon.hackatonilcontatore.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	//public Order create(Order order);
	public List<Order> findAll();
	/*public Order findOrderById();
	public Order updateOrder();
	public Order deleteOrder();
*/}
