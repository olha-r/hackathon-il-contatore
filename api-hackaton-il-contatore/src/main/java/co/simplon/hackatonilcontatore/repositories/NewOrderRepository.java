package co.simplon.hackatonilcontatore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.hackatonilcontatore.entities.NewOrder;

public interface NewOrderRepository
	extends JpaRepository<NewOrder, Long> {

    NewOrder findProjectedById(Long id);

}
