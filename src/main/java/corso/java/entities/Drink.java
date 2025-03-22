package corso.java.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "Drinks")
public class Drink extends Prodotto{

	private boolean alcolico;
	private String quantitaCl;
	
	public Drink(String nome, double prezzo, boolean alcolico, String quantitaCl) {
		super(nome, prezzo);
		this.alcolico = alcolico;
		this.quantitaCl = quantitaCl;
	}
	
	
}
