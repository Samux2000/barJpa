package corso.java.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Pietanza extends Prodotto{

	private boolean vegano;

	public Pietanza(String nome, double prezzo, boolean vegano) {
		super(nome, prezzo);
		this.vegano = vegano;
	}
	
	
}
