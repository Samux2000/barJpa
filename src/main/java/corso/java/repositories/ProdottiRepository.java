package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import corso.java.entities.Prodotto;

@Repository
public interface ProdottiRepository extends JpaRepository<Prodotto, Integer>{

}
