package it.uniroma3.catalog.models;

import it.uniroma3.catalog.models.Prodotto;

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
	private String telefono;

	@ManyToMany
	private List<Prodotto> prodotti;

	public Fornitore(){}

	public Fornitore(String name, String indirizzo, String email, String telefono)
	{
		this.nome=name;
		this.indirizzo=indirizzo;
        this.email=email;
        this.telefono=telefono;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public List<Prodotto> getProdotti() { return prodotti; }

    public void setProdotti(List<Prodotto> prodotti) { this.prodotti = prodotti; }

    @Override
	public String toString(){
		return "id="+id+", nome="+nome+", indirizzo="+indirizzo+", email="+email;
	}


	public boolean equals(Fornitore fornitore)
	{
		boolean whetherEquals=false;
		if(fornitore.getNome().equals(this.nome) && this.indirizzo.equals(fornitore.getIndirizzo()) && this.email.equals(fornitore.getEmail()))
			whetherEquals=true;
		return whetherEquals;
	}
}