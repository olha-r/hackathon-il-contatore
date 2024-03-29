package co.simplon.hackatonilcontatore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.hackatonilcontatore.entities.Pizza;

@Repository
public interface PizzaRepository
	extends JpaRepository<Pizza, Long> {

}
