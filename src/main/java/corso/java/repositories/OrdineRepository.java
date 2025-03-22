package corso.java.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Ordine;

public interface OrdineRepository extends JpaRepository<Ordine, Integer>{

	List<Ordine> findAll();
	List<Ordine> findAllByEvasoTrue();
}
