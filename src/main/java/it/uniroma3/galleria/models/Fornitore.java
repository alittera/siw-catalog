package it.uniroma3.galleria.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Fornitore")
public class Fornitore {

	// Dell’fornitore sono di interesse nome, indirizzo, email e i prodotti.
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nome;
	private String indirizzo;
	private String email;

	@ManyToMany
	private List<Prodotto> prodotti;

	public Fornitore(){}

	public Fornitore(String name, String indirizzo, String email)
	{
		this.nome=name;
		this.indirizzo=indirizzo;
		this.email=email;

	}

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getNome() { return nome; }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString(){
		return "id="+id+", nome="+nome+", indirizzo="+indirizzo+", email="+email;
	}

	//public void addProdotto(Prodotto prodotto){ this.prodotti.add(prodotto);}

	//public List<Prodotto> getProdotti(){ return this.prodotti; }

	public boolean equals(Fornitore fornitore)
	{
		boolean whetherEquals=false;
		if(fornitore.getNome().equals(this.nome) && this.indirizzo.equals(fornitore.getIndirizzo()) && this.email.equals(fornitore.getEmail()))
			whetherEquals=true;
		return whetherEquals;
	}
}