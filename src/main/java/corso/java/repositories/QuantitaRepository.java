package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.Quantita;

@Repository
public interface QuantitaRepository extends JpaRepository<Quantita, Integer>{

}
