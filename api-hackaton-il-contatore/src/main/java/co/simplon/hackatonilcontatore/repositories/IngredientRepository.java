package co.simplon.hackatonilcontatore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.hackatonilcontatore.entities.Ingredient;

@Repository
public interface IngredientRepository
	extends JpaRepository<Ingredient, Long> {

}
