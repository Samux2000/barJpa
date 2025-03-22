package corso.java.runner;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.dialect.PostgreSQLOrdinalEnumJdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import corso.java.BarJpaApplication;
import corso.java.entities.Cliente;
import corso.java.entities.Drink;
import corso.java.entities.Ordine;
import corso.java.entities.Pietanza;
import corso.java.entities.Quantita;
import corso.java.repositories.ClienteRepository;
import corso.java.repositories.OrdineRepository;
import corso.java.repositories.ProdottiRepository;
import corso.java.repositories.QuantitaRepository;

@Component
public class MainRunner implements CommandLineRunner{

    private final BarJpaApplication barJpaApplication;

	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	private OrdineRepository ordineRepos;	
	@Autowired
	private ProdottiRepository prodottiRepos;
	@Autowired
	private ClienteRepository clienteRepos;
	@Autowired
	private QuantitaRepository quantitaRepos;

    MainRunner(BarJpaApplication barJpaApplication) {
        this.barJpaApplication = barJpaApplication;
    }
	
	@Override
	public void run(String... args) throws Exception {
		// Inserimento Prodotti nel db
		var d1 = new Drink("Acqua", 1, false, "33cl");
		var d2 = new Drink("The", 2, false, "33cl");
		var p1 = new Pietanza("Pasta", 7, true);		
		// Creazione Ordini, Cliente, Quantita
		var o1 = Ordine.builder().withDataOrdine(LocalDateTime.now()).withEvaso(false)
				.withProdotti(List.of(d1, p1)).build();
		var o2 = Ordine.builder().withDataOrdine(LocalDateTime.now()).withEvaso(true)
				.withProdotti(List.of(d2)).build();
		var q1 = Quantita.builder().withOrdine(o1).withProdotto(d1).withQuantita(2).build();
		var c1 = Cliente.builder().withNome("Sam").withCognome("DiB").withOrdini(List.of(o1)).build();
		// Salvataggio
		prodottiRepos.saveAll(List.of(d1, d2, p1));
		ordineRepos.save(o1);
		ordineRepos.save(o2);
		quantitaRepos.save(q1);
		clienteRepos.save(c1);
		
		log.info("ORDINI");
		List<Ordine> ordini = ordineRepos.findAll();
		ordini.forEach(o -> log.info("{}", o));
		log.info("ORDINI EVASI");
		ordineRepos.findAllByEvasoTrue().forEach(o -> log.info("{}", o));
	}

}
