package corso.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
